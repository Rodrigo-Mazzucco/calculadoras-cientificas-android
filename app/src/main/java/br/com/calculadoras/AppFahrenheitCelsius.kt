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

class AppFahrenheitCelsius : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_fahrenheit_celsius)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorFahrenheit = findViewById<TextInputEditText>(R.id.editTextFahrenheit)
        val botaoConverterFahrenheit = findViewById<Button>(R.id.btnConverterFahrenheit)
        val textoResultadoCelsius = findViewById<TextView>(R.id.textViewResultadoemCelsius)
        val cavaleiros = findViewById<ImageView>(R.id.imgCavaleiros)

        botaoConverterFahrenheit.setOnClickListener {
            try {
                val fahrenheit = valorFahrenheit.text.toString().toDouble()
                val calculo = (fahrenheit - 32.0) * 5 / 9

                textoResultadoCelsius.visibility = View.INVISIBLE
                textoResultadoCelsius.alpha = 0f
                textoResultadoCelsius.text = "A temperatura em Celsius é: %.2f°C".format(calculo)

                animarCavaleiros(cavaleiros) {
                    textoResultadoCelsius.visibility = View.VISIBLE
                    textoResultadoCelsius.animate().alpha(1f).setDuration(300).start()
                }

            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores válidos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltarFahrenheitCelsius)
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