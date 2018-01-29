package com.example.neil.rereofitdeom.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import com.orhanobut.logger.Logger;

/**
 * Created by neil on 2018/1/26.
 */

public class ProgressDialogHandler extends Handler {

    public static final int SHOW = 1;
    public static final int DISMISS = 2;

    private ProgressDialog pd;

    private Context context;
    private boolean cancelable;
    private ProgressCancelListener listener;

    // --------------------------------------------------------
    public ProgressDialogHandler(Context context, ProgressCancelListener listener, boolean cancelable) {

        super();
        this.context = context;
        this.listener = listener;
        this.cancelable = cancelable;
    }

    // --------------------------------------------------------
    private void init() {

        if (pd == null) {

            pd = new ProgressDialog(context);
            pd.setCancelable(cancelable);

            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        if (listener != null) {
                            listener.onCancelProgress();
                        }
                    }
                });
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }

    // --------------------------------------------------------
    private void dismiss() {

        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    // --------------------------------------------------------
    @Override
    public void handleMessage(Message msg) {

        switch (msg.what) {
            case SHOW:
                init();
                break;
            case DISMISS:
                dismiss();
                break;
            default:
                dismiss();
                break;
        }
    }

    // --------------------------------------------------------
}
