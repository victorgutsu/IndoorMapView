package com.example.myapplication.samplesvg;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.samplesvg.helper.AssetsHelper;
import com.example.svgindoormap.SVGMapView;
import com.example.svgindoormap.SVGMapViewListener;


public class OperationActivity extends AppCompatActivity {
    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mapView = (SVGMapView) findViewById(R.id.operation_mapview);

        mapView.registerMapViewListener(new SVGMapViewListener() {
            @Override
            public void onMapLoadComplete() {
                OperationActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OperationActivity.this, "onMapLoadComplete", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onMapLoadError() {
                OperationActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OperationActivity.this, "onMapLoadError", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onGetCurrentMap(Bitmap bitmap) {
                 OperationActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OperationActivity.this, "onGetCurrentMap", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_operation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_rotation_gesture:
                if (item.getTitle().toString().contains("action_rotation_gesture_enabled")) {
                    mapView.getController().setRotationGestureEnabled(false);
                    item.setTitle("action_rotation_gesture_disabled");
                } else {
                    mapView.getController().setRotationGestureEnabled(true);
                    item.setTitle("action_rotation_gesture_enabled");
                }
                break;
            case R.id.action_scroll_gesture:
                if (item.getTitle().toString().contains("action_scroll_gesture_enabled")) {
                    mapView.getController().setScrollGestureEnabled(false);
                    item.setTitle("action_scroll_gesture_disabled");
                } else {
                    mapView.getController().setScrollGestureEnabled(true);
                    item.setTitle("action_scroll_gesture_enabled");
                }
                break;
            case R.id.action_zoom_gesture:
                if (item.getTitle().toString().contains("action_zoom_gesture_enabled")) {
                    mapView.getController().setZoomGestureEnabled(false);
                    item.setTitle("action_zoom_gesture_disabled");
                } else {
                    mapView.getController().setZoomGestureEnabled(true);
                    item.setTitle("action_zoom_gesture_enabled");
                }
                break;
            case R.id.action_rotate_touch_center:
                if (item.getTitle().toString().contains("action_rotate_touch_center_enabled")) {
                    mapView.getController().setRotateWithTouchEventCenterEnabled(false);
                    item.setTitle("action_rotate_touch_center_disabled");
                } else {
                    mapView.getController().setRotateWithTouchEventCenterEnabled(true);
                    item.setTitle("action_rotate_touch_center_enabled");
                }
                break;
            case R.id.action_zoom_touch_center:
                if (item.getTitle().toString().contains("action_zoom_touch_center_on")) {
                    mapView.getController().setZoomWithTouchEventCenterEnabled(false);
                    item.setTitle("action_zoom_touch_center_off");
                } else {
                    mapView.getController().setZoomWithTouchEventCenterEnabled(true);
                    item.setTitle("action_rotate_touch_center_enabled_on");
                }
                break;
            case R.id.action_zoom_double:
                mapView.getController().setCurrentZoomValue(2);
                break;
            case R.id.action_zoom_half:
                mapView.getController().setCurrentZoomValue(0.5f);
                break;
            case R.id.action_rotate_to:
                mapView.getController().setCurrentRotationDegrees(30);
                break;
            case R.id.action_get_current_map:
                mapView.getCurrentMap();
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
