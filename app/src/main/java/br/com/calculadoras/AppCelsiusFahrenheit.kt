package br.com.calculadoras

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class AppCelsiusFahrenheit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_celsius_fahrenheit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorCelsius = findViewById<TextInputEditText>(R.id.editTextCelsius)
        val botaoConverterCelsius = findViewById<Button>(R.id.btnConverterCelsius)
        val textoResultadoFahrenheit = findViewById<TextView>(R.id.textViewResultadoemFahrenheit)
        val cavaleiros = findViewById<ImageView>(R.id.imgCavaleiros)

        botaoConverterCelsius.setOnClickListener {
            try {
                val celsius = valorCelsius.text.toString().toDouble()
                val calculo = (celsius * 9 / 5) + 32.0

                textoResultadoFahrenheit.visibility = View.INVISIBLE
                textoResultadoFahrenheit.alpha = 0f
                textoResultadoFahrenheit.text = "A temperatura em Fahrenheit é: %.2f°F".format(calculo)

                animarCavaleiros(cavaleiros) {
                    textoResultadoFahrenheit.visibility = View.VISIBLE
                    textoResultadoFahrenheit.animate().alpha(1f).setDuration(300).start()
                }

            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores válidos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarCelsiusFahrenheit)
        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun animarCavaleiros(cavaleiros: ImageView, aoTerminar: () -> Unit) {
        val larguraTela = resources.displayMetrics.widthPixels.toFloat()

        cavaleiros.visibility = View.VISIBLE
        cavaleiros.translationX = -larguraTela

        val animator = ObjectAnimator.ofFloat(cavaleiros, "translationX", -larguraTela, larguraTela)
        animator.duration = 1500
        animator.interpolator = AccelerateDecelerateInterpolator()

        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                cavaleiros.visibility = View.INVISIBLE
                aoTerminar()
            }
        })

        animator.start()
    }
}