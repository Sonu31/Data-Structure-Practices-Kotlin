package com.android.experiment.nativeLibImp

class NativeLib {
    external fun getHello(): String


    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}