package com.somnathmitra.android.employeedirectory.data.remote

import com.somnathmitra.android.employeedirectory.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.sql.Time
import java.util.concurrent.TimeUnit

object Networking {

    const val NETWORK_TIMEOUT = 60L

    const val BASE_URL = "https://s3.amazonaws.com"

    fun create (cacheDir : File, cacheSize : Long) : NetworkService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .cache(Cache(cacheDir,cacheSize))
                    .readTimeout(NETWORK_TIMEOUT,TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_TIMEOUT,TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            if(BuildConfig.DEBUG){
                                level = if(BuildConfig.DEBUG){
                                    HttpLoggingInterceptor.Level.NONE
                                } else {
                                    HttpLoggingInterceptor.Level.NONE
                                }
                            }
                        })
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }


}