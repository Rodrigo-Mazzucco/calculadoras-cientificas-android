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

class AppFormulaDiluicao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_formula_diluicao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val campoConcentracaoInicial = findViewById<TextInputEditText>(R.id.editTextConcentracaoInicial)
        val campoVolumeInicial = findViewById<TextInputEditText>(R.id.editTextVolumeInicial)
        val campoConcentracaoFinal = findViewById<TextInputEditText>(R.id.editTextConcentracaoFinal)
        val campoVolumeFinal = findViewById<TextInputEditText>(R.id.editTextVolumeFinal)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.textViewDiluicao)

        btnCalcular.setOnClickListener {
            val textoC1 = campoConcentracaoInicial.text.toString()
            val textoV1 = campoVolumeInicial.text.toString()
            val textoC2 = campoConcentracaoFinal.text.toString()
            val textoV2 = campoVolumeFinal.text.toString()

            val camposVazios = listOf(textoC1, textoV1, textoC2, textoV2).count { it.isBlank() }

            if (camposVazios == 0) {
                Toast.makeText(this, "Deixe um campo em branco para calculá-lo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (camposVazios > 1) {
                Toast.makeText(this, "Deixe apenas um campo em branco", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                when {
                    textoC1.isBlank() -> {
                        val v1 = textoV1.toDouble()
                        val c2 = textoC2.toDouble()
                        val v2 = textoV2.toDouble()
                        val c1 = (c2 * v2) / v1
                        mostrarResultado(resultado, "A concentração inicial é: %.2f%%".format(c1))
                    }
                    textoV1.isBlank() -> {
                        val c1 = textoC1.toDouble()
                        val c2 = textoC2.toDouble()
                        val v2 = textoV2.toDouble()
                        val v1 = (c2 * v2) / c1
                        mostrarResultado(resultado, "O volume inicial é: %.2f mL".format(v1))
                    }
                    textoC2.isBlank() -> {
                        val c1 = textoC1.toDouble()
                        val v1 = textoV1.toDouble()
                        val v2 = textoV2.toDouble()
                        val c2 = (c1 * v1) / v2
                        mostrarResultado(resultado, "A concentração final é: %.2f%%".format(c2))
                    }
                    textoV2.isBlank() -> {
                        val c1 = textoC1.toDouble()
                        val v1 = textoV1.toDouble()
                        val c2 = textoC2.toDouble()
                        val v2 = (c1 * v1) / c2
                        mostrarResultado(resultado, "O volume final é: %.2f mL".format(v2))
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores válidos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarFormulaDiluicao)
        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun mostrarResultado(textView: TextView, texto: String) {
        textView.visibility = View.VISIBLE
        textView.text = texto
    }
}