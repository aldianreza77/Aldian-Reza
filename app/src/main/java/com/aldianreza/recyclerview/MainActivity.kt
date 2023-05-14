package com.aldianreza.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.aldianreza.recyclerview.adapter.AdapterTeamBola
import com.aldianreza.recyclerview.databinding.ActivityMainBinding
import com.aldianreza.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Marcus Rashford",R.drawable.rashford,"Penyerang","180","Manchester, Inggris","31 Oktober 1997 "))
        listPemain.add(Pemain("Carlos Henrique Casemiro",R.drawable.casemiro,"Gelandang","1.86","Sao Jose dos Campos, Brazil","23 Februari 1992 "))
        listPemain.add(Pemain("Raphael Xavier Varane",R.drawable.varane,"Belakang","1.91"," Lille, Prancis","25 April 1993 "))
        listPemain.add(Pemain("Lisandro Martinez",R.drawable.lisandro,"Belakang","1.75"," Gualeguay, Argentina ","18 Januari 1998"))
        listPemain.add(Pemain("Bruno Miguel Borges Fernandes",R.drawable.bruno,"Gelandang","1.79","Maia, Portugal","08 September 1994"))
        listPemain.add(Pemain("David de Gea Quintana",R.drawable.degea,"Penjaga Gawang","1.92","Madrid, Spanyol","07 November 1990 "))
        listPemain.add(Pemain("Antony Matheus dos Santos",R.drawable.antony,"Penyerang","1.74","Sao Paulo, Brazil","24 Februari 2000 "))
        listPemain.add(Pemain("Christian Dannemann Eriksen",R.drawable.eriksen,"Gelandang","1.78","Middelfart, Denmark","14 Februari 1992 "))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text =  "${item?.nama}"
                    posisi.text =  "${item?.posisi}"
                    tinggi.text =  "${item?.tinggi}"
                    tempatlahir.text =  "${item?.tempatlahir}"
                    tgllahir.text =  "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })


    }
}