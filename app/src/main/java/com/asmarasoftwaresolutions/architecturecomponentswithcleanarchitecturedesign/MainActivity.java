package com.asmarasoftwaresolutions.architecturecomponentswithcleanarchitecturedesign;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mtvCars;
    private EditText metBrand, metYear, metType;
    private Button mbtnGetCar, mbtnAddCar;
    private MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtvCars = findViewById(R.id.tv_cars);
        metBrand = findViewById(R.id.et_brand);
        metYear = findViewById(R.id.et_year);
        metType = findViewById(R.id.et_type);
        mbtnGetCar = findViewById(R.id.b_getcar);
        mbtnAddCar = findViewById(R.id.b_addcar);
        mbtnGetCar.setOnClickListener(this);
        mbtnAddCar.setOnClickListener(this);

        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.b_getcar:
                mViewModel.getCar(metBrand.getText().toString(), metYear.getText().toString(), metType.getText().toString());

                break;

            case R.id.b_addcar:
                mViewModel.addCar(metBrand.getText().toString(), metYear.getText().toString(), metType.getText().toString());

                break;
        }
    }
}
