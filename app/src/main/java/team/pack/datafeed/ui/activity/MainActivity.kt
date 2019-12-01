package team.pack.datafeed.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.pack.datafeed.R
import team.pack.datafeed.model.Pessoa
import team.pack.datafeed.retrofit.retrofitInitializer
import team.pack.datafeed.ui.adapter.pessoaAdapter

class MainActivity : AppCompatActivity() {
    lateinit var pessoaAdapter: pessoaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        val call = retrofitInitializer().pessoaService().list()

        call.enqueue(object : Callback<List<Pessoa>> {
            override fun onResponse(call: Call<List<Pessoa>>, response: Response<List<Pessoa>>) {
                    response.body()?.let {
                        val persons : List<Pessoa> = it
                        criarLista(persons)
                    }
            }
            override fun onFailure(call: Call<List<Pessoa>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                Log.e(
                    "onFailure error",
                    t?.message
                )
            }
        })
    }


    fun criarLista(pessoas : List<Pessoa>){
        pessoaAdapter = pessoaAdapter(this, pessoas)
        recyclerView.adapter = pessoaAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.smoothScrollToPosition(pessoas.size)
    }
}
