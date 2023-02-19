package com.amk.fallhafez.ui.features.main

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.amk.fallhafez.R
import com.amk.fallhafez.ui.theme.FallHafezTheme
import com.amk.fallhafez.util.MyScreens
import com.amk.fallhafez.util.NetworkChecker
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavController


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FallHafezTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {
    val uiController = rememberSystemUiController()
    SideEffect { uiController.setStatusBarColor(Color.White) }

    val navigation = getNavController()
    val context = LocalContext.current

    Image(
        painter = painterResource(R.drawable.img_mainscreen),
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        IconButton(onClick = {
            if (NetworkChecker(context).isInternetConnected) {
                navigation.navigate(MyScreens.FallScreen.route)
            } else {
                Toast.makeText(context, "اینترنت نداری!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Image(
                painter = painterResource(id = R.drawable.img_button),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(0.4f)
            )
        }
    }
}