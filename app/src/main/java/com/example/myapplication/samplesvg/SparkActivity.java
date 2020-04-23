package com.example.myapplication.samplesvg;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.samplesvg.helper.AssetsHelper;
import com.example.svgindoormap.SVGMapView;

import java.util.Random;

public class SparkActivity extends AppCompatActivity
{

    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spark);

        mapView = (SVGMapView) findViewById(R.id.spark_mapview);
        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));

        Random random = new Random();

        for (int i = 0; i < 4; i++)
        {
            int color = i % 2 == 0 ? Color.RED : Color.BLUE;
            mapView.getController().sparkAtPoint(new PointF(random.nextInt(1000), random.nextInt(1000)), 100, color, 10);
        }

    }
}

