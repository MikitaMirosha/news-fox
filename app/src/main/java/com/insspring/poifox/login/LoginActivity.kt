package com.insspring.poifox.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R
import com.insspring.poifox.initial.InitialActivity
import com.insspring.poifox.model.Register
import com.insspring.poifox.signup.SignupActivity
import io.realm.Realm
import java.util.*


class LoginActivity : BaseMvpActivity(), View.OnClickListener {

    override fun getLayoutId(): Int = R.layout.activity_login

    var vEtUsername: EditText? = null
    var vEtPassword: EditText? = null
    private var mRealm: Realm? = null

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        val vBtnLogin = findViewById<Button>(R.id.vBtnLogin)
        val vBtnSignup = findViewById<Button>(R.id.vBtnSignupInLogin)
        vEtPassword = findViewById<View>(R.id.vEtPasswordLogin) as EditText
        vEtUsername = findViewById<View>(R.id.vEtUsernameLogin) as EditText
        mRealm = Realm.getDefaultInstance()
        vBtnLogin.setOnClickListener(this)
        vBtnSignup.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.vBtnSignupInLogin -> {
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
            }
            R.id.vBtnLogin -> {
                if (vEtUsername?.text.toString().trim { it <= ' ' }.isEmpty()) {
                    vEtUsername?.error = "Enter username"
                    vEtUsername?.requestFocus()
                }
                if (vEtPassword?.text.toString().trim { it <= ' ' }.isEmpty()) {
                    vEtPassword?.error = "Enter password"
                    vEtPassword?.requestFocus()
                } else {
                    val email = vEtUsername?.text.toString()
                    val password = vEtPassword?.text.toString()
                    val user: Register? = mRealm?.where(Register::class.java)
                        ?.equalTo("username", email)
                        ?.equalTo("password", password)
                        ?.findFirst()
                    if (user != null) {
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LoginActivity, InitialActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}