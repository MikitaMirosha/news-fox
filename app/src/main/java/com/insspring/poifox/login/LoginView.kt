package com.insspring.poifox.login

import com.delivery.ui.base.BaseMvpView

interface LoginView : BaseMvpView {
    fun updateImages()
    fun updateTitleName()
    fun updateSignupButton()
    fun openSignupActivity()
    fun openInitialActivity()
    fun showInvalidUsername()
    fun showInvalidPassword()
}
