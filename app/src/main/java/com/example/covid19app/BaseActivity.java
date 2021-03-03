package com.example.covid19app;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import dagger.android.AndroidInjection;

public abstract class BaseActivity<T extends ViewDataBinding,V extends ViewModel> extends AppCompatActivity {

    private T viewDataBinding;
    private V viewModel;


    public abstract int getBindingVaraiable();

    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract V getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDependencyInjection();
        performDatabinding();

    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    private void performDatabinding() {
        viewDataBinding= DataBindingUtil.setContentView(this,getLayoutId());
        this.viewModel=viewModel==null?getViewModel():viewModel;
        viewDataBinding.setVariable(getBindingVaraiable(),viewModel);
        viewDataBinding.setLifecycleOwner(this);
        viewDataBinding.executePendingBindings();
    }

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }
}
