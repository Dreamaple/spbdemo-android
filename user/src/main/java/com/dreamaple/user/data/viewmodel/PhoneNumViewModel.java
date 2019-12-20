package com.dreamaple.user.data.viewmodel;

import androidx.lifecycle.ViewModel;

import com.dreamaple.user.data.model.PhoneNumModel;

/**
 * @author dreamaple
 * @date 2019年11月29日09:17:25
 */
public class PhoneNumViewModel extends ViewModel {
    private PhoneNumModel phoneNumModel = new PhoneNumModel();

    public PhoneNumViewModel() {
//        phoneNumModel ;
    }

    public PhoneNumModel getPhoneNumModel() {
        return phoneNumModel;
    }

    public void setPhoneNumModel(PhoneNumModel phoneNumModel) {
        this.phoneNumModel = phoneNumModel;
    }

    @Override
    protected void onCleared() {

    }
}
