package com.example.admin.second_weeks.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.second_weeks.R;
import com.example.admin.second_weeks.bean.GoodsBean;
import com.example.admin.second_weeks.viewholder.ViewHolder;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<GoodsBean.DataBean> data;

    public MyAdapter(Context context, List<GoodsBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyc_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String path = data.get(i).getImages().split("\\|")[0];
        String title = data.get(i).getTitle();
        Glide.with(context).load(path).into(viewHolder.item_image);
        viewHolder.item_tv.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
