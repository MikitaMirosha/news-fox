package com.insspring.poifox.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.arellomobile.mvp.presenter.InjectPresenter
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R
import com.insspring.poifox.login.LoginActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*


class SignupActivity : BaseMvpActivity(), SignupView {

    @InjectPresenter
    lateinit var signupPresenter: SignupPresenter

    override fun getLayoutId(): Int = R.layout.activity_signup

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initListeners()
    }

    private fun initListeners() {
        vTvLogIn.setOnClickListener {
            signupPresenter.onLoginClicked()
        }

        vFlSignup.setOnClickListener {
            signupPresenter.onSignupClicked(
                vEtUsernameSignup.text.toString(),
                vEtPasswordSignup.text.toString(),
                vEtConfirmPassword.text.toString()
            )
        }
    }

    override fun openLoginActivity() {
        val intent = Intent(this@SignupActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun updateTitleName() {
        val spannable = SpannableString(getString(R.string.poifox))
        spannable.setSpan(
            ForegroundColorSpan(Color.WHITE),
            0,
            2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#EB874B")), // цвет в колорс
            3,
            6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        vTvTitleNameSignUp.text = spannable
    }

    override fun showInvalidUsername() {
        vEtUsernameLogin?.error = "enter username"
        vEtUsernameLogin?.requestFocus()
    }

    override fun showInvalidPassword() {
        vEtPasswordLogin?.error = "enter password"
        vEtPasswordLogin?.requestFocus()
    }

    override fun showInvalidPasswordConfirmation() {
        vEtConfirmPassword?.error = "invalid confirmation"
        vEtConfirmPassword?.requestFocus()
    }

}
