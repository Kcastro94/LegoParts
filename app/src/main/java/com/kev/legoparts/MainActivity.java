package com.kev.legoparts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listPieces = (ListView) findViewById(R.id.list);
        final Spinner listSpinner = (Spinner) findViewById(R.id.listSpinner);
        final TextView textPieces = (TextView) findViewById(R.id.text);

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PiecesDownloader pd = new PiecesDownloader(MainActivity.this);
                pd.execute();
                /*List<LegoPiece> piecesSet = new ArrayList<>();


                PiecesAdapter adapter = new PiecesAdapter(MainActivity.this, piecesSet);
                listPieces.setAdapter(adapter);*/
            }
        });
    }
}
