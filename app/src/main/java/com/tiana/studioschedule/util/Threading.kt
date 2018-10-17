package com.tiana.studioschedule.util

import rx.Observable
import rx.Observer
import rx.schedulers.Schedulers

fun background(block: () -> Unit) {
    Observable.fromCallable(block)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object: Observer<Unit?> {
                override fun onError(e: Throwable?) {
                    throw RuntimeException(e)
                }

                override fun onNext(t: Unit?) { }

                override fun onCompleted() { }
            })
}

fun background(block: () -> Unit, onCompletedBlock: () -> Unit) {
    Observable.fromCallable(block)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object: Observer<Unit?> {
                override fun onError(e: Throwable?) {
                    throw RuntimeException(e)
                }

                override fun onNext(t: Unit?) { }

                override fun onCompleted() { onCompletedBlock() }
            })
}