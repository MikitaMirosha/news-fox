package com.insspring.poifox.login

import com.delivery.ui.base.BaseMvpView

interface LoginView : BaseMvpView {
    fun updateImages()
    fun updateEditText()
    fun updateTitleName()
    fun initOnLoginButton()
    fun updateSignupButton()
    fun initRealm()
    fun openSignupActivity()
    fun openInitialActivity()
}
