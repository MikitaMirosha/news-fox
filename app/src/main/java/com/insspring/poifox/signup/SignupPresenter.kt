package com.insspring.poifox.signup

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.UserModel
import com.insspring.poifox.repo.UserRepo
import com.insspring.poifox.storage.UserStorage
import io.realm.kotlin.createObject

@InjectViewState
class SignupPresenter : BaseMvpPresenter<SignupView>() {

    private var repo = UserRepo()

    init {
        viewState.updateTitleName()
        viewState.showInvalidUsername()
        viewState.showInvalidPassword()
        viewState.showInvalidPasswordConfirmation()
    }

    fun onLoginClicked() {
        viewState.openLoginActivity()
    }

    private fun isUser(username: String, password: String): Boolean {
        val user = repo.getUserByUsernameAndPassword(username, password)

        if(user?.username != null || user?.password != null) {
            if(user.username == username && user.password == password) {
                return true
            }
        }
        return false
    }

    fun onSignupClicked(username: String, password: String, confirmPassword: String) {

        if(!(isPasswordSignupEmpty(password))) {
            if(!(isUsernameSignupEmpty(username))) {
                if (confirmPassword == password) {
                    if((isUser(username, password))) {
                        showMessage("invalid data")
                    } else {
                        saveUser(username, password)
                    }
                } else {
                    viewState.showInvalidPasswordConfirmation()
                }
            } else {
                viewState.showInvalidUsername()
            }
        } else {
            viewState.showInvalidPassword()
        }
    }

    private fun saveUser(username: String?, password: String?) {
        if(repo.saveUser(username, password)) {
            showMessage("success")
        } else {
            showMessage("wrong data")
        }
    }

    private fun isUsernameSignupEmpty(username: String): Boolean = username.isEmpty()

    private fun isPasswordSignupEmpty(password: String): Boolean = password.isEmpty()

}
