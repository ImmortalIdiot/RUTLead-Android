package com.immortalidiot.rutlead.components.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.ThemeColors

@Composable
fun BottomSnackbar(
    modifier: Modifier,
    palette: ThemeColors,
    snackbarHostState: SnackbarHostState
) {
    val dimensions = LocalDimensions.current

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(bottom = dimensions.verticalNormal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        SnackbarHost(
            modifier = modifier,
            hostState = snackbarHostState,
        ) {
            Snackbar(
                snackbarData = it,
                containerColor = palette.containerColorError,
                contentColor = palette.textColorError,
                dismissActionContentColor = palette.textColorError,
                shape = RoundedCornerShape(LocalDimensions.current.shapeNormal)
            )
        }
    }
}
