package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.Register
import io.realm.Realm

@InjectViewState
class LoginPresenter : BaseMvpPresenter<LoginView>() {

    init {
        viewState.updateImages()
        viewState.updateTitleName()
        viewState.updateSignupButton()
        viewState.showEditTextUsernameHint()
        viewState.showEditTextPasswordHint()
    }

    fun onSignupClicked() {
        viewState.openSignupActivity()
    }

    private fun getRealmDefaultInstance(): Realm? {
        return Realm.getDefaultInstance()
    }

    fun onEnterClicked(username: String, password: String) {

        if (isPasswordLoginEmpty(password)) {
            viewState.showEditTextPasswordHint()
        }
        if (isUsernameLoginEmpty(username)) {
            viewState.showEditTextUsernameHint()
        }

        val register: Register? = getRealmDefaultInstance()?.where(Register::class.java)
            ?.equalTo("username", username)
            ?.equalTo("password", password)
            ?.findFirst()

        if (register != null) {
            viewState.openInitialActivity()
        }
    }

    private fun isUsernameLoginEmpty(username: String): Boolean {
        if (username.isEmpty()) {
            return true
        }
        return false
    }

    private fun isPasswordLoginEmpty(password: String): Boolean {
        if (password.isEmpty()) {
            return true
        }
        return false
    }
}

