package com.asmarasoftwaresolutions.usecase;

import android.os.Handler;
import android.os.Looper;
import com.asmarasoftwaresolutions.car_repository.CarRepositoryInterface;
import com.asmarasoftwaresolutions.core.SuccessOrException;
import com.asmarasoftwaresolutions.domain_adapter.DataToDomainAdapter;
import com.asmarasoftwaresolutions.model.Car;
import java.util.concurrent.Executor;

public class CarUseCaseInterfaceImpl implements CarUseCaseInterface {

    private CarRepositoryInterface mCarRepository;
    private DataToDomainAdapter mDataToDomainAdapter;
    private Executor mExecutor;

    public CarUseCaseInterfaceImpl(Executor executor, CarRepositoryInterface mCarRepository, DataToDomainAdapter mDataToDomainAdapter) {
        this.mExecutor = executor;
        this.mCarRepository = mCarRepository;
        this.mDataToDomainAdapter = mDataToDomainAdapter;
    }

    @Override
    public void addCar(final String brand, final String year, final String type) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCarRepository.addCar(brand, year, type);
            }
        });
    }

    @Override
    public Car getCar(final SuccessOrException<Car> successOrFailure, final String brand, final String year, final String type) {
        final Handler handler = new Handler(Looper.getMainLooper());
        //CarEntity carEntity = new CarEntity(brand, year, type);
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                successOrFailure.onSuccess(mDataToDomainAdapter.convert(mCarRepository.getCar(brand, year, type)));
                mCarRepository.getCar(brand, year, type);
                handler.post(this);
            }
        });
        return null;
    }
}
