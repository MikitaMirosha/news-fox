package com.insspring.poifox.signup

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.Register
import io.realm.Realm
import io.realm.kotlin.createObject

@InjectViewState
class SignupPresenter : BaseMvpPresenter<SignupView>() {

    init {
        viewState.updateTitleName()
        viewState.showInvalidUsername()
        viewState.showEditTextPasswordHint()
        viewState.showEditTextInvalidConfirmationHint()
    }
    // в отдельном файле
    private fun getRealmDefaultInstance(): Realm? {
        return Realm.getDefaultInstance()
    }

    fun onLoginClicked() {
        viewState.openLoginActivity()
    }

    private fun isRegistered(username: String, password: String): Boolean {
        val register: Register? = getRealmDefaultInstance()?.where(Register::class.java)
            ?.equalTo("username", username)
            ?.equalTo("password", password)
            ?.findFirst()

        if(register?.username == username && register.password == password) {
            return true
        }
        return false
    }

    fun onSignupClicked(username: String, password: String, confirmPassword: String) {
        if (isPasswordSignupEmpty(password)) {
            viewState.showEditTextPasswordHint()
        }

        if (isUsernameSignupEmpty(username)) {
            viewState.showInvalidUsername()
        }

        if (confirmPassword != password) {
            viewState.showEditTextInvalidConfirmationHint()
        }

        if(isRegistered(username, password)) { // запись пустых полей
            showMessage("invalid data")
        } else {
            writeToDataBase(username, password)
        }
    }

    private fun writeToDataBase(username: String?, password: String?) { // save register
        getRealmDefaultInstance()?.executeTransactionAsync({ bgRealm ->
            val register: Register = bgRealm.createObject()
            register.username = username
            register.password = password
        }, {
            showMessage("success")
        }) {
            showMessage("wrong data")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        getRealmDefaultInstance()?.close()
    }

    private fun isUsernameSignupEmpty(username: String): Boolean = username.isEmpty()

    private fun isPasswordSignupEmpty(password: String): Boolean = password.isEmpty()

}