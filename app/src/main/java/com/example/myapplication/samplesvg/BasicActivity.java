package com.example.myapplication.samplesvg;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.samplesvg.helper.AssetsHelper;
import com.example.svgindoormap.SVGMapView;
import com.example.svgindoormap.SVGMapViewListener;
import com.example.svgindoormap.core.data.SVGPicture;
import com.example.svgindoormap.core.helper.ImageHelper;
import com.example.svgindoormap.core.helper.map.SVGBuilder;


public class BasicActivity extends AppCompatActivity {
    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mapView = (SVGMapView) findViewById(R.id.basic_mapview);

        mapView.registerMapViewListener(new SVGMapViewListener() {
            @Override
            public void onMapLoadComplete() {
                BasicActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(BasicActivity.this, "onMapLoadComplete", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onMapLoadError() {
                BasicActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(BasicActivity.this, "onMapLoadError", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onGetCurrentMap(Bitmap bitmap) {
                BasicActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(BasicActivity.this, "onGetCurrentMap", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        mapView.loadMap(AssetsHelper.getContent(this, "basilica.svg"));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
