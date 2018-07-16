package com.example.admin.second_weeks.presenter;

import com.example.admin.second_weeks.bean.GoodsBean;
import com.example.admin.second_weeks.model.Imodel;
import com.example.admin.second_weeks.model.Show_Model;
import com.example.admin.second_weeks.view.Iview;

public class Show_Presenter implements Ipresenter {
    private Iview iview;
    private Show_Model show_model;

    public Show_Presenter(Iview iview) {
        this.iview = iview;
        this.show_model = new Show_Model();
    }
    public void getdatas(){
        show_model.getdats(new Imodel() {
            @Override
            public void model_onSuccess(GoodsBean goodsBean, int page, String content) {
                iview.view_onSuccess(goodsBean, page, content);
            }

            @Override
            public void model_onFail(int code) {
                iview.view_onFail(code);
            }
        });
    }
    @Override
    public void presenter_onDestroys() {
        if (iview != null){
            iview = null;
        }
    }
}
