package cn.com.tianyudg.mvpdemo.mvp.view;


import cn.com.tianyudg.mvpdemo.mvp.model.BaseBean;
import cn.com.tianyudg.mvpdemo.mvp.network.ResponseInfo;

/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :
 */
public interface MvpView {


    /**
     * @return 布局resourceId
     */
    int getViewLayout();


    /**
     * 开始加载数据时回调此方法，用以显示加载ProgressDialog或者其他的的操作
     */
    void onLoading();


    /**
     * 数据加载成功后的回调
     */
    void beforeSuccess();

    /**
     * 默认请求数据解析成功后，将数据填充到View，并显示View
     *
     * @param url    请求的url
     * @param dataVo 解析成功后返回VO对象
     */
    void showContentView(String url, BaseBean dataVo);


    /**
     * 加载数据完成回调方法
     */
    void onStopLoading();


    /**
     * 加载出错
     * @param responseInfo 响应信息
     */
    void onError(ResponseInfo responseInfo);

}
