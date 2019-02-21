package com.asmarasoftwaresolutions.Cache;

import android.arch.lifecycle.LiveData;

import com.asmarasoftwaresolutions.model.entities.CarEntity;

public interface CarCacheInterface {
    LiveData<CarEntity> getCar(String brand);
}
