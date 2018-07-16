package com.example.admin.second_weeks.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.second_weeks.R;
import com.example.admin.second_weeks.viewholder.WaterHolder;

import java.util.ArrayList;
import java.util.List;

public class WaterAdapter extends RecyclerView.Adapter<WaterHolder> {
    private Context context;
    private List<String> list;
    private List<Integer> heightList;

    public WaterAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            heightList.add((int) (Math.random() * 100 + 200));
        }
    }

    @NonNull
    @Override
    public WaterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.first_item, viewGroup, false);
        return new WaterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaterHolder waterHolder, int i) {
        ViewGroup.LayoutParams layoutParams = waterHolder.main_tv.getLayoutParams();
        layoutParams.height = heightList.get(i);
        waterHolder.main_tv.setBackgroundColor(Color.rgb((int) (Math.random() * 100 + 155), (int) (Math.random() * 50 + 155), (int) (Math.random() * 100 + 155)));
        waterHolder.main_tv.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
