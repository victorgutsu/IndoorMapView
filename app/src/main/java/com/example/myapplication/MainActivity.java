package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.samplepng.IndoorPngSampleActivity;
import com.example.myapplication.samplesvg.BasicActivity;
import com.example.myapplication.samplesvg.CustomOverlayActivity;
import com.example.myapplication.samplesvg.LocationOverlayActivity;
import com.example.myapplication.samplesvg.OperationActivity;
import com.example.myapplication.samplesvg.SparkActivity;


public class MainActivity extends AppCompatActivity {

    private ListView mSelectListView;
    private ArrayAdapter<String> mAdapter;
    private Class[] mClasses = {IndoorPngSampleActivity.class,
            BasicActivity.class,
            OperationActivity.class,
            LocationOverlayActivity.class,
            SparkActivity.class,
            CustomOverlayActivity.class};
    private String[] mClassesToString = {"IndoorPngSampleActivity",
            "BasicActivitySVG",
            "OperationActivitySVG",
            "LocationOverlayActivitySVG",
            "SparkActivitySVG",
            "CustomOverlayActivitySVG"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }


    private void initialize() {
        mSelectListView = findViewById(R.id.main_select_lv);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mClassesToString);
        mSelectListView.setAdapter(mAdapter);
        mSelectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, mClasses[position]));
            }
        });
    }


}
