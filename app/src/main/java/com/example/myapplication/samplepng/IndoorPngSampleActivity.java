package com.example.myapplication.samplepng;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoormap.BaseMapSymbol;
import com.example.indoormap.MapView;
import com.example.indoormap.MarkerSymbol;
import com.example.indoormap.OnRealLocationMoveListener;
import com.example.indoormap.Position;
import com.example.myapplication.R;

import java.io.IOException;
import java.util.ArrayList;

public class IndoorPngSampleActivity extends AppCompatActivity {

    private MapView mMapView;
    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indoor_png_sample_layout);

        mMapView = (MapView) findViewById(R.id.mapview);
        mInfoTextView = (TextView) findViewById(R.id.tv_current_location);


        try {
            mMapView.initNewMap(getAssets().open("basilica.png"), 1, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<BaseMapSymbol> symbols = new ArrayList<>();
        symbols.add(new MarkerSymbol(this, new Position(100, 135)));
        symbols.add(new MarkerSymbol(this, new Position(1111, 1111)));
        symbols.add(new MarkerSymbol(this, new Position(1350, 1000)));
        symbols.add(new MarkerSymbol(this, new Position(700, 700)));
        mMapView.setMapSymbols(symbols);
        mMapView.setOnRealLocationMoveListener(new OnRealLocationMoveListener() {
            @Override
            public void onMove(Position position) {
                mInfoTextView.setText(position.toString());
            }
        });
    }
}
