package com.jyj.ex_0224;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class RockSicssorActivity extends AppCompatActivity {
    SwipeRefreshLayout refreshLayout;
    ImageView cp,cr,cs,up,ur,us;
    Button scissor, rock,paper,start,exit;
    Random r = new Random();
    boolean s = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocksisor);


        scissor = findViewById(R.id.btn_Scissor);
        refreshLayout = findViewById(R.id.swipe);
        rock = findViewById(R.id.btn_rock);
        paper = findViewById(R.id.btn_paper);
        start = findViewById(R.id.btn_start);
        exit = findViewById(R.id.btn_exit);
        cp = findViewById(R.id.cp);
        cr = findViewById(R.id.cr);
        cs = findViewById(R.id.cs);
        up = findViewById(R.id.up);
        ur = findViewById(R.id.ur);
        us = findViewById(R.id.us);

        //swipe변경
        //디스크의 사이즈 변경
        refreshLayout.setSize(SwipeRefreshLayout.LARGE);
        refreshLayout.setProgressViewEndTarget(true,300);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //새로고침을 위해 당겼던 손을 놓는 순간
                h.sendEmptyMessageDelayed(0,300);

            }
        });



        r.nextInt(3);
        start.setOnClickListener(btn_click);


    }

    View.OnClickListener btn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_start:
                    while (s){
                        r.nextInt(3);
                        handler.sendEmptyMessage(0);

                    }

                    break;
                case R.id.btn_exit:
                    finish();
                    break;
            }
        }
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            handler.sendEmptyMessageDelayed(0,500);


        }
    };

    Handler h = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //super.handleMessage(msg);
            refreshLayout.setRefreshing(false);
        }
    };


}