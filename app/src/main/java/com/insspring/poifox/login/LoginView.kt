package com.insspring.poifox.login

import com.insspring.poifox.ui.base.BaseMvpView

interface LoginView : BaseMvpView {
    fun updateImages()
    fun updateTitleName()

    fun openUserActivity()

    fun showInvalidMessage()
    fun showSuccessMessage()
    fun showFillFieldsMessage()
    fun showDifferentPasswordsMessage()

    fun enableLoginFields()
    fun enableSignupFields()
    fun keepMeLoggedIn()

    fun loginUserAccount()
    fun signupUserAccount()
}
