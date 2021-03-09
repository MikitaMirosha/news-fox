package com.insspring.poifox.signup

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter

@InjectViewState
class SignupPresenter : BaseMvpPresenter<SignupView>() {

    fun onLoginClicked() {
        viewState.openLoginActivity()
    }

}