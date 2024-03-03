package com.immortalidiot.rutlead.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.buttons.SignInButton
import com.immortalidiot.rutlead.fields.AccountMissing
import com.immortalidiot.rutlead.fields.BoxLabel
import com.immortalidiot.rutlead.fields.PasswordField
import com.immortalidiot.rutlead.fields.SignUpRedirect
import com.immortalidiot.rutlead.fields.StudentIdTextField
import com.immortalidiot.rutlead.ui.theme.LocalDimensions

@Preview (showBackground = true)
@Composable
fun LoginDesign() {
    val dimensions = LocalDimensions.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Image(
                painter = painterResource(
                    id = if (isSystemInDarkTheme()) R.drawable.ic_app_dark_logo
                    else R.drawable.ic_app_light_logo
                ),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(0.07f)
            )
            Spacer(modifier = Modifier.height(dimensions.verticalXXLarge))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.55f)
                    .clip(RoundedCornerShape(dimensions.shapeRound))
                    .background(MaterialTheme.colorScheme.primary)
                    .border(
                        BorderStroke(2.dp, MaterialTheme.colorScheme.outline),
                        shape = RoundedCornerShape(dimensions.shapeRound)
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                ) {
                    BoxLabel()
                    Spacer(modifier = Modifier.height(dimensions.verticalXXLarge))
                    StudentIdTextField("Номер студенческого билета")
                    Spacer(modifier = Modifier.height(dimensions.verticalXLarge))
                    PasswordField("Пароль")
                    Spacer(modifier = Modifier.height(dimensions.verticalXXLarge))
                    SignInButton()
                    Spacer(modifier = Modifier.height(dimensions.verticalXLarge))
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        AccountMissing()
                        SignUpRedirect()
                    }
                }
            }
        }
    }
}