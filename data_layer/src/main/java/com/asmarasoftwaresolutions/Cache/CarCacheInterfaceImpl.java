package com.asmarasoftwaresolutions.Cache;

import android.arch.lifecycle.LiveData;

import com.asmarasoftwaresolutions.model.entities.CarEntity;

public class CarCacheInterfaceImpl implements CarCacheInterface {
    @Override
    public LiveData<CarEntity> getCar(String brand) {
        return null;
    }
}
