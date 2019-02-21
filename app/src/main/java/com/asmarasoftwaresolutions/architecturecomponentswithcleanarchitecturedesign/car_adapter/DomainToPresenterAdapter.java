package com.asmarasoftwaresolutions.architecturecomponentswithcleanarchitecturedesign.car_adapter;

import com.asmarasoftwaresolutions.architecturecomponentswithcleanarchitecturedesign.model.CarModel;
import com.asmarasoftwaresolutions.model.Car;

public class DomainToPresenterAdapter {
    public CarModel convert(Car type) {
        CarModel carModel = new CarModel();
        if(type.getmBrand().equals(carModel.getmBrand())){
            return carModel;
        }
        return null;
    }
}
