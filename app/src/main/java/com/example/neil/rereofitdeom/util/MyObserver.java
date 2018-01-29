package com.example.neil.rereofitdeom.util;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by neil on 2018/1/26.
 */

public class MyObserver<T> implements Observer<T>, ProgressCancelListener {

    private ObserverOnNextListener listener;
    private Disposable d;
    private ProgressDialogHandler dialog;

    // --------------------------------------------------------
    public MyObserver(Context context, ObserverOnNextListener listener) {
        this.listener = listener;
        dialog = new ProgressDialogHandler(context, this, true);
    }

    // --------------------------------------------------------
    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        showDialog();
    }

    // --------------------------------------------------------
    @Override
    public void onNext(T value) {

        if (listener != null) {
            listener.onNext(value);
        }
    }

    // --------------------------------------------------------
    @Override
    public void onError(Throwable e) {
        dismissDialog();
    }

    // --------------------------------------------------------
    @Override
    public void onComplete() {
        dismissDialog();
    }

    // --------------------------------------------------------
    @Override
    public void onCancelProgress() {

        if (!d.isDisposed()) {
            d.dispose();
        }
    }

    // --------------------------------------------------------
    private void showDialog() {
        if (dialog != null) {
            dialog.obtainMessage(ProgressDialogHandler.SHOW).sendToTarget();
        }
    }

    // --------------------------------------------------------
    private void dismissDialog() {
        if (dialog != null) {
            dialog.obtainMessage(ProgressDialogHandler.DISMISS).sendToTarget();
            dialog = null;
        }
    }

    // --------------------------------------------------------
}
