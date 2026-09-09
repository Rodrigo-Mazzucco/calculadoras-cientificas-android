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

class AppVolumeParalelepipedo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_volume_paralelepipedo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val valorComprimentoBase = findViewById<TextInputEditText>(R.id.editTextComprimentoBase)
        val valorLarguraBase = findViewById<TextInputEditText>(R.id.editTextLarguraBase)
        val valorAlturaParalelepipedo = findViewById<TextInputEditText>(R.id.editTextAlturaParalelepipedo)
        val btnCalcularVolume = findViewById<Button>(R.id.btnCalcularVolume)
        val volume = findViewById<TextView>(R.id.textViewVolume)

        btnCalcularVolume.setOnClickListener {
            try {
                val comprimentoBase = valorComprimentoBase.text.toString().toDouble()
                val larguraBase = valorLarguraBase.text.toString().toDouble()
                val alturaParalelepipedo = valorAlturaParalelepipedo.text.toString().toDouble()

                val calculo = comprimentoBase * larguraBase * alturaParalelepipedo

                volume.visibility = View.VISIBLE
                volume.text = "O volume do paralelepípedo é: %.2f cm³".format(calculo)
            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores válidos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarVolumeParalelepipedo)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}