package com.example.foodmarket.ui.detail

import android.os.Handler
import android.util.Log
import android.view.View
import com.example.foodmarket.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PaymentPresenter (private val view: PaymentContract.View) : PaymentContract.Presenter{

    private val mCompositeDisposable: CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun getCheckout(foodId: String, userId: String, qty: String, total: String, viewParams: View) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.checkout(
            foodId, userId, qty, total, "DELIVERED"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()
                    if (it.meta?.status.equals("success", true)) {
                        it.data?.let {
                                it1 -> view.onCheckoutSuccess(it1, viewParams)
                            Log.e("PAYMENT",it1.toString())
                        }
                    } else {
                        it.meta?.message?.let { it1 -> view.onCheckoutFailed(it1) }
                    }
                },
                {
                    view.dismissLoading()
                    view.onCheckoutFailed(it.message.toString())
                }
            )
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }
}