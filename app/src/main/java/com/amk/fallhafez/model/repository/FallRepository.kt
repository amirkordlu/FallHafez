package com.amk.fallhafez.model.repository

import com.amk.fallhafez.model.data.Res2

interface FallRepository {

    suspend fun getFallGhazal(): List<com.amk.fallhafez.model.data.Result>

    suspend fun getFallTabir(): List<Res2>
}