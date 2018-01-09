package com.perazzo.gaslocation.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.perazzo.gaslocation.api.service.GasStationApi
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    private val TIME_OUT: Long = 20

    @Provides
    @Singleton
    fun gasStationApi(retrofit: Retrofit): GasStationApi {
        return retrofit.create(GasStationApi::class.java)
    }

    @Provides
    @Singleton
    fun retrofit(gson: Gson): Retrofit {
        val okHttpClient: OkHttpClient.Builder = getHttpClientBuilder()
        return getRetrofitBuilder(okHttpClient.build(), "http://api.mygasfeed.com", gson).build()
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        return GsonBuilder()
                .create()
    }

    private fun getRetrofitBuilder(okHtppClient: OkHttpClient, url: String, gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
                .client(okHtppClient)
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))

    }

    private fun getHttpClientBuilder(): OkHttpClient.Builder {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)

    }

}