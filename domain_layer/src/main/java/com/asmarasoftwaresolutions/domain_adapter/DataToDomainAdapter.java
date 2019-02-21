package com.asmarasoftwaresolutions.domain_adapter;

import com.asmarasoftwaresolutions.data_objects.CarDao;
import com.asmarasoftwaresolutions.model.Car;
import com.asmarasoftwaresolutions.model.entities.CarEntity;

public class DataToDomainAdapter {
    CarDao mCarDao;
    String mBrand;

    public DataToDomainAdapter(CarDao mCarDao, String brand) {
        this.mCarDao = mCarDao;
        this.mBrand = brand;
    }

    public Car convert(CarEntity carEntity){
        Car car = new Car();
        if(carEntity.getmBrand().equals(mCarDao.getCar(mBrand).getmBrand())){
            car.setmBrand(mBrand);
            return car;
        }
        return null;
    }
}
