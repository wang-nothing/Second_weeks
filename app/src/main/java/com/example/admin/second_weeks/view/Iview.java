package com.example.admin.second_weeks.view;

import com.example.admin.second_weeks.bean.GoodsBean;

public interface Iview {
    void view_onSuccess(GoodsBean goodsBean, int page, String content);

    void view_onFail(int code);
}
