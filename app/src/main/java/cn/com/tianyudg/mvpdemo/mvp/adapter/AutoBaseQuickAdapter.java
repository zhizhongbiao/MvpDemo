package cn.com.tianyudg.mvpdemo.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Author : WaterFlower.
 * Created on 2017/8/24.
 * Desc : 只是适配一下
 */

public abstract class AutoBaseQuickAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T,K>{

    public AutoBaseQuickAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public AutoBaseQuickAdapter(@Nullable List<T> data) {
        super(data);
    }

    public AutoBaseQuickAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected K createBaseViewHolder(View view) {
        AutoUtils.auto(view);
        return super.createBaseViewHolder(view);
    }
}
