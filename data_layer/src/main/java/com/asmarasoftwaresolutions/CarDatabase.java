package com.asmarasoftwaresolutions;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.asmarasoftwaresolutions.data_objects.CarDao;
import com.asmarasoftwaresolutions.model.entities.CarEntity;


@Database(entities = {CarEntity.class}, version = 1)
public abstract class CarDatabase extends RoomDatabase {

    @PrimaryKey(autoGenerate = true)
    private int id = 1;
    private String mBrand;
    private String mModel;
    private String mYearBuilt;

    private static String DATABASE_NAME = "CarEntity";

    /**
     *this is to create singleton of this class in order to avoid multiple instances access the database and
     * destabilize the process under room.
    */
    private static final Object DB_OBJECT = new Object();
    private static volatile CarDatabase INSTANCE;

    //abstract method that returns instance of the CarDao
     public abstract CarDao carDao();

     private static CarDatabase getInstance(Context context){
         if(INSTANCE == null){
             synchronized (DB_OBJECT){
                 if(INSTANCE == null){
                     INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CarDatabase.class,
                             CarDatabase.DATABASE_NAME).build();
                 }
             }

         }
         return INSTANCE;
     }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public String getmModel() {
        return mModel;
    }

    public void setmModel(String mModel) {
        this.mModel = mModel;
    }

    public String getmYearBuilt() {
        return mYearBuilt;
    }

    public void setmYearBuilt(String mYearBuilt) {
        this.mYearBuilt = mYearBuilt;
    }
}
