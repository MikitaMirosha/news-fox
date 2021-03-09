package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.repo.UserRepo

@InjectViewState
class LoginPresenter : BaseMvpPresenter<LoginView>() {

    private val repo = UserRepo()

    init {
        viewState.updateImages()
        viewState.updateTitleName()
        viewState.updateSignupButton()
        viewState.showInvalidUsername()
        viewState.showInvalidPassword()
    }

    fun onSignupClicked() {
        viewState.openSignupActivity()
    }

    fun onEnterClicked(username: String, password: String) {
        if (isPasswordLoginEmpty(password)) {
            viewState.showInvalidPassword()
        }
        if (isUsernameLoginEmpty(username)) {
            viewState.showInvalidUsername()
        }

        val user = repo.getUser(username, password)

        if(user != null) {
            viewState.openInitialActivity()
        }
    }

    private fun isUsernameLoginEmpty(username: String): Boolean = username.isEmpty()

    private fun isPasswordLoginEmpty(password: String): Boolean = password.isEmpty()

}