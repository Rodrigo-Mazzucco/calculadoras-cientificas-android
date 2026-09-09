package br.com.calculadoras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telamenu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAppVelocidade = findViewById<Button>(R.id.btnAppVelocidade)
        val btnAppFisica = findViewById<Button>(R.id.btnAppFisica)
        val btnAppEnergiaCinetica = findViewById<Button>(R.id.btnEnergiaCinetica)
        val btnAppFahrenheitCelsius = findViewById<Button>(R.id.btnFahrenheitCelsius)
        val btnAppCelsiusFahrenheit = findViewById<Button>(R.id.btnCelsiusFahrenheit)
        val btnAppVolumeParalelepipedo = findViewById<Button>(R.id.btnAppVolumeParalelepipedo)
        val btnEquacaoTorricelli = findViewById<Button>(R.id.btnEquacaoTorricelli)
        val btnFormulaDiluicao = findViewById<Button>(R.id.btnFormulaDiluicao)

        btnAppVelocidade.setOnClickListener {
            startActivity(Intent(this, AppVelocidade::class.java))
        }

        btnAppFisica.setOnClickListener {
            startActivity(Intent(this, AppForca::class.java))
        }

        btnAppEnergiaCinetica.setOnClickListener {
            startActivity(Intent(this, AppEnergiaCinetica::class.java))
        }

        btnAppFahrenheitCelsius.setOnClickListener {
            startActivity(Intent(this, AppFahrenheitCelsius::class.java))
        }

        btnAppCelsiusFahrenheit.setOnClickListener {
            startActivity(Intent(this, AppCelsiusFahrenheit::class.java))
        }

        btnAppVolumeParalelepipedo.setOnClickListener {
            startActivity(Intent(this, AppVolumeParalelepipedo::class.java))
        }

        btnEquacaoTorricelli.setOnClickListener {
            startActivity(Intent(this, AppEquacaoTorricelli::class.java))
        }

        btnFormulaDiluicao.setOnClickListener {
            startActivity(Intent(this, AppFormulaDiluicao::class.java))
        }
    }
}