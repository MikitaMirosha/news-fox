package com.insspring.poifox.initial

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R
import com.insspring.poifox.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class InitialActivity : BaseMvpActivity(), InitialView {

    @InjectPresenter
    lateinit var initialPresenter: InitialPresenter

    override fun getLayoutId(): Int = R.layout.activity_initial

    override fun onCreateActivity(savedInstanceState: Bundle?) {}

    override fun updateImages() {
        Glide.with(this)
            .load(R.drawable.ic_fox)
            .placeholder(R.drawable.ic_fox)
            .into(vIvFox)
    }
}