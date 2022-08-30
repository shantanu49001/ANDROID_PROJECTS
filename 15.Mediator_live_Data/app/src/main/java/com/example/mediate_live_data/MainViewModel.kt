package com.example.mediate_live_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private var _firstPlayerScore=MutableLiveData<Float>(0f)
    val firstPlayerScore:LiveData<Float>
    get() = _firstPlayerScore


    private var _secondPlayerScore=MutableLiveData<Float>(0f)
    val secondPlayerScore:LiveData<Float>//gttter needed
    get() = _secondPlayerScore

    fun setFirstPlayerScore(score:Float){
        _firstPlayerScore.value=score
    }
    fun setSecondPlayerScore(score:Float){
        _secondPlayerScore.value=score//var me live data ka score daalne k loye .value method of live class data
    }


}