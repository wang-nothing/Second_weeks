package com.example.admin.second_weeks.model;

import android.util.Log;

import com.example.admin.second_weeks.bean.GoodsBean;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Show_Model {
    private OkHttpClient client;
    private String content = "笔记本";
    private int page = 1;
    private String url_good = "https://www.zhaoapi.cn/product/searchProducts?keywords=";
    public void getdats(final Imodel imodel){
        client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url_good + content + "&page=" + page)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {

            private GoodsBean goodsBean;

            @Override
            public void onFailure(Call call, IOException e) {
                imodel.model_onFail(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException{

                    String json = response.body().string();
                    Log.i("TAG", "onResponse: " + json.toString());
                    Gson gson = new Gson();
                    goodsBean = gson.fromJson(json, GoodsBean.class);
                    imodel.model_onSuccess(goodsBean, page, content);

            }
        });
    }
}
