package com.rmakiyama.androidthemestudy.ui.cases.attribute

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rmakiyama.androidthemestudy.data.DummyRepository
import javax.inject.Inject

class AttributeCaseViewModel @Inject constructor(
    repository: DummyRepository
) : ViewModel() {

    val dummies = repository.dummies().asLiveData()
}
