package com.simtop.simdiary.di

import com.simtop.simdiary.CoroutineDispatcherProvider
import com.simtop.simdiary.DefaultCoroutineDispatcherProvider
import com.simtop.simdiary.DiaryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<CoroutineDispatcherProvider> {
        DefaultCoroutineDispatcherProvider()
    }
    viewModelOf(::DiaryListViewModel)

}