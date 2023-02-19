package com.amk.fallhafez.model.data

data class FallResponse(
    val Ok: Boolean,
    val Result: List<Result>,
    val res2: List<Res2>
)

data class Result(
    val ghazal: String
)

data class Res2(
    val tabir: String
)

