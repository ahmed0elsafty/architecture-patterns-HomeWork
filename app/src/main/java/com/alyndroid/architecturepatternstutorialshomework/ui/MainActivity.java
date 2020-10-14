package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingBuildInfo;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.plusResultTextView.setText(getSum());
            }
        });

    }
    private String getSum(){
        NumberModel model = new DataBase().getNumbers();
        return String.valueOf(model.getFirstNum()+model.getSecondNum());
    }

}
