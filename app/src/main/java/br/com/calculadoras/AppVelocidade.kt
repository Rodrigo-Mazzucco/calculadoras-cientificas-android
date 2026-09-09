package br.com.calculadoras

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppVelocidade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.appvelocidade)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val distancia = findViewById<EditText>(R.id.edtDistancia)
        val tempo = findViewById<EditText>(R.id.editTempo)
        val calcular = findViewById<Button>(R.id.btnVelocidade)
        val velocidade = findViewById<TextView>(R.id.textViewVelocidade)
        val carrinho = findViewById<ImageView>(R.id.imgCarrinho)
        val fumaca1 = findViewById<TextView>(R.id.fumaca1)
        val fumaca2 = findViewById<TextView>(R.id.fumaca2)
        val fumaca3 = findViewById<TextView>(R.id.fumaca3)

        calcular.setOnClickListener {
            try {
                val distancia1 = distancia.text.toString().toDouble()
                val tempo1 = tempo.text.toString().toDouble()
                val calculo = distancia1 / tempo1

                velocidade.visibility = View.INVISIBLE
                velocidade.alpha = 0f
                velocidade.text = "A sua velocidade média foi de: %.2f km/h".format(calculo)

                animarCarrinho(carrinho, fumaca1, fumaca2, fumaca3) {
                    velocidade.visibility = View.VISIBLE
                    velocidade.animate().alpha(1f).setDuration(300).start()
                }

            } catch (e: Exception) {
                Toast.makeText(this, "Digite valores validos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun animarCarrinho(
        carrinho: ImageView,
        fumaca1: TextView,
        fumaca2: TextView,
        fumaca3: TextView,
        aoTerminar: () -> Unit
    ) {
        val larguraTela = resources.displayMetrics.widthPixels.toFloat()

        carrinho.visibility = View.VISIBLE
        carrinho.translationX = larguraTela

        val animCarro = ObjectAnimator.ofFloat(carrinho, "translationX", larguraTela, -200f)
        animCarro.duration = 1500
        animCarro.interpolator = AccelerateDecelerateInterpolator()

        animCarro.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                carrinho.visibility = View.INVISIBLE
                fumaca1.visibility = View.INVISIBLE
                fumaca2.visibility = View.INVISIBLE
                fumaca3.visibility = View.INVISIBLE
                aoTerminar()
            }
        })

        animCarro.start()
        animarFumaca(fumaca1, larguraTela, 180f, 0L)
        animarFumaca(fumaca2, larguraTela, 240f, 100L)
        animarFumaca(fumaca3, larguraTela, 300f, 200L)
    }

    private fun animarFumaca(fumaca: TextView, larguraTela: Float, offsetAtrasCarro: Float, atraso: Long) {
        fumaca.visibility = View.VISIBLE
        fumaca.alpha = 0f
        fumaca.translationX = larguraTela + offsetAtrasCarro

        val mover = ObjectAnimator.ofFloat(fumaca, "translationX", larguraTela + offsetAtrasCarro, -200f + offsetAtrasCarro)
        val aparecer = ObjectAnimator.ofFloat(fumaca, "alpha", 0f, 0.8f, 0f)

        val conjunto = AnimatorSet()
        conjunto.playTogether(mover, aparecer)
        conjunto.duration = 1500
        conjunto.startDelay = atraso
        conjunto.interpolator = AccelerateDecelerateInterpolator()
        conjunto.start()
    }
}