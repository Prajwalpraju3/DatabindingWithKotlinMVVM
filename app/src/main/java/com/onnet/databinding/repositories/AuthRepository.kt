package com.onnet.databinding.repositories

import com.onnet.databinding.api.ApiClient
import androidx.lifecycle.MutableLiveData
import com.onnet.databinding.api.Api
import com.onnet.databinding.pojo.SingleDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    private val mApiClient: ApiClient
    val dashboardData: MutableLiveData<List<SingleDataItem>?>
        get() {
            val responseMutableLiveData = MutableLiveData<List<SingleDataItem>?>()
            mApiClient.api
                .dashboardData
                .enqueue(object : Callback<List<SingleDataItem>?> {
                    override fun onResponse(
                        call: Call<List<SingleDataItem>?>,
                        response: Response<List<SingleDataItem>?>
                    ) {
                        if (response.body() != null) {
                            responseMutableLiveData.setValue(response.body())
                        } else {
                            responseMutableLiveData.setValue(null)
                        }
                    }

                    override fun onFailure(call: Call<List<SingleDataItem>?>, t: Throwable) {
                        responseMutableLiveData.value = null
                    }
                })
            return responseMutableLiveData
        }

    init {
        mApiClient = ApiClient.getInstance(Api.BASE_URL)
    }
}