package com.insspring.poifox.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
<<<<<<< HEAD
import com.arellomobile.mvp.presenter.InjectPresenter
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R
=======
import android.view.View

>>>>>>> origin
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

<<<<<<< HEAD
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
=======
    override fun onClick(view: View) {

        if (vEtPasswordSignup?.text.toString().trim { it <= ' ' }.isEmpty()) {
            vEtPasswordSignup?.error = "enter password"
            vEtPasswordSignup?.requestFocus()
        }
        if (vEtUsernameSignup?.text.toString().trim { it <= ' ' }.isEmpty()) {
            vEtUsernameSignup?.error = "enter username"
            vEtUsernameSignup?.requestFocus()
        }
        }

    }


    private fun writeToDataBase(username: String?, password: String?) {
        mRealm?.executeTransactionAsync({ bgRealm ->
            val register: Register = bgRealm.createObject()
            register.username = username
            register.password = password
        }, {
            Toast.makeText(this@SignupActivity, "success", Toast.LENGTH_SHORT).show()
        }) { error ->
            Toast.makeText(this@SignupActivity, "wrong data", Toast.LENGTH_SHORT).show()
>>>>>>> origin
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