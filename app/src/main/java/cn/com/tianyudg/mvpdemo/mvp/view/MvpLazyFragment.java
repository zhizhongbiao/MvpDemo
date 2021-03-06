package cn.com.tianyudg.mvpdemo.mvp.view;


import android.os.Bundle;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.ParameterizedType;

import cn.com.tianyudg.mvpdemo.R;
import cn.com.tianyudg.mvpdemo.mvp.network.ResponseInfo;
import cn.com.tianyudg.mvpdemo.mvp.presenter.MvpPresenter;
import cn.com.tianyudg.mvpdemo.mvp.reveiver.NetworkStateEvent;
import cn.com.tianyudg.mvpdemo.mvp.utils.ToastUtil;
import cn.com.tianyudg.mvpdemo.mvp.utils.UIUtils;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */

public abstract class MvpLazyFragment<P extends MvpPresenter> extends BaseFragment implements MvpView {

    protected P presenter;
    protected MaterialDialog progressDialog;
    private boolean loadSuccess;
    private boolean loadFinish; //请求是否成功
    private Bundle savedInstanceState;
    private boolean isViewCreated = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new MaterialDialog.Builder(getActivity())
                .customView(R.layout.load_data_progress_layout, false)
                .cancelable(true).build();
        progressDialog.getWindow().getDecorView().setBackgroundColor(UIUtils.getColor(android.R.color.transparent));
        EventBus.getDefault().register(this);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        isViewCreated = true;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint() && isViewCreated) {
            if (presenter == null) {
                initMvpPresenter();
            }
            loadData(this.savedInstanceState);
        }
    }

    private void initMvpPresenter() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<? extends MvpPresenter> presenterClass = (Class<? extends MvpPresenter>) type.getActualTypeArguments()[0];
        try {
            this.presenter = (P) presenterClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

        presenter.attachView(this);
    }

    /**
     * 获取请求参数，初始化vo对象，并发送请求
     *
     * @param savedInstanceState
     */
    protected abstract void loadData(Bundle savedInstanceState);

    @Override
    public void onLoading() {
        if (!progressDialog.isShowing()) {
            loadSuccess = false;
            progressDialog.show();
        }
    }

    @Override
    public void beforeSuccess() {
        loadSuccess = true;
        loadFinish = true;
    }


    @Override
    public void onError(ResponseInfo responseInfo) {
        loadFinish = true;
        switch (responseInfo.getState()) {
            case ResponseInfo.TIME_OUT:
                showTimeOutDialog(responseInfo);
                break;
            case ResponseInfo.NO_INTERNET_ERROR:
                showOpenNetworkDialog(responseInfo);
                break;
        }

    }

    private void showOpenNetworkDialog(ResponseInfo responseInfo) {
        ToastUtil.showLong("网络连接不可用，请打开网络！");
    }

    protected void showTimeOutDialog(ResponseInfo responseInfo) {
        ToastUtil.showLong("连接网络超时！");
    }


    @Subscribe
    public void onEvent(NetworkStateEvent networkStateEvent) {
        if (!networkStateEvent.hasNetworkConnected) {
            ToastUtil.showShort("网络连接已断开");
        } else {
            if (loadFinish && !loadSuccess) {
                //网络已连接数据没有加载成功，重新加载
                loadData(this.savedInstanceState);
            }
        }
    }

    @Override
    public void onStopLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
        presenter.detachView();
        presenter = null;
        EventBus.getDefault().unregister(this);
    }


}
