package com.example.admin.second_weeks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.admin.second_weeks.adapter.WaterAdapter;
import com.example.admin.second_weeks.custom.MyTitle;
import com.example.admin.second_weeks.view.ShowActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyTitle mytitle;
    private RecyclerView recyclerView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();
    }

    private void initListener() {
        mytitle.setViewCallback(new MyTitle.ViewCallback() {
            @Override
            public void sss(String json) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("text",json);
                startActivity(intent);
            }

            @Override
            public void tv(String text) {
                finish();
            }
        });
    }

    private void initViews() {
        mytitle = findViewById(R.id.mytitle);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            list.add("没有了");
        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        WaterAdapter waterAdapter = new WaterAdapter(MainActivity.this, list);
        recyclerView.setAdapter(waterAdapter);
    }
}
