package com.example.baitapcomponent2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentViewModel.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentViewModel : ViewModel() {
    var loading: MutableLiveData<Boolean> = MutableLiveData(false)
    var error = MutableLiveData("");
    fun checkIsEmpty(edtE: String?, edtP: String?){
        if(edtE.isNullOrBlank()|| edtP.isNullOrBlank()){
            error.postValue("Email or Password is empty")
        }else {
            loginDelay()
        }
    }
    fun loginDelay(){
        viewModelScope.launch() {
            loading.postValue(true);
            for (i in 1..10){
                Log.i("loginDelay","loginDelay $i")
                delay(200)
            }
            Log.i("loginDelay","loginDelay $loading")
            loading.postValue(false);
        }
    }
}