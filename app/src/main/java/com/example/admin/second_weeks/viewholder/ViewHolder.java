package com.example.admin.second_weeks.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.second_weeks.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView item_image;
    public TextView item_tv;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        item_image = itemView.findViewById(R.id.item_image);
        item_tv = itemView.findViewById(R.id.item_tv);

    }
}
