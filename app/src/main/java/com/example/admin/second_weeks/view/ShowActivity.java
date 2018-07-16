package com.example.admin.second_weeks.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.admin.second_weeks.R;
import com.example.admin.second_weeks.adapter.MyAdapter;
import com.example.admin.second_weeks.bean.GoodsBean;
import com.example.admin.second_weeks.presenter.Show_Presenter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener, Iview {
    private TextView show_tv,show_tview;
    private EditText show_et;
    private PullToRefreshScrollView scrollView;
    private RecyclerView recyclerView;
    private Show_Presenter presenter;
    private List<GoodsBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initViews();
        initListener();
        initDatas();
        initOpera();

    }

    private void initOpera() {
        presenter = new Show_Presenter(this);
        presenter.getdatas();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                presenter.getdatas();
                scrollView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                presenter.getdatas();
                scrollView.onRefreshComplete();
            }
        });
    }

    private void initDatas() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        show_et.setText(text);
    }

    private void initListener() {
        show_tv.setOnClickListener(this);
        show_tview.setOnClickListener(this);

    }

    private void initViews() {
        show_et = findViewById(R.id.show_et);
        show_tv = findViewById(R.id.show_tv);
        show_tview = findViewById(R.id.show_tview);
        scrollView = findViewById(R.id.scrollView);
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_tv:
                finish();;
                break;

            case R.id.show_tview:

                break;
        }
    }

    @Override
    public void view_onSuccess(GoodsBean goodsBean, final int page, final String content) {
        data = goodsBean.getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MyAdapter myAdapter = new MyAdapter(ShowActivity.this, data);
                recyclerView.setAdapter(myAdapter);
                scrollView.onRefreshComplete();
            }
        });
    }

    @Override
    public void view_onFail(int code) {

    }
}
