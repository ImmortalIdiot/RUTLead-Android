package com.immortalidiot.rutlead.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.buttons.login.SignInButton
import com.immortalidiot.rutlead.components.login.AccountMissing
import com.immortalidiot.rutlead.components.login.BoxLabel
import com.immortalidiot.rutlead.components.login.RedirectText
import com.immortalidiot.rutlead.fields.PasswordField
import com.immortalidiot.rutlead.fields.StudentIdTextField
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.ThemeColors

@Preview(showBackground = true)
@Composable
fun LoginDesign(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeXLarge)
    val palette = if (isDarkTheme) ThemeColors.Dark
                      else ThemeColors.Light

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth(0.4f)
                .fillMaxHeight(0.07f),
            imageVector = ImageVector.vectorResource(
                id = if (isSystemInDarkTheme()) {
                    R.drawable.ic_app_dark_logo
                } else {
                    R.drawable.ic_app_light_logo
                }
            ),
            contentDescription = "logo",
        )
        Spacer(modifier = modifier.height(dimensions.verticalXXLarge))
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.65f)
                .clip(roundedShape)
                .background(color = palette.primary)
                .border(
                    width = dimensions.borderSSmall,
                    color = palette.outline,
                    shape = roundedShape
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth(0.85f)
            ) {
                BoxLabel(
                    text = "Авторизация",
                    palette = palette
                )
                Spacer(modifier = modifier.height(dimensions.verticalXXLarge))
                StudentIdTextField(
                    hint = "Номер студенческого билета",
                    palette = palette
                )
                Spacer(modifier = modifier.height(dimensions.verticalXLarge))
                PasswordField(
                    hint = "Пароль",
                    palette = palette,
                    modifier = modifier
                        .border(
                            width = dimensions.borderSSmall,
                            color = palette.outline,
                            shape = roundedShape
                        )
                )
                Spacer(modifier = Modifier.height(dimensions.verticalXLarge))
                SignInButton(
                    modifier = modifier,
                    palette = palette,
                    text = "Войти",
                    onButtonClick = {
                        // TODO: realise body of the fun when the view model appears
                    },
                )
                Spacer(modifier = modifier.height(dimensions.verticalXLarge))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    AccountMissing(
                        palette = palette
                    )
                    RedirectText(
                        text = "Зарегистрируйтесь",
                        palette = palette
                    )
                }
                Spacer(modifier = modifier.height(dimensions.verticalXSmall))
                RedirectText(
                    text = "Забыли пароль?",
                    palette = palette
                )
            }
        }
    }
}
