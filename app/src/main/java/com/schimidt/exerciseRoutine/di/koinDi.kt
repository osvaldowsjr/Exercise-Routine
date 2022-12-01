package com.schimidt.exerciseRoutine.di

import androidx.navigation.NavController
import com.schimidt.exerciseRoutine.BuildConfig
import com.schimidt.exerciseRoutine.navigation.NavigationController
import com.schimidt.exerciseRoutine.navigation.NavigationControllerImpl
import com.schimidt.exerciseRoutine.providers.dataSource.WorkoutDataSource
import com.schimidt.exerciseRoutine.providers.dataSource.WorkoutDataSourceImpl
import com.schimidt.exerciseRoutine.providers.dataSource.local.WorkoutDatabase
import com.schimidt.exerciseRoutine.providers.dataSource.remote.WorkoutApi
import com.schimidt.exerciseRoutine.providers.repo.WorkoutRepository
import com.schimidt.exerciseRoutine.providers.repo.WorkoutRepositoryImpl
import com.schimidt.exerciseRoutine.ui.createWorkout.CreationViewModel
import com.schimidt.exerciseRoutine.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<NavigationController> { (navController: NavController) ->
        NavigationControllerImpl(navController)
    }
}

val networkModule = module {
    factory { provideLoggingInterceptor() }
    //factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideWorkoutApi(get()) }
    single { provideRetrofit(get()) }
}

val dataModule = module {
    single { WorkoutDatabase.getDao(androidContext()) }
    single<WorkoutDataSource> { WorkoutDataSourceImpl(get(), get()) }
    single<WorkoutRepository> { WorkoutRepositoryImpl(get(), Dispatchers.IO) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { CreationViewModel(get()) }
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return httpLoggingInterceptor
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

fun provideWorkoutApi(retrofit: Retrofit): WorkoutApi = retrofit.create(WorkoutApi::class.java)