package com.onnet.databinding.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.onnet.databinding.repositories.AuthRepository
import androidx.lifecycle.MutableLiveData
import com.onnet.databinding.pojo.SingleDataItem

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private var mAuthRepository: AuthRepository? = null
    fun init() {
        mAuthRepository = AuthRepository()
        //mCheckMobileNumberResponse = mAuthRepository.getMobileCheckResponseLiveData();
    }

    val dashboardData: MutableLiveData<List<SingleDataItem>?>
        get() = mAuthRepository!!.dashboardData

    init {
        init()
    }
}