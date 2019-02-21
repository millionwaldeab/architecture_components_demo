package com.asmarasoftwaresolutions.usecase;

import com.asmarasoftwaresolutions.core.SuccessOrException;
import com.asmarasoftwaresolutions.model.Car;

public interface CarUseCaseInterface {
    void addCar(String brand, String year, String type);
    Car getCar(SuccessOrException<Car> successOrFailure, String brand, String year, String type);
}
