package com.mramallo.randomusertt.ui.randomUserDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramallo.randomusertt.ui.randomUserDetail.domain.GetRandomByIdUseCase
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomUserDetailViewModel @Inject constructor(
    private val getRandomByIdUseCase: GetRandomByIdUseCase
): ViewModel() {

    var stateRandomItem by mutableStateOf(UiRandomState())

    fun getRandomById(id: String) {
        viewModelScope.launch {
            stateRandomItem = UiRandomState(loading = true, user = null)
            stateRandomItem = UiRandomState(loading = false, user = getRandomByIdUseCase.invoke(id))
        }
    }


    data class UiRandomState(
        val loading: Boolean = false,
        val user: RandomUser? = null
    )
}