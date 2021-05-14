package com.brq.applojadecarros.model

class Pessoa (
    var nome: String,
    var idade: Int,
    var email: String,
    var senha: String
        )
{

    companion object{
        fun getPessoasList(): ArrayList<Pessoa>{
            val list = ArrayList<Pessoa>()
            list.add(Pessoa("James", 25, "james@gmail.com","senha1"))
            return list
        }
    }
}