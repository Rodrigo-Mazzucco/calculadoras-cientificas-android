package br.com.calculadoras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HelloWorld : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.helloworld)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val campo = findViewById<EditText>(R.id.edt1)
        val btn1 = findViewById<Button>(R.id.btn1)
        val txt1 = findViewById<TextView>(R.id.txt1)
        btn1.setOnClickListener {
            val nome = campo.text.toString()
            txt1.text= "Olá $nome bem-vindo ao APP"
        }
    }
}