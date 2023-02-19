package com.amk.fallhafez.di

import com.amk.fallhafez.model.net.createApiService
import com.amk.fallhafez.model.repository.FallRepository
import com.amk.fallhafez.model.repository.FallRepositoryImp
import com.amk.fallhafez.ui.features.fall.FallScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {
    single { createApiService() }
    single<FallRepository> { FallRepositoryImp(get()) }

    viewModel { FallScreenViewModel(get()) }

}