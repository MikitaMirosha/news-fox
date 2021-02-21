package com.insspring.poifox.signup

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R
import com.insspring.poifox.model.Register
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.createObject
import io.realm.kotlin.where


class SignupActivity : BaseMvpActivity(), View.OnClickListener {

    override fun getLayoutId(): Int = R.layout.activity_signup

    var vTvResult: TextView? = null
    var vEtUsername: EditText? = null
    var vEtPassword: EditText? = null
    var vBtnSignup: Button? = null
    var mRealm: Realm? = null

    override fun onCreateActivity(savedInstanceState: Bundle?) {

        vEtUsername = findViewById<View>(R.id.vEtUsername) as EditText
        vEtPassword = findViewById<View>(R.id.vEtPassword) as EditText
        vBtnSignup = findViewById<View>(R.id.vBtnSignup) as Button
        vTvResult = findViewById<View>(R.id.resultText) as TextView
        mRealm = Realm.getDefaultInstance()
        vBtnSignup?.setOnClickListener(this)
        showResults()
    }

    override fun onClick(view: View) {
        if (vEtUsername?.text.toString().trim { it <= ' ' }.isEmpty()) {
            vEtUsername?.error = "Enter username"
            vEtUsername?.requestFocus()
        }
        if (vEtPassword?.text.toString().trim { it <= ' ' }.isEmpty()) {
            vEtPassword?.error = "Enter password"
            vEtPassword?.requestFocus()
        } else {
            writeToDataBase(
                vEtUsername?.text.toString().trim { it <= ' ' },
                vEtPassword?.text.toString().trim { it <= ' ' })
        }
    }

    fun writeToDataBase(username: String?, password: String?) {
        mRealm?.executeTransactionAsync({ bgRealm ->
            val register: Register = bgRealm.createObject()
            register.username = username
            register.password = password
        }, {
            Toast.makeText(this@SignupActivity, "Success", Toast.LENGTH_SHORT).show()
            showResults()
        }) { error ->
            Toast.makeText(this@SignupActivity, "Fail", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mRealm?.close()
    }

    private fun showResults() {
        val registerList: RealmResults<Register> = mRealm?.where<Register>()!!.findAll()
        vTvResult?.text = registerList.toString()
    }
}


