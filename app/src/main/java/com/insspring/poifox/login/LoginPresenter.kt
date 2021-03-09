package com.insspring.poifox.login

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter
import com.insspring.poifox.model.UserModel
import com.insspring.poifox.repo.UserRepo
import com.insspring.poifox.storage.UserStorage

@InjectViewState
class LoginPresenter : BaseMvpPresenter<LoginView>() {

    }

    fun onSignupClicked() {
        viewState.openSignupActivity()
    }
