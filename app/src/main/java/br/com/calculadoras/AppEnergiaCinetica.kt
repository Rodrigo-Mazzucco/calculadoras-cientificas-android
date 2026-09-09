package br.com.calculadoras

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class AppEnergiaCinetica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_energia_cinetica)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorMassa = findViewById<TextInputEditText>(R.id.editTextMassa)
        val valorVelocidade = findViewById<TextInputEditText>(R.id.editTextVelocidade)
        val botao = findViewById<Button>(R.id.buttonEnergiaCinetica)
        val caminhoResultado = findViewById<TextView>(R.id.textViewResultadoEnergiaCinetica)
        val corredor = findViewById<TextView>(R.id.textViewCorredor)

        botao.setOnClickListener {
            try {
                val massa = valorMassa.text.toString().toDouble()
                val velocidade = valorVelocidade.text.toString().toDouble()

                val energiaCinetica = massa * Math.pow(velocidade, 2.0) / 2

                caminhoResultado.visibility = View.INVISIBLE
                caminhoResultado.alpha = 0f
                caminhoResultado.text = "A energia cinética desse objeto é: %.2f J".format(energiaCinetica)

                animarCorredor(corredor) {
                    caminhoResultado.visibility = View.VISIBLE
                    caminhoResultado.animate().alpha(1f).setDuration(300).start()
                }

            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores válidos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarEnergiaCinetica)
        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun animarCorredor(corredor: TextView, aoTerminar: () -> Unit) {
        val larguraTela = resources.displayMetrics.widthPixels.toFloat()

        corredor.visibility = View.VISIBLE
        corredor.translationX = -150f
        corredor.rotation = 0f

        // Movimento horizontal, da esquerda pra direita
        val mover = ObjectAnimator.ofFloat(corredor, "translationX", -150f, larguraTela)
        mover.duration = 900
        mover.interpolator = LinearInterpolator()

        // Pequeno "balanço" pra cima e pra baixo, simulando a passada da corrida
        val pular = ObjectAnimator.ofFloat(corredor, "translationY", 0f, -12f, 0f, -12f, 0f, -12f, 0f)
        pular.duration = 900
        pular.interpolator = LinearInterpolator()

        mover.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                corredor.visibility = View.INVISIBLE
                aoTerminar()
            }
        })

        mover.start()
        pular.start()
    }
}