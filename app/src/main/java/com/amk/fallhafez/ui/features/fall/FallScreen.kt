package com.amk.fallhafez.ui.features.fall

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amk.fallhafez.R
import com.amk.fallhafez.model.data.Res2
import com.amk.fallhafez.model.data.Result
import com.amk.fallhafez.ui.theme.FallHafezTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavViewModel

@Preview(showBackground = true)
@Composable
fun FallScreenPreview() {
    FallHafezTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            FallScreen()
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun FallScreen() {
    val uiController = rememberSystemUiController()
    SideEffect { uiController.setStatusBarColor(Color.White) }
    val viewModel = getNavViewModel<FallScreenViewModel>()

    remember {
        viewModel.getFallTabir()
        viewModel.getFallGhazal()
    }

    val tabir = viewModel.fallTabir
    val ghazal = viewModel.fallGhazal

    Image(
        painter = painterResource(R.drawable.img_fallscreen2),
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 168.dp, bottom = 168.dp)
    ) {
        ShowGhazal(ghazal = ghazal.value, tabir.value)
    }

}

@Composable
fun ShowGhazal(ghazal: List<Result>, tabir: List<Res2>) {
    val textFont = FontFamily(Font(R.font.nahid))

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(ghazal.size) {
            GhazalItem(ghazal[it])

        }
        item {
            Text(
                text = ":تعبیر",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                fontFamily = textFont,
                fontSize = 16.sp
            )
        }
        items(tabir.size) {
            TabirItem(tabir[it])
        }
    }
}

@Composable
fun GhazalItem(ghazal: Result) {
    val textFont = FontFamily(Font(R.font.nahid))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(
            text = ghazal.ghazal,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(color = Color.DarkGray),
            textAlign = TextAlign.Center,
            fontFamily = textFont,
            fontSize = 16.sp
        )

    }
}

@Composable
fun TabirItem(tabir: Res2) {
    val textFont = FontFamily(Font(R.font.nahid))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(
            text = tabir.tabir,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(color = Color.DarkGray),
            textAlign = TextAlign.Center,
            fontFamily = textFont,
            fontSize = 16.sp
        )
    }
}


