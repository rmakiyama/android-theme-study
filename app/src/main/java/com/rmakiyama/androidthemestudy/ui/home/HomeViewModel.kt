package com.rmakiyama.androidthemestudy.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rmakiyama.androidthemestudy.model.Case
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    val cases = liveData {
        emit(listOf(*Case.values()))
    }
}
