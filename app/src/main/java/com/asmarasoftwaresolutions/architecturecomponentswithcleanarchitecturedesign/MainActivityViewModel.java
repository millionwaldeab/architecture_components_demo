package com.asmarasoftwaresolutions.architecturecomponentswithcleanarchitecturedesign;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.asmarasoftwaresolutions.architecturecomponentswithcleanarchitecturedesign.car_adapter.DomainToPresenterAdapter;
import com.asmarasoftwaresolutions.architecturecomponentswithcleanarchitecturedesign.model.CarModel;
import com.asmarasoftwaresolutions.core.SuccessOrException;
import com.asmarasoftwaresolutions.model.Car;
import com.asmarasoftwaresolutions.usecase.CarUseCaseInterface;


public class MainActivityViewModel extends ViewModel {

    private LiveData<CarModel> mCarLiveData;
    private LiveData<String> mBarndLiveData;
    private CarUseCaseInterface mCarUseCaseInterface; //this is to get/retrieve data in domain layer
    private DomainToPresenterAdapter mDomainToPresenterAdapter; //this is to convert CarObject to CarModel(in presenter)

    private String TAG_MESSAGE = this.getClass().getCanonicalName();

    public MainActivityViewModel() {
        //zero argument constructor for viewmodel
    }

    //Constructor of the view model
    public MainActivityViewModel(CarUseCaseInterface mCarUseCaseInterface, DomainToPresenterAdapter mDomainToDataAdapter) {
        this.mCarUseCaseInterface = mCarUseCaseInterface;
        this.mDomainToPresenterAdapter = mDomainToDataAdapter;
    }

    public LiveData<CarModel> getCar(String brand, String year, String type) {
        this.mCarUseCaseInterface.getCar(new SuccessOrException<Car>() {
            @Override
            public void onSuccess(Car type) {
                mDomainToPresenterAdapter.convert(type);
                mCarLiveData.getValue();
            }

            @Override
            public void onExceptionThrown(Exception exc) {
                Log.e(TAG_MESSAGE, exc.getMessage());
            }
        }, brand, year, type);
        return mCarLiveData;
    }

    public LiveData<String> getBarnd() {
        return mBarndLiveData;
    }

    public void addCar(String brand, String year, String type) {
        this.mCarUseCaseInterface.addCar(brand, year, type);
    }
}
