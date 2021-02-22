package com.insspring.poifox.signup

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter

@InjectViewState
class SignupPresenter : BaseMvpPresenter<SignupView>() {

    init {
        viewState.initRealm()
        viewState.updateEditText()
        viewState.updateTitleName()
    }

    fun onLoginClicked() {
        viewState.openLoginActivity()
    }

}