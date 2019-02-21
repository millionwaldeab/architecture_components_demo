package com.asmarasoftwaresolutions.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CarEntity {

    @PrimaryKey(autoGenerate = true)
    public int id = 1;
    public String mBrand;
    public String mYearBuilt;
    public String mType; //sedan or SUV or truck

    public CarEntity(String mBrand, String mYearBuilt, String mType) {
        this.mBrand = mBrand;
        this.mYearBuilt = mYearBuilt;
        this.mType = mType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public String getmYearBuilt() {
        return mYearBuilt;
    }

    public void setmYearBuilt(String mYearBuilt) {
        this.mYearBuilt = mYearBuilt;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }
}
