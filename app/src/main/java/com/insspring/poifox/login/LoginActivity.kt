package com.insspring.poifox.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.*
import androidx.core.content.ContextCompat
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.insspring.poifox.R.*
import com.insspring.poifox.ui.base.BaseMvpActivity
import com.insspring.poifox.user.UserActivity
import com.insspring.poifox.utils.extensions.hide
import com.insspring.poifox.utils.extensions.show
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : BaseMvpActivity(), LoginView {

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun getLayoutId(): Int = layout.activity_login

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initListeners()
    }

    private fun initListeners() {
        vTvLogin.setOnClickListener {
            loginPresenter.onvTvLoginClicked()
        }
        vTvSignUp.setOnClickListener {
            loginPresenter.onvTvSignupClicked()
        }
        vIvKeepLogIn.setOnClickListener {
            loginPresenter.onvIvKeepMeLoggedInClicked()
        }
        vFlLogIn.setOnClickListener {
            loginPresenter.onvFlLoginClicked()
        }
        vFlSignUp.setOnClickListener {
            loginPresenter.onvFlSignupClicked()
        }
    }

    override fun updateImages() {
        Glide.with(this)
            .load(drawable.ic_fox)
            .placeholder(drawable.ic_fox)
            .into(vIvFox)

        Glide.with(this)
            .load(drawable.ic_key)
            .placeholder(drawable.ic_key)
            .into(vIvKey)
    }

    override fun updateTitleName() {
        val spannable = SpannableString(getString(string.poifox))
        spannable.setSpan(
            ForegroundColorSpan(Color.WHITE),
            0,
            2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#EB874B")),
            3,
            6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        vTvTitleNameLogin.text = spannable
    }

    override fun openUserActivity() =
        startActivity(Intent(this@LoginActivity, UserActivity::class.java))

    override fun showInvalidMessage() = showMessage("invalid data")

    override fun showSuccessMessage() = showMessage("success")

    override fun showFillFieldsMessage() = showMessage("fill in all fields")

    override fun showDifferentPasswordsMessage() = showMessage("passwords are different")

    override fun enableLoginFields() {
        vTvLogin.setTextColor(ContextCompat.getColor(this, color.colorOrange))
        vTvSignUp.setTextColor(ContextCompat.getColor(this, color.colorWhite))
        vEtConfirmPassword.hide()
        vFlSignUp.hide()
        vFlLogIn.show()
    }

    override fun enableSignupFields() {
        vTvLogin.setTextColor(ContextCompat.getColor(this, color.colorWhite))
        vTvSignUp.setTextColor(ContextCompat.getColor(this, color.colorOrange))
        vFlLogIn.hide()
        vEtConfirmPassword.show()
        vFlSignUp.show()
    }

    override fun keepMeLoggedIn() {
        if (vIvKeepLogIn.background.constantState?.equals(
                ContextCompat.getDrawable(
                    this,
                    drawable.ic_uncheck
                )?.constantState
            ) == true
        ) {
            vIvKeepLogIn.setBackgroundResource(drawable.ic_check)
        } else {
            vIvKeepLogIn.setBackgroundResource(drawable.ic_uncheck)
        }
    }

    override fun loginUserAccount() =
        loginPresenter.loginUser(vEtUsername.text.toString(), vEtPassword.text.toString())

    override fun signupUserAccount() {
        loginPresenter.signupUser(
            0,
            vEtUsername.text.toString(),
            vEtPassword.text.toString(),
            vEtConfirmPassword.text.toString()
        )
    }

}