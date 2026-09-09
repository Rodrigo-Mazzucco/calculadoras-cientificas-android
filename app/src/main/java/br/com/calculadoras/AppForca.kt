package br.com.calculadoras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppForca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_forca)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorMassa = findViewById<EditText>(R.id.editTextMassa)
        val valorAceleracao = findViewById<EditText>(R.id.editTextAceleracao)
        val calcularForca = findViewById<Button>(R.id.btnForca)
        val resultadoView = findViewById<TextView>(R.id.textViewForca)

        calcularForca.setOnClickListener {
            try {
                val massa = valorMassa.text.toString().toDouble()
                val aceleracao = valorAceleracao.text.toString().toDouble()

                val calculo = massa * aceleracao
                resultadoView.text = "A força necessária é: %.2f N".format(calculo)

            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores válidos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarForca)

        btnVoltar.setOnClickListener {
            finish()
        }




    }
}