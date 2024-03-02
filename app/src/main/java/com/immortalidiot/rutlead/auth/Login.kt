package com.immortalidiot.rutlead.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.buttons.SignInButton
import com.immortalidiot.rutlead.fields.AccountMissing
import com.immortalidiot.rutlead.fields.BoxLabel
import com.immortalidiot.rutlead.fields.PasswordField
import com.immortalidiot.rutlead.fields.SignUpRedirect
import com.immortalidiot.rutlead.fields.StudentIdTextField
import com.immortalidiot.rutlead.ui.theme.DarkBlue
import com.immortalidiot.rutlead.ui.theme.LightBlue
import com.immortalidiot.rutlead.ui.theme.boldInter14
import com.immortalidiot.rutlead.ui.theme.boldInter36
import com.immortalidiot.rutlead.ui.theme.boldLato18
import com.immortalidiot.rutlead.ui.theme.boldLato20
import com.immortalidiot.rutlead.ui.theme.boldLato32
import com.immortalidiot.rutlead.ui.theme.boldLato36
import com.immortalidiot.rutlead.ui.theme.mediumInter14
import com.immortalidiot.rutlead.ui.theme.mediumInter16
import com.immortalidiot.rutlead.ui.theme.mediumInter24
import com.immortalidiot.rutlead.ui.theme.mediumInter32

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