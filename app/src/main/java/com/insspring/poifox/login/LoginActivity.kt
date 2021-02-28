package com.insspring.poifox.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.*
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R.*
import com.insspring.poifox.initial.InitialActivity
import com.insspring.poifox.signup.SignupActivity
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
        vTvSignUp.setOnClickListener {
            loginPresenter.onSignupClicked()
            //finish()
        }

        vFlLogin.setOnClickListener {
            loginPresenter.onEnterClicked(
                vEtUsernameLogin.text.toString(),
                vEtPasswordLogin.text.toString()
            )
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

    override fun updateSignupButton() {
        vTvSignUp.text = getString(string.signup)
    }

    override fun openSignupActivity() {
        val intent = Intent(this@LoginActivity, SignupActivity::class.java)
        startActivity(intent)
    }

    override fun openInitialActivity() {
        val intent = Intent(this@LoginActivity, InitialActivity::class.java)
        startActivity(intent)
    }

    override fun showEditTextUsernameHint() {
        vEtUsernameLogin?.error = "enter username"
        vEtUsernameLogin?.requestFocus()
    }

    override fun showEditTextPasswordHint() {
        vEtPasswordLogin?.error = "enter password"
        vEtPasswordLogin?.requestFocus()
    }

}