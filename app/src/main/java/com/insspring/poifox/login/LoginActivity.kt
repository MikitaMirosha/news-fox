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

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun getLayoutId(): Int = layout.activity_login

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initListeners()
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

    }

    override fun updateSignupButton() {
        vTvSignUp.text = getString(string.signup)
    }

    override fun openSignupActivity() {
        val intent = Intent(this@LoginActivity, SignupActivity::class.java)
        startActivity(intent)
    }

}