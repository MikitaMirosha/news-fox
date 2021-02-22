package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter

@InjectViewState
class LoginPresenter : BaseMvpPresenter<LoginView>() {

    init {
        viewState.updateImages()
        viewState.updateEditText()

        viewState.initOnLoginButton()
        viewState.updateSignupButton()
        viewState.initRealm()
    }

    fun onSignupClicked() {
        viewState.openSignupActivity()
    }



}
