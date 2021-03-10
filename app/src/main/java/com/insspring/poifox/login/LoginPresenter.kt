package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.insspring.poifox.repo.UserRepo
import com.insspring.poifox.ui.base.BaseMvpPresenter

@InjectViewState
class LoginPresenter : BaseMvpPresenter<LoginView>() {

    private var userRepo = UserRepo()

    init {
        viewState.updateImages()
        viewState.updateTitleName()
    }

    fun loginUser(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            viewState.showFillFieldsMessage()
        } else if (userRepo.isUserLoggedIn(username, password)) {
            viewState.openUserActivity()
            viewState.showSuccessMessage()
        } else {
            viewState.showInvalidMessage()
        }
    }

    fun signupUser(id: Int, username: String, password: String, passwordConfirmation: String) {
        if (username.isEmpty() ||
            password.isEmpty() ||
            passwordConfirmation.isEmpty()
        ) {
            viewState.showFillFieldsMessage()
        } else if (password != passwordConfirmation) {
            viewState.showDifferentPasswordsMessage()
        } else if (userRepo.isUserLoggedIn(username, password)) {
            viewState.showInvalidMessage()
        } else {
            userRepo.saveUser(id, username, password)
            viewState.showSuccessMessage()
        }
    }

    fun onvTvLoginClicked() = viewState.enableLoginFields()

    fun onvTvSignupClicked() = viewState.enableSignupFields()

    fun onvIvKeepMeLoggedInClicked() = viewState.keepMeLoggedIn()

    fun onvFlLoginClicked() = viewState.loginUserAccount()

    fun onvFlSignupClicked() = viewState.signupUserAccount()

}


