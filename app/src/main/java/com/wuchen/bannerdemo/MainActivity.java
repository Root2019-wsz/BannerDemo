package com.wuchen.bannerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Integer> mBannerList = new ArrayList();
    private Banner mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initBanner();
    }

    private void initData(){
        mBannerList.add(R.drawable.lunbo01);
        mBannerList.add(R.drawable.lunbo02);
        mBannerList.add(R.drawable.lunbo03);
        mBannerList.add(R.drawable.lunbo04);
        mBannerList.add(R.drawable.lunbo05);
    }

    private void initBanner(){
        mBanner = findViewById(R.id.banner);
        mBanner.setAdapter(new BannerImageAdapter<Integer>(mBannerList) {
            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }

        });
        mBanner.isAutoLoop(true);
        mBanner.setIndicator(new CircleIndicator(this));
        mBanner.start();
    }
}