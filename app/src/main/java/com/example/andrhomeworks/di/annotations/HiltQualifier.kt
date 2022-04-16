package com.example.andrhomeworks.di.annotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiWithInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiWithoutInterceptor