package com.example.minimoneybox.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import java.util.regex.Pattern
import android.animation.Animator
import com.example.minimoneybox.R


/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    lateinit var btn_sign_in : Button
    lateinit var til_email : TextInputLayout
    lateinit var et_email : EditText
    lateinit var til_password : TextInputLayout
    lateinit var et_password : EditText
    lateinit var til_name : TextInputLayout
    lateinit var et_name : EditText
    lateinit var pigAnimation : LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViews()
    }

    override fun onStart() {
        super.onStart()
        setupAnimation()
    }

    private fun setupViews() {
        btn_sign_in = findViewById(R.id.btn_sign_in)
        til_email = findViewById(R.id.til_email)
        et_email = findViewById(R.id.et_email)
        til_password = findViewById(R.id.til_password)
        et_password = findViewById(R.id.et_password)
        til_name = findViewById(R.id.til_name)
        et_name = findViewById(R.id.et_name)
        pigAnimation = findViewById(R.id.animation)

        btn_sign_in.setOnClickListener {
            if (allFieldsValid()) {
                Toast.makeText(this, R.string.input_valid, Toast.LENGTH_LONG).show()
                val name = et_name.text.toString()
            }
        }


    }

    private fun allFieldsValid() : Boolean {
        til_email.error = null
        til_password.error = null
        til_name.error = null

        val emailValid = Pattern.matches(EMAIL_REGEX, et_email.text.toString())
        val passwordValid = Pattern.matches(PASSWORD_REGEX, et_password.text.toString())
        val nameValid = Pattern.matches(NAME_REGEX, et_name.text.toString())

        val allValid = emailValid && passwordValid && nameValid

        if (!emailValid) {
            til_email.error = getString(R.string.email_address_error)
        }
        if (!passwordValid)  {
            til_password.error = getString(R.string.password_error)
        }

        if (!nameValid)  {
            til_name.error = getString(R.string.full_name_error)
        }

        return allValid
    }

    private fun setupAnimation() {
        pigAnimation.setMinAndMaxFrame(firstAnim.first, firstAnim.second)
        pigAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                pigAnimation.setMinAndMaxFrame(secondAnim.first, secondAnim.second)
                pigAnimation.repeatCount = LottieDrawable.INFINITE
                pigAnimation.playAnimation()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }

        })
        pigAnimation.playAnimation()

    }

    companion object {
        val EMAIL_REGEX = "[^@]+@[^.]+\\..+"
        val NAME_REGEX = "[a-zA-Z]{6,30}"
        val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[A-Z]).{10,50}$"
        val firstAnim = 0 to 109
        val secondAnim = 131 to 158
    }
}
