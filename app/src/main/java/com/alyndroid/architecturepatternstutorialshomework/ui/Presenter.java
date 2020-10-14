package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

class Presenter {
    DivProvider DivProvider;

    public Presenter(DivProvider DivProvider) {
        this.DivProvider = DivProvider;
        DivProvider.OnGetDiv(getDiv());
    }



    private double getDiv(){
        NumberModel model = new DataBase().getNumbers();
        return model.getFirstNum()/model.getSecondNum();
    }
}
