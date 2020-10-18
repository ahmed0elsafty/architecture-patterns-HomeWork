package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements DivProvider {
    private ActivityMainBinding binding;
    private NumberViewModel numberViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        numberViewModel  = new NumberViewModel();
        numberViewModel.mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.mulResultTextView.setText(String.valueOf(integer));
            }
        });
        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.plusResultTextView.setText(getSum());
            }
        });
        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Presenter(MainActivity.this);
            }
        });
        binding.mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberViewModel.getMul();
            }
        });
    }
    private String getSum(){
        NumberModel model = new DataBase().getNumbers();
        return String.valueOf(model.getFirstNum()+model.getSecondNum());
    }

    @Override
    public void OnGetDiv(double div) {
        binding.divResultTextView.setText(String.valueOf(div));
    }
}
