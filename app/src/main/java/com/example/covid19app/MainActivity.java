package com.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.covid19app.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainActivityVM> {


    private ActivityMainBinding binding;

    @Inject
    MainActivityVM mainActivityVM;

    private ProgressDialog progressDialog;

    @Override
    public int getBindingVaraiable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityVM getViewModel() {
        return mainActivityVM;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog=new ProgressDialog(this);
        binding=getViewDataBinding();

        mainActivityVM.getCovidRecords();

        mainActivityVM.loadingStatus.observe(this,aBoolean -> {
            if (aBoolean)
                showLoading();
            else
                progressDialog.dismiss();
        });

        mainActivityVM.response.observe(this,covidResponseWrapperApiResponse -> {
            if (covidResponseWrapperApiResponse!=null && covidResponseWrapperApiResponse.data!=null) {
                //do something with data(records)
            }
        });
    }

    private void showLoading() {
        progressDialog.show();
    }
}
