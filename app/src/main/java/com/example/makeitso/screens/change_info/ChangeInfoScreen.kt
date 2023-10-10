package com.example.makeitso.screens.change_info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.makeitso.R
import com.example.makeitso.common.composable.BasicButton
import com.example.makeitso.common.composable.BasicToolbar
import com.example.makeitso.common.composable.DropdownContextMenu
import com.example.makeitso.common.composable.EmailField
import com.example.makeitso.common.composable.PasswordField
import com.example.makeitso.common.composable.RepeatPasswordField
import com.example.makeitso.common.ext.basicButton
import com.example.makeitso.common.ext.contextMenu
import com.example.makeitso.common.ext.fieldModifier
import com.example.makeitso.model.Task
import com.example.makeitso.screens.sign_up.SignUpViewModel
import com.example.makeitso.theme.DarkOrange


@Composable
@ExperimentalMaterialApi
fun ChangeInfo(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState
    val fieldModifier = Modifier.fieldModifier()

    BasicToolbar(R.string.create_account)

    Column(
        modifier = modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            singleLine = true,
            modifier = modifier,
            value = "",
            onValueChange = {  },
            placeholder = { "Name" },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") }
        )
        EmailField("AAAAAAAAAAAAAAA", viewModel::onEmailChange, fieldModifier)
        PasswordField(uiState.password, viewModel::onPasswordChange, fieldModifier)
        RepeatPasswordField(uiState.repeatPassword, viewModel::onRepeatPasswordChange, fieldModifier)

        BasicButton(R.string.create_account, Modifier.basicButton()) {
            viewModel.onSignUpClick(openAndPopUp)
        }
    }
}