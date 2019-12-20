package com.dreamaple.baseutils.basevm;

import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    //调用ViewModel的类名
    private String className;

    public BaseViewModel(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
