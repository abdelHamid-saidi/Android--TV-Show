package di

import data.service.RetrofitClient
import data.repository.TvShowRepositoryImpl
import domain.repository.TvShowRepository
import domain.usecase.GetPopularShowsUseCase
import domain.usecase.GetShowDetailsUseCase
import org.koin.dsl.module

val appModule = module {
    single { RetrofitClient.api }
    single<TvShowRepository> { TvShowRepositoryImpl(get()) }
    single { GetPopularShowsUseCase(get()) }
    single { GetShowDetailsUseCase(get()) }
}
