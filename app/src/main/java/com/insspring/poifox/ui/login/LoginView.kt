package com.insspring.poifox.ui.login

import com.insspring.poifox.ui.base.BaseMvpView

interface LoginView : BaseMvpView {
    fun updateImages()
    fun updateTitleName()
    fun updateRecoverPassword()

    fun openUserActivity()

    fun showFillFieldsMessage()
    fun showDifferentPasswordsMessage()
    fun showNoUserMessage()
    fun showSignUpErrorMessage()

    fun enableLoginFields()
    fun enableSignupFields()
    fun keepMeLoggedIn()
}
