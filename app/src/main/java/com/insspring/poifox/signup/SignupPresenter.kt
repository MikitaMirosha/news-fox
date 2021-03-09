package com.insspring.poifox.signup

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.UserModel
import com.insspring.poifox.repo.UserRepo
import com.insspring.poifox.storage.UserStorage
import io.realm.kotlin.createObject


@InjectViewState
class SignupPresenter : BaseMvpPresenter<SignupView>() {

<<<<<<< HEAD
    private val userStorage: UserStorage = UserStorage()

    private var repo = UserRepo()
    // создать экземпляр repo и repo обращается к storage

    init {
        viewState.updateTitleName()
        viewState.showInvalidUsername()
        viewState.showInvalidPassword()
        viewState.showInvalidPasswordConfirmation()
    }
=======
>>>>>>> origin

    fun onLoginClicked() {
        viewState.openLoginActivity()
    }

<<<<<<< HEAD
    private fun isUser(username: String, password: String): Boolean {
        val register: UserModel? = userStorage.getRealmDefaultInstance()?.where(UserModel::class.java)
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
            viewState.showInvalidPassword()
        }

        if (isUsernameSignupEmpty(username)) {
            viewState.showInvalidUsername()
        }

        if (confirmPassword != password) {
            viewState.showInvalidPasswordConfirmation()
        }

        if(isUser(username, password)) { // запись пустых полей
            showMessage("invalid data")
        } else {
            saveUser(username, password)
        }
    }

    private fun saveUser(username: String?, password: String?) {
        userStorage.getRealmDefaultInstance()?.executeTransactionAsync({ bgRealm ->
            val register: UserModel = bgRealm.createObject()
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
        repo.closeStorage()
    }

    private fun isUsernameSignupEmpty(username: String): Boolean = username.isEmpty()

    private fun isPasswordSignupEmpty(password: String): Boolean = password.isEmpty()
=======
>>>>>>> origin

}