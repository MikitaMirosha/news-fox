package com.insspring.poifox.ui.login

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

    private fun loginUser(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            viewState.showFillFieldsMessage()
        } else if (userRepo.isUserInStorage(username, password)) {
            viewState.openUserActivity()
        } else {
            viewState.showNoUserMessage()
        }
    }

    private fun signupUser(
        id: Int,
        username: String,
        password: String,
        passwordConfirmation: String
    ) {
        if (username.isEmpty() ||
            password.isEmpty() ||
            passwordConfirmation.isEmpty()
        ) {
            viewState.showFillFieldsMessage()
        } else if (password != passwordConfirmation) {
            viewState.showDifferentPasswordsMessage()
        } else if (userRepo.isUserInStorage(username, password)) {
            viewState.showSignUpErrorMessage()
        } else {
            userRepo.saveUser(id, username, password)
        }
    }

    fun onvTvLoginClicked() = viewState.enableLoginFields()

    fun onvTvSignupClicked() = viewState.enableSignupFields()

    fun onvIvKeepMeLoggedInClicked() = viewState.keepMeLoggedIn()

    fun onvFlLoginClicked(username: String, password: String) = loginUser(username, password)

    fun onvFlSignupClicked(
        id: Int,
        username: String,
        password: String,
        passwordConfirmation: String
    ) = signupUser(id, username, password, passwordConfirmation)

}


