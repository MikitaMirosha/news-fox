package com.insspring.poifox.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.*
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R.*
import com.insspring.poifox.initial.InitialActivity
import com.insspring.poifox.model.Register
import com.insspring.poifox.signup.SignupActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : BaseMvpActivity(), View.OnClickListener, LoginView {

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun getLayoutId(): Int = layout.activity_login

    private var vEtUsernameLogin: EditText? = null
    private var vEtPasswordLogin: EditText? = null

    private var mRealm: Realm? = null

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        initListeners()
    }

    override fun onClick(view: View) {
        when (view.id) {
            id.vTvSignUp -> {
                openSignupActivity()
            }
            id.vFlLogin -> {
                if (vEtPasswordLogin?.text.toString().trim { it <= ' ' }.isEmpty()) {
                    vEtPasswordLogin?.error = "enter password"
                    vEtPasswordLogin?.requestFocus()

                    } else {
                        Toast.makeText(this, "wrong data", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    private fun initListeners() {
        vTvSignUp.setOnClickListener {
            loginPresenter.onSignupClicked()

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

    override fun updateEditText() {

    }

    override fun initOnLoginButton() {
        vFlLogin.setOnClickListener(this)
    }

    override fun updateSignupButton() {
        vTvSignUp.text = getString(string.signup)
    }

    override fun initRealm() {
        mRealm = Realm.getDefaultInstance()
    }

    override fun openSignupActivity() {
        val intent = Intent(this@LoginActivity, SignupActivity::class.java)
        startActivity(intent)
    }



}