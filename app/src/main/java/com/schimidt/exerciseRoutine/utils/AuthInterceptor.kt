package com.schimidt.exerciseRoutine.utils

import com.schimidt.exerciseRoutine.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        // DONT INCLUDE API KEYS IN YOUR SOURCE CODE
        val url = req.url.newBuilder().addQueryParameter("X-Api-Key", BuildConfig.API_KEY).build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}