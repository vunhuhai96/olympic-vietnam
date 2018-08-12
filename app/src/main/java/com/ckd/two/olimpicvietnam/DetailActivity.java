package com.ckd.two.olimpicvietnam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class DetailActivity extends AppCompatActivity {
    private AdView banner;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        requestAds();
        initView();
    }

    private void requestAds() {
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5155360783692513~9315846309");
        banner = (AdView) findViewById(R.id.banner_detail);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.img_detail);
        int[] image = new int[]{R.drawable.vn, R.drawable.vn2, R.drawable.vn, R.drawable.vn2};
        Random rd = new Random();
        int id = rd.nextInt(4);
        imageView.setImageResource(image[id]);

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onPause() {
        if (banner != null) {
            banner.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (banner != null) {
            banner.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (banner != null) {
            banner.destroy();
        }
        super.onDestroy();
    }
}
