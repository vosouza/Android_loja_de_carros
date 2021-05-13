package com.brq.applojadecarros.model

import android.view.View

interface ItemClickListener {
    fun onClickItem(view: View?, index: Int)
    fun onLongCLickItem(view:View?, index: Int)
}