package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import domain.repository.TvShowRepository
import domain.usecase.GetPopularShowsUseCase
import data.service.TvShowApiService
import data.repository.TvShowRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://www.episodate.com/api/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideTvShowApiService(retrofit: Retrofit): TvShowApiService =
        retrofit.create(TvShowApiService::class.java)

    @Provides
    @Singleton
    fun provideTvShowRepository(apiService: TvShowApiService): TvShowRepository =
        TvShowRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideGetPopularShowsUseCase(repository: TvShowRepository): GetPopularShowsUseCase =
        GetPopularShowsUseCase(repository)
}
