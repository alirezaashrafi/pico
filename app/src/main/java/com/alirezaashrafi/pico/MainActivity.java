package com.alirezaashrafi.pico;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alirezaashrafi.library.Pico;
import com.alirezaashrafi.library.interfaces.OnBitmapLoad;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        Pico.with(this)
                .from(/*new File("/sdcard/img.jpg"*/"http://launchcapital.com/wp-content/uploads/2017/05/pico-trading-e1499456768773.png")

                .into(new OnBitmapLoad() {
                    @Override
                    public void bitmap(Bitmap bitmap) {
                        Pico.with(MainActivity.this).from(bitmap)//.smartScale()
                                .setBlur(10)
                                .setColorFilter("#33dd66")
                                //.into(img7)
                                .into(img1)
                                .into(img2)
                                .into(img3)
                                .into(img4)
                                .into(img5)
                                //.into(root)
                                //.into(relativeLayout)
                                .into(img6).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    }
                });
    }

    private ImageView img7;
    private LinearLayout root;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private RelativeLayout relativeLayout;

    public void initViews() {
        img7 = (ImageView) findViewById(R.id.img7);
        root = (LinearLayout) findViewById(R.id.root);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    }




}
