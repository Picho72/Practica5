package com.example.practica5

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    AdapterView.OnItemClickListener {

    lateinit var txtTitulo:TextView
    lateinit var txtDescripcion:TextView
    lateinit var spLenguaje:Spinner
    var lenguajes = arrayOf("PHP", "JAVA", "KOTLIN", "JAVASCRIPT", "RUBY", "C", "SWIFT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtTitulo = findViewById(R.id.txtTitulo)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        spLenguaje = findViewById(R.id.spLenguaje)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lenguajes)
        spLenguaje.adapter = adaptador
        spLenguaje.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.v("App Spinner", "Seleccionaste uno $id")
        val lenguaje = lenguajes[position]

        txtTitulo.text = lenguaje
        val descripcion = when(lenguaje){
            "PHP"-> "Utilizado principalmente para el desarrollo de aplicaciones web del lado del servidor."
            "JAVA"-> "Un lenguaje de programación versátil utilizado en una amplia gama de aplicaciones, desde aplicaciones móviles hasta aplicaciones empresariales."
            "JAVASCRIPT"-> "Un lenguaje de programación utilizado principalmente para agregar interactividad y funcionalidad a sitios web."
            "KOTLIN"-> "Un lenguaje de programación moderno utilizado principalmente para el desarrollo de aplicaciones Android, aunque también es utilizado en otros tipos de desarrollo de software."
            "RUBY"-> "Un lenguaje de programación conocido por su simplicidad y productividad, utilizado principalmente para el desarrollo web y la creación de aplicaciones web."
            "C"-> "Un lenguaje de programación de propósito general utilizado en sistemas operativos, desarrollo de juegos, y aplicaciones de alto rendimiento."
            "SWIFT"-> " Un lenguaje de programación desarrollado por Apple, utilizado para crear aplicaciones para dispositivos iOS, macOS, watchOS y tvOS."
            else-> "No definido"
        }
        txtDescripcion.text = descripcion
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }
}