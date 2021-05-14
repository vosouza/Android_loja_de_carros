package com.brq.applojadecarros.model

class Pessoa (
    var nome: String,
    var idade: Int,
    var email: String,
    var senha: String
        )
{

    companion object{
        fun email():String {return "james@hotmail.com"

        }
        fun senha():String{return "abc1234"

        }
        fun nome():String {return "James"

        }
        fun idade():String {
            return "45"
        }

    }
}