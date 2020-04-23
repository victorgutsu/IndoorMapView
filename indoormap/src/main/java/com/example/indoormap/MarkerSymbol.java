package com.example.indoormap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

public class MarkerSymbol extends BaseMapSymbol {
    private Bitmap mBitmap;
    private Rect mClickRect = new Rect(0, 0, 0, 0);
    private boolean isMoving = false;

    public MarkerSymbol(Context context, Position location) {
        this(context);
        mLocation = new Position(location.getX(), location.getY());
    }

    public MarkerSymbol(Context context) {
        mThreshold = 0f;
        mRotation = 0f;
        mVisibility = true;
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.marker);


        mBitmap = getResizedBitmap(mBitmap, mBitmap.getWidth()/2, mBitmap.getHeight()/2);
//        setOnMapSymbolListener(onMapSymbolListener);
    }

    private void calDisplayRect() {
        if (mBitmap != null) {
            int left = (int) (mLocation.getX() - mBitmap.getWidth() / 2);
            int right = left + mBitmap.getWidth();
            int top = (int) (mLocation.getY() - mBitmap.getHeight() / 2);
            int bottom = top + mBitmap.getHeight();
            mClickRect.set(left, top, right, bottom);
        }
    }


//    private OnMapSymbolListener onMapSymbolListener = new OnMapSymbolListener() {
//
//        @Override
//        public boolean onMapSymbolClick(BaseMapSymbol mapSymbol) {
//            return true;
//        }
//    };


    @Override
    public void draw(Canvas canvas, Matrix matrix, float scale) {
        if (!mVisibility || scale < mThreshold)
            return;
        float[] xy = {(float) mLocation.getX(), (float) mLocation.getY()};
        matrix.mapPoints(xy);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawBitmap(mBitmap,
                xy[0] - mBitmap.getWidth() / 2,
                xy[1] - mBitmap.getHeight(),
                paint);
        calDisplayRect();
    }

    @Override
    public boolean isPointInClickRect(float x, float y) {
        return isPointInRect(x, y, mClickRect);
    }

    private boolean isPointInRect(float x, float y, Rect rect) {
        return rect != null && x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom;
    }

    private Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        return Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);
    }
}
