package com.insspring.poifox.initial

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.delivery.ui.base.BaseMvpActivity
import com.insspring.poifox.R
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

    override fun updateTitleName() {
        val spannable = SpannableString(getString(R.string.poifox))
        spannable.setSpan(
            ForegroundColorSpan(Color.WHITE),
            0,
            2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#EB874B")), // цвет в колорс
            3,
            6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        vTvTitleNameLogin.text = spannable
    }
}