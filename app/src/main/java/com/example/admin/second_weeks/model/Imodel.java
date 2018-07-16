package com.example.admin.second_weeks.model;

import com.example.admin.second_weeks.bean.GoodsBean;

public interface Imodel {
    void model_onSuccess(GoodsBean goodsBean, int page, String content);

    void model_onFail(int code);
}
