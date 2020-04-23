package com.example.myapplication.samplesvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.samplesvg.helper.AssetsHelper;
import com.example.svgindoormap.SVGMapView;
import com.example.svgindoormap.SVGMapViewListener;
import com.example.svgindoormap.overlay.SVGMapLocationOverlay;


public class LocationOverlayActivity extends AppCompatActivity
{
    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location);

        mapView = (SVGMapView) findViewById(R.id.location_mapview);

        mapView.registerMapViewListener(new SVGMapViewListener()
        {
            @Override
            public void onMapLoadComplete()
            {
                SVGMapLocationOverlay locationOverlay = new SVGMapLocationOverlay(mapView);
                locationOverlay.setIndicatorArrowBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.indicator_arrow));
                locationOverlay.setPosition(new PointF(400, 500));
                locationOverlay.setIndicatorCircleRotateDegree(90);
                locationOverlay.setMode(SVGMapLocationOverlay.MODE_COMPASS);
                locationOverlay.setIndicatorArrowRotateDegree(-45);
                mapView.getOverLays().add(locationOverlay);
                mapView.refresh();
            }

            @Override
            public void onMapLoadError()
            {
            }

            @Override
            public void onGetCurrentMap(Bitmap bitmap)
            {
            }
        });
        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));
    }
}
