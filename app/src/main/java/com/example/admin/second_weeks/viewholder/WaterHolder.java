package com.example.admin.second_weeks.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.second_weeks.R;

public class WaterHolder extends RecyclerView.ViewHolder {
    public TextView main_tv;
    public WaterHolder(@NonNull View itemView) {
        super(itemView);
        main_tv = itemView.findViewById(R.id.main_tv);
    }
}
