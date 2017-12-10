package com.eread;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;

public class ProgressDialog {

  Dialog dialog;

  public ProgressDialog(Context context) {
    dialog = new Dialog(context);
    dialog.setContentView(R.layout.progress_dialog);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

    dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
        WindowManager.LayoutParams.MATCH_PARENT);
  }

  public void show() {
    dialog.show();
  }

  public void dismissDialog() {
    dialog.dismiss();
  }
}
