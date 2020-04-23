package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indoormap.MapView;
import com.example.indoormap.OnRealLocationMoveListener;
import com.example.indoormap.Position;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MapView mMapView;
    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = (MapView) findViewById(R.id.mapview);
        mInfoTextView = (TextView) findViewById(R.id.tv_current_location);

        try {
            mMapView.initNewMap(getAssets().open("basilica.png"), 1, 0,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMapView.updateMyLocation(new Position(652, 684));
        mMapView.setOnRealLocationMoveListener(new OnRealLocationMoveListener() {
            @Override
            public void onMove(Position position) {
                mInfoTextView.setText(position.toString());
            }
        });
    }
}
