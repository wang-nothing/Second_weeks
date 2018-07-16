package com.example.admin.second_weeks.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.second_weeks.R;

public class MyTitle extends LinearLayout implements View.OnClickListener {
    private ImageView image_sss;
    private EditText et_tv;
    private TextView tv_view;
    public MyTitle(Context context) {
        this(context,null);
    }

    public MyTitle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTitle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        inflate(context, R.layout.mytitle_show, this);
        initViews();
        initSetOnClickListener();
    }

    private void initSetOnClickListener() {
        image_sss.setOnClickListener(this);
        tv_view.setOnClickListener(this);
    }
    public String getText(){
        return et_tv.getText().toString();
    }
    private void initViews() {
        image_sss = findViewById(R.id.image_sss);
        et_tv = findViewById(R.id.et_tv);
        tv_view = findViewById(R.id.tv_view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_sss:
                viewCallback.sss(getText());
                break;

            case R.id.tv_view:
                viewCallback.tv(getText());
                break;
        }
    }
    private ViewCallback viewCallback;

    public void setViewCallback(ViewCallback viewCallback) {
        this.viewCallback = viewCallback;
    }

    public interface ViewCallback{
        void sss(String json);

        void tv(String text);
    }
}
