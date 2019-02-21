package com.asmarasoftwaresolutions.car_repository;

import com.asmarasoftwaresolutions.model.entities.CarEntity;

public interface CarRepositoryInterface {

    CarEntity getCar(String brand, String year, String type);
    void addCar(String brand, String year, String type);
}
