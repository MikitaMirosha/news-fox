package com.insspring.poifox.signup

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.Register
import io.realm.Realm

@InjectViewState
class SignupPresenter : BaseMvpPresenter<SignupView>() {

    private val model = Register()

    init {
        viewState.updateTitleName()
    }

    private fun getRealmDefaultInstance(): Realm? {
        return Realm.getDefaultInstance()
    }

    fun onLoginClicked() {
        viewState.openLoginActivity()
    }

    fun isRegistered(username: String, password: String): Boolean {
        if(model.username == username || model.password == password) {
            return true
        }
        return false
    }

}