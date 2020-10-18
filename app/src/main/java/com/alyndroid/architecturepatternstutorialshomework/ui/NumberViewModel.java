package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.lifecycle.MutableLiveData;

class NumberViewModel {
    MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
    private int getMulFromDatabase(){
        NumberModel model = new DataBase().getNumbers();
        return model.getFirstNum()*model.getSecondNum();
    }
    public void getMul(){
        mutableLiveData.setValue(getMulFromDatabase());
    }

}
