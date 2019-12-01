package team.pack.datafeed.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pessoa_item.view.*
import team.pack.datafeed.R
import team.pack.datafeed.model.Pessoa

class pessoaAdapter(private val context: Context, private var pessoaList: List<Pessoa>):
    RecyclerView.Adapter<pessoaAdapter.PessoaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pessoa_item, parent, false)
        return PessoaViewHolder(view)
    }

    override fun getItemCount() = pessoaList.size

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bindView(pessoaList[position])
    }

    class PessoaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
         val textViewNome = itemView.textViewNome
         val textViewComentario = itemView.textViewComentario
         val textViewRT = itemView.textViewRT
         val textViewAmei = itemView.textViewAmei
       // val textViewReet = itemView.textViewReet
        //val textViewComentarios = itemView.textViewComentarios

        fun bindView(pessoa: Pessoa) {
            textViewNome.text = pessoa.user.trim()
            textViewComentario.text = pessoa.comentario.trim()
          //textViewComentarios.text = pessoa.comentarios
             textViewAmei.text = pessoa.amei
             textViewRT.text = pessoa.compartilhamentos
          //  textViewReet.text = pessoa.Reet
        }
    }
}