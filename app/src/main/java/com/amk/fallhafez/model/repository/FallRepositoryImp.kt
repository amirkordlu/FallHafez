package com.amk.fallhafez.model.repository

import android.util.Log
import com.amk.fallhafez.model.data.Res2
import com.amk.fallhafez.model.data.Result
import com.amk.fallhafez.model.net.ApiService

class FallRepositoryImp(
    private val apiService: ApiService
) : FallRepository {

    override suspend fun getFallGhazal(): List<Result> {
        val ghazal = apiService.takeFall()
        if (ghazal.Ok) {
            return ghazal.Result
        } else {
            Log.e("FallRepositoryImp", "Error to load ghazal!")
        }
        return listOf()
    }

    override suspend fun getFallTabir(): List<Res2> {
        val tabir = apiService.takeFall()
        if (tabir.Ok) {
            return tabir.res2
        } else {
            Log.e("FallRepositoryImp", "Error to load tabir!")
        }
        return listOf()
    }
}
