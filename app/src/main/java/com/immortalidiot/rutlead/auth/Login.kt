package com.immortalidiot.rutlead.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.immortalidiot.rutlead.ui.theme.LightBlue

@Preview (showBackground = true)
@Composable
fun LoginDesign() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_app_logo
                ),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(0.07f)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.6f)
                    .clip(RoundedCornerShape(15.dp))
                    .background(LightBlue),
                contentAlignment = Alignment.Center,

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                ) {
                    BoxLabel()
                    Spacer(modifier = Modifier.height(40.dp))
                    StudentIdTextField("Номер студенческого билета")
                    Spacer(modifier = Modifier.height(30.dp))
                    PasswordField("Пароль")
                    Spacer(modifier = Modifier.height(30.dp))
                    SignInButton()
                    Spacer(modifier = Modifier.height(30.dp))
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