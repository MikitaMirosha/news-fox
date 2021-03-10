package com.insspring.poifox.user

import com.arellomobile.mvp.InjectViewState
import com.insspring.poifox.ui.base.BaseMvpPresenter

@InjectViewState
class UserPresenter : BaseMvpPresenter<UserView>() {
    init {
        viewState.updateImages()
        viewState.updateTitleName()
    }
}