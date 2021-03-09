package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.Register
import io.realm.Realm


@InjectViewState
class LoginPresenter : BaseMvpPresenter<LoginView>() {

    init {
        viewState.updateImages()

    }

    fun onSignupClicked() {
        viewState.openSignupActivity()
    }



    private fun isPasswordLoginEmpty(password: String): Boolean {
        if (password.isEmpty()) {
            return true
        }
        return false
    }
}

