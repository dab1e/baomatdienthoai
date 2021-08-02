package com.dab1e.bomtcucgi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dab1e.bomtcucgi.R
import com.dab1e.bomtcucgi.model.Pass

class ScreenLockViewModel: ViewModel() {

    private val livedata = MutableLiveData<Pass>()

    private var pass = Pass()

    fun onclickNumber(number:Int):MutableLiveData<Pass>{

        pass.setPassWord(number)
        livedata.postValue(pass)

        return livedata
    }

    fun deletePass():MutableLiveData<Pass>{
        pass.deletepass()
        return livedata
    }
}