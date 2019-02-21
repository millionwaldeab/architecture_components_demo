package com.asmarasoftwaresolutions.data_objects;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.asmarasoftwaresolutions.model.entities.CarEntity;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CarDao {

    @Insert(onConflict = REPLACE)
    void addCar(CarEntity car);

    @Query("SELECT * FROM CarEntity WHERE mBrand = :brand")
    CarEntity getCar(String brand);
}
