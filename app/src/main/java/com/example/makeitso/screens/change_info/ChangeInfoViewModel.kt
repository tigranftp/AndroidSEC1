package com.example.makeitso.screens.change_info

import androidx.compose.runtime.mutableStateOf
import com.example.makeitso.CHANGE_INFO_SCREEN
import com.example.makeitso.LOGIN_SCREEN
import com.example.makeitso.R
import com.example.makeitso.SETTINGS_SCREEN
import com.example.makeitso.SIGN_UP_SCREEN
import com.example.makeitso.SPLASH_SCREEN
import com.example.makeitso.TASKS_SCREEN
import com.example.makeitso.common.ext.isValidEmail
import com.example.makeitso.common.ext.isValidPassword
import com.example.makeitso.common.ext.passwordMatches
import com.example.makeitso.common.snackbar.SnackbarManager
import com.example.makeitso.model.service.AccountService
import com.example.makeitso.model.service.LogService
import com.example.makeitso.model.service.StorageService
import com.example.makeitso.screens.MakeItSoViewModel
import com.example.makeitso.screens.settings.SettingsUiState
import com.example.makeitso.screens.sign_up.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ChangeInfoViewModel @Inject constructor(
    logService: LogService,
    private val accountService: AccountService,
    private val storageService: StorageService
) : MakeItSoViewModel(logService) {
    var uiState = mutableStateOf(ChangeInfoUiState(
        accountService.getProfileDisplayName()
        ,accountService.getProfilePicture()))





    fun onDisplayNameChange(newValue: String) {
        uiState.value = uiState.value.copy(userName = newValue)
    }

    fun onProfilePicURLChange(newValue: String) {
        uiState.value = uiState.value.copy(profilePicURL = newValue)
    }


    fun onSaveClick(openAndPopUp: (String, String) -> Unit) {
        accountService.setProfilePicture(uiState.value.profilePicURL)
        accountService.setProfileDisplayName(uiState.value.userName)
        openAndPopUp(TASKS_SCREEN, CHANGE_INFO_SCREEN)
    }
}
