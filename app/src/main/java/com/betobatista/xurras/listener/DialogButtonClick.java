package com.betobatista.xurras.listener;

import android.support.v7.app.AlertDialog;
import android.view.View;

public abstract class DialogButtonClick implements View.OnClickListener {

    private AlertDialog dialog;

    public DialogButtonClick(AlertDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void onClick(View view) {
        if(onClicked()){
            dialog.dismiss();
        }
    }

    protected abstract boolean onClicked();
}