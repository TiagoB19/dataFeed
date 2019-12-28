package team.pack.datafeed.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import team.pack.datafeed.retrofit.service.PessoaService

class RetrofitInitializer{

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://5dce0a94d795470014e4d4cf.mockapi.io/teste/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun pessoaService() = retrofit.create(PessoaService::class.java)
}