package com.longer.demo.ui.view;

import com.longer.demo.base.MvpView;
import com.longer.service.response.ResponseResult;

/**
 * Created by longer on 2017/7/30.
 */

public interface MainView extends MvpView{
    void loginSuccess(ResponseResult result);
    void loginFail();
    void loginException();
}
