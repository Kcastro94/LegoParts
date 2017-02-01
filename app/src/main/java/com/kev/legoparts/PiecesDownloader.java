package com.kev.legoparts;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Spinner;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DAM on 26/1/17.
 */

public class PiecesDownloader extends AsyncTask<String, String, Boolean> {

    private Context context;
    public PiecesDownloader(Context context) {
        this.context = context;
    }
    private OnPiecesLoadedListener listener = null;
    public void setOnPiecesLoadedListener(OnPiecesLoadedListener listener) {
        this.listener = listener;
    }

    private ProgressDialog pDialog;

    @Override protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Downloading file. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setCancelable(true);
        pDialog.setTitle(R.string.please_wait);
        String msg = context.getResources().getString(R.string.downloading_set);
        pDialog.setMessage(msg);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        int count;

        String setId;
        setId = "0014-1";

        try{
            URL url = new URL("http://stucom.flx.cat/lego/get_set_parts.php?key=Pi2K3OzsDV&set="+setId);

            URLConnection connection = url.openConnection();
            connection.connect();
            int lengthOfFile = connection.getContentLength();
            pDialog.setMax(lengthOfFile);
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress("" + (int) ((total * 100) / lengthOfFile));
                output.write(data, 0, count);
            }

            input.close();
            output.flush();
            String tsv = new String(output.toByteArray());
            String[] aux = tsv.split("\n");
            List<LegoPiece> piecesSet = new ArrayList<>();
            for(int i = 0; i < aux.length; i++){


                Log.d("kev", aux[i]);

                String [] name;
                name = aux[i].split("\t");
                Uri image;
                int quantity;
                LegoPiece piece = new LegoPiece();
                piecesSet.add(piece);




            }




        }catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            return false;
        }

        return true;
    }

    protected void onProgressUpdate(String... progress) {
        pDialog.setProgress(Integer.parseInt(progress[0]));
    }

    @Override public void onPostExecute(Boolean result) {
        pDialog.dismiss();
        if (listener != null) listener.onPiecesLoaded(result);
    }
}
