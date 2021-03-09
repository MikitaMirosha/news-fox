package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.UserModel
import com.insspring.poifox.repo.UserRepo
import com.insspring.poifox.storage.UserStorage

@InjectViewState
class LoginPresenter : BaseMvpPresenter<LoginView>() {

    // создать экземпляр repo и repo обращается к storage
    private var repo = UserRepo()
    private var userModel = repo.getUser()
    private var storageInstance = repo.getStorageInstance()

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

        val register: UserModel? = registerStorage.getRealmDefaultInstance()?.where(UserModel::class.java)
            ?.equalTo("username", username)
            ?.equalTo("password", password)
            ?.findFirst()

        if (register != null) {
            viewState.openInitialActivity()
        }
    }

    private fun isUsernameLoginEmpty(username: String): Boolean = username.isEmpty()

    private fun isPasswordLoginEmpty(password: String): Boolean = password.isEmpty()

}