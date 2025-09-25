package com.tadrisabtedai.service.ui.screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.tadrisabtedai.service.modle.statePermission
import com.tadrisabtedai.service.viewModel.PermissionViewModel

@Composable
fun PermissionCameraScreen(
    viewModel: PermissionViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    val launchPermission = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            viewModel.checkPermission(Manifest.permission.CAMERA)
        }
    }

    // دکمه درخواست مجوز
    Button(onClick = {
        launchPermission.launch(Manifest.permission.CAMERA)
    }) {
        Text("Request Camera Permission")
    }

    // وقتی استیت تغییر کرد، به صورت خودکار واکنش نشون بده
    LaunchedEffect(state) {
        when (state) {
            statePermission.LOADING -> { "/* نمایش لودینگ اگر خواستی */" }
            statePermission.GRANTED -> {" /* دوربین آماده استفاده است */" }
            statePermission.NEED_REQUEST -> {
                launchPermission.launch(Manifest.permission.CAMERA)
            }
        }
    }
}
