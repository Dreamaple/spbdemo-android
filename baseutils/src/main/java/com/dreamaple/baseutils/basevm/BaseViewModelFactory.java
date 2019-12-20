package com.dreamaple.baseutils.basevm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.Constructor;

public class BaseViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        Class<T>

        Constructor<?>[] constructor = modelClass.getConstructors();
//        constructor[0].;

//        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
//            return (T) new T(LoginRepository.getInstance(new LoginDataSource()));
//        } else {
//            throw new IllegalArgumentException("Unknown ViewModel class");
//        }
        return null;
    }
}
