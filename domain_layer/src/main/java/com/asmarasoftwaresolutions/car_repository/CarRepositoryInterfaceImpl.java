package com.asmarasoftwaresolutions.car_repository;

import com.asmarasoftwaresolutions.data_objects.CarDao;
import com.asmarasoftwaresolutions.model.entities.CarEntity;

public class CarRepositoryInterfaceImpl implements CarRepositoryInterface {

    private CarDao mCarDao;
    private CarEntity mCarEntity;

    public CarRepositoryInterfaceImpl(CarDao mCarDao) {
        this.mCarDao = mCarDao;
    }

    @Override
    public CarEntity getCar(String brand, String year, String type) {
        mCarEntity = new CarEntity(brand, year, type);
        return mCarEntity;
    }

    @Override
    public void addCar(String brand, String year, String type) {
        mCarEntity = new CarEntity(brand, year, type);
        mCarDao.addCar(mCarEntity);
    }
}
