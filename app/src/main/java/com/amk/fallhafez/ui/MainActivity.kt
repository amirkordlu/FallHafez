package com.amk.fallhafez.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amk.fallhafez.di.myModules
import com.amk.fallhafez.ui.features.fall.FallScreen
import com.amk.fallhafez.ui.features.main.MainScreen
import com.amk.fallhafez.ui.theme.FallHafezTheme
import com.amk.fallhafez.util.MyScreens
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.KoinNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Koin(appDeclaration = { modules(myModules) }) {
                FallHafezTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        FallHafezUI()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FallHafezTheme {
        FallHafezUI()
    }
}

@Composable
fun FallHafezUI() {
    val navController = rememberNavController()
    KoinNavHost(
        navController = navController,
        startDestination = MyScreens.MainScreen.route
    ) {

        composable(MyScreens.MainScreen.route) {
            MainScreen()

        }

        composable(
            route = MyScreens.FallScreen.route) {
            FallScreen()
        }

    }
}