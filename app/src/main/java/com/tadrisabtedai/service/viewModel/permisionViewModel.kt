package com.tadrisabtedai.service.viewModel

import androidx.lifecycle.ViewModel
import com.tadrisabtedai.service.base.PermissionManager
import com.tadrisabtedai.service.modle.statePermission
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PermissionViewModel @Inject constructor(
    private val pm : PermissionManager
) : ViewModel() {
private val _state = MutableStateFlow<statePermission>(statePermission.LOADING)
    val state: StateFlow<statePermission> = _state

    fun checkPermission(permission: String) {
       _state.value =
        if (pm.isPermissionGranted(permission)) statePermission.GRANTED
        else statePermission.NEED_REQUEST
    }
}
