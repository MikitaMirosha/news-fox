package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.repo.UserRepo
import com.insspring.poifox.model.UserModel
import com.insspring.poifox.repo.UserRepo
import com.insspring.poifox.storage.UserStorage

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
        if(!(isPasswordLoginEmpty(password))) {
            if(!(isUsernameLoginEmpty(username))) {
                val user = repo.getUserByUsernameAndPassword(username, password)
                if(user != null) {
                    viewState.openInitialActivity()
                }
            } else {
                viewState.showInvalidUsername()
            }
        } else {
            viewState.showInvalidPassword()
        }
    }

    private fun isUsernameLoginEmpty(username: String): Boolean = username.isEmpty()

    private fun isPasswordLoginEmpty(password: String): Boolean = password.isEmpty()

}
