package com.kev.legoparts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.onClick;
import static android.R.attr.text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listPieces = (ListView) findViewById(R.id.list);
        final Spinner listSpinner = (Spinner) findViewById(R.id.listSpinner);
        final EditText textPieces = (EditText) findViewById(R.id.text);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PiecesDownloader pd = new PiecesDownloader(MainActivity.this, listPieces);
                String setId = textPieces.getText().toString();
                pd.execute(setId);
                /*Log.d("kev", "Set"+PiecesDownloader.piecesSet);
                PiecesAdapter adapter = new PiecesAdapter(MainActivity.this, PiecesDownloader.piecesSet);
                listPieces.setAdapter(adapter);*/
            }
        });
    }
}
