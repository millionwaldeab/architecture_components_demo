package com.asmarasoftwaresolutions.model;

public class Car {
    private String mBrand;
    private String mYearBuilt;
    private String mType; //sedan or SUV or truck

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
