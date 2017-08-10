package com.longer.demo.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.longer.demo.Application;
import com.longer.demo.R;
import com.longer.demo.base.BaseAcitvity;
import com.longer.demo.di.component.DaggerMainComponent;
import com.longer.demo.di.component.MainComponent;
import com.longer.demo.di.module.ActivityModule;
import com.longer.demo.di.module.MainModule;
import com.longer.demo.presenter.MainPresenter;
import com.longer.demo.presenter.base.HasComponent;
import com.longer.demo.ui.view.MainView;
import com.longer.service.response.ResponseResult;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.longer.com.util.ImageLoader;

public class MainActivity extends BaseAcitvity implements MainView, HasComponent<MainComponent> {

    @BindView(R.id.test)
    TextView test;

    @BindView(R.id.img)
    ImageView img;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getComponent().inject(this);

        //重要
        mainPresenter.attachView(this);
    }


    @OnClick(R.id.test)
    public void onClick() {
        mainPresenter.getLiveListResult();
    }

    @Override
    public void loginSuccess(ResponseResult result) {
        ImageLoader.load(this, result.getIcon(),img);
        Toast.makeText(this, result.getIcon(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFail() {

    }

    @Override
    public void loginException() {

    }

    @Override
    public MainComponent getComponent() {
        return DaggerMainComponent.builder()
                .applicationComponent(Application.get(this).getComponent())
                .activityModule(new ActivityModule(this))
                .mainModule(new MainModule())
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }
}
