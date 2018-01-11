package com.alirezaashrafi.library;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.alirezaashrafi.library.interfaces.OnBitmapLoad;
import com.alirezaashrafi.library.interfaces.OnDrawableLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlirezaAshrafi on 1/5/2018.
 */

class PicoLoaded extends PicoCore implements OnLoad {


    List<OnDrawableLoad> onDrawableLoads = new ArrayList<>();
    List<OnBitmapLoad> onBitmapLoadList = new ArrayList<>();
    int blurRadius = -1;
    int color = -1;
    float rotate = -1;
    private final String TAG = this.getClass().getName();

    PicoLoaded(PicoProtected picoProtected) {
        super(picoProtected);
    }
    private Drawable drawable;
    private Handler handler;
    private Bitmap bitmap;


    private PicoScale scale() {
        return core().picoScale;
    }

    public void setBitmap(Bitmap bit) {
        this.bitmap = bit;

        if (blurRadius != -1) {
            bitmap = new PicoBlor().fastblur(bitmap, blurRadius);
        }

        if (rotate != -1) {
            rotateBitmap(rotate);
        }

        if (color!=-1){
            changeBitmapColor(color);
        }
        // todo changeBitmapColor(bitmap,Color.parseColor("#44ff55"));
        //setColor();
        resize();
        this.load();
    }

    private void resize() {
        if (scale().setWidth) {
            resizeBitmap(scale().width, bitmap.getHeight());

        } else if (scale().setHeight) {
            resizeBitmap(bitmap.getWidth(), scale().height);

        } else if (scale().setWidthHeight) {
            resizeBitmap(scale().width, scale().height);

        } else if (scale().setScalePercent || scale().setScale) {
            scaleDown(scale().scale);
        }else if (scale().setMaxWidthHeight){
            setMax(scale().max);
        }
    }

    private void runOnUiThread(Runnable r) {
        handler.post(r);
    }


    @Override
    public void load() {
        handler = new Handler(core().context.getMainLooper());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                for (OnBitmapLoad onBitmapLoad : onBitmapLoadList) {
                    if (onBitmapLoad != null) {
                        onBitmapLoad.bitmap(bitmap);
                    }
                }

                for (OnDrawableLoad onDrawableLoad : onDrawableLoads) {
                    if (onDrawableLoad != null) {
                        onDrawableLoad.drawable(getDrawable());
                    }
                }

                for (ImageView imageView : core().imageViews) {


                    if (core().scaleType != null) {
                        Log.i(TAG, "run: ");
                        imageView.setScaleType(core().scaleType);
                    }

                    if (scale().setSmartScale) {
                        imageView.setImageBitmap(resizeBitmapTemp(imageView.getWidth(), imageView.getHeight()));
                    } else {
                        imageView.setImageBitmap(bitmap);
                    }
                }
                for (View view : core().views) {

                    if (scale().setSmartScale) {
                        view.setBackgroundDrawable(getDrawable(resizeBitmapTemp(view.getWidth(), view.getHeight())));
                    } else {
                        view.setBackgroundDrawable(getDrawable());
                    }
                }

            }
        });


    }



    Drawable getDrawable() {
        if (drawable == null) {
            drawable = new BitmapDrawable(context().getResources(), bitmap);
        }
        return drawable;
    }

    Drawable getDrawable(Bitmap bitmap) {
        return new BitmapDrawable(context().getResources(), bitmap);
    }

    private void setMax(int maxImageSize) {
        float ratio = Math.min(
                (float) maxImageSize / bitmap.getWidth(),
                (float) maxImageSize / bitmap.getHeight());
        int width = Math.round((float) ratio * bitmap.getWidth());
        int height = Math.round((float) ratio * bitmap.getHeight());

        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
    }


    private void scaleDown(float ratio) {
        int width = Math.round((float) ratio * bitmap.getWidth());
        int height = Math.round((float) ratio * bitmap.getHeight());

        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
    }


    private void resizeBitmap(int newWidth, int newHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    private Bitmap resizeBitmapTemp(int newWidth, int newHeight) {
        Bitmap temp = bitmap.copy(bitmap.getConfig(), true);
        int width = temp.getWidth();
        int height = temp.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(temp, 0, 0, width, height, matrix, false);
    }


    private void changeBitmapColor(int color) {
        Bitmap resultBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth() - 1, bitmap.getHeight() - 1);
        Paint p = new Paint();
        ColorFilter filter = new LightingColorFilter(color, 1);
        p.setColorFilter(filter);
        Canvas canvas = new Canvas(resultBitmap);
        canvas.drawBitmap(resultBitmap, 0, 0, p);
        bitmap = resultBitmap;
    }

    private void rotateBitmap(float degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);

        Rect srcR = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dstR = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF deviceR = new RectF();
        matrix.mapRect(deviceR, dstR);

        int neww = Math.round(deviceR.width());
        int newh = Math.round(deviceR.height());

        Bitmap result = Bitmap.createBitmap(neww, newh, Bitmap.Config.ARGB_8888);
        result.eraseColor(Color.TRANSPARENT);
        Canvas canvas = new Canvas();
        canvas.translate(-deviceR.left, -deviceR.top);
        canvas.concat(matrix);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.setBitmap(result);
        canvas.drawBitmap(bitmap, srcR, dstR, paint);
        canvas.setBitmap(null);

        bitmap = result;
    }


}
