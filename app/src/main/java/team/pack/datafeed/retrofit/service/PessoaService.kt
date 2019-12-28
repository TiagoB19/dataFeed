package team.pack.datafeed.retrofit.service

import retrofit2.Call
import retrofit2.http.GET
import team.pack.datafeed.model.Pessoa

interface PessoaService {
    @GET("pessoas")
    fun list(): Call<List<Pessoa>>
}