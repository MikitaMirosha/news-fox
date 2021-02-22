package com.insspring.poifox.initial

import com.arellomobile.mvp.InjectViewState
import com.delivery.ui.base.BaseMvpPresenter

@InjectViewState
class InitialPresenter : BaseMvpPresenter<InitialView>() {

    init {
        viewState.updateImages()

    }
}