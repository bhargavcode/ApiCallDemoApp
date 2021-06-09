package com.devbhargav.testa.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()

    private var userMutableLiveData: MutableLiveData<LoginUser>? = null

    fun getUser(): MutableLiveData<LoginUser>? {
        if (userMutableLiveData == null) {
            userMutableLiveData = MutableLiveData<LoginUser>()
        }
        return userMutableLiveData
    }


}