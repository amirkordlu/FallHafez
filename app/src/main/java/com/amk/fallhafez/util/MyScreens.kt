package com.amk.fallhafez.util

sealed class MyScreens(val route: String) {
    object MainScreen : MyScreens("mainScreen")
    object FallScreen : MyScreens("fallScreen")
}

