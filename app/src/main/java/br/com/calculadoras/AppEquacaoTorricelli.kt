package br.com.calculadoras

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class AppEquacaoTorricelli : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_equacao_torricelli)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val valorVelocidadeInicial = findViewById<TextInputEditText>(R.id.editTextVelocidadeInicial)
        val valorAceleracao = findViewById<TextInputEditText>(R.id.editTextAceleracao)
        val valorDeslocamento = findViewById<TextInputEditText>(R.id.editTextDeslocamento)
        val btnCalcularVelocidadeFinal = findViewById<Button>(R.id.btnCalcularVelocidadeFinal)
        val velocidadeFinal = findViewById<TextView>(R.id.textViewVelocidadeFinal)

        btnCalcularVelocidadeFinal.setOnClickListener {
            try {
                val velocidadeInicial = valorVelocidadeInicial.text.toString().toDouble()
                val aceleracao = valorAceleracao.text.toString().toDouble()
                val deslocamento = valorDeslocamento.text.toString().toDouble()

                val calculo = (Math.sqrt((Math.pow(velocidadeInicial, 2.0) + (2 * aceleracao) * deslocamento)))

                velocidadeFinal.visibility = View.VISIBLE
                velocidadeFinal.text = "A Velocidade Final é: %.2f (m/s)".format(calculo)
            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores válidos", Toast.LENGTH_SHORT).show()
            }
        }
        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarEquacaoTorricelli)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}