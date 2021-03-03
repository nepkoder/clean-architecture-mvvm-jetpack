package com.example.covid19app;

import androidx.lifecycle.MutableLiveData;

import com.example.covid19app.models.CovidResponseWrapper;

import javax.inject.Inject;

public class MainActivityVM extends BaseViewModel {
    final DataManager dataManager;
    public SingleLiveEvent<Boolean> loadingStatus=new SingleLiveEvent<>();
    public MutableLiveData<ApiResponse<CovidResponseWrapper>> response=new MutableLiveData<>();


    @Inject
    public MainActivityVM(DataManager dataManager) {
        super(dataManager);
        this.dataManager=dataManager;
    }

    public void getCovidRecords() {
        dataManager.getCovidRecords(new ResponseListener<CovidResponseWrapper>() {
            @Override
            public void onStart() {
                loadingStatus.setValue(true);
            }

            @Override
            public void onFinish() {
                loadingStatus.setValue(false);
            }

            @Override
            public void onResponse(ApiResponse<CovidResponseWrapper> apiResponse) {
                loadingStatus.setValue(false);
                if (apiResponse!=null && apiResponse.data!=null)
                    response.setValue(apiResponse);
            }
        });
    }
}
