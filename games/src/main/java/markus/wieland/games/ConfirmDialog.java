package markus.wieland.games;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class ConfirmDialog {

    private final String title;
    private final String message;
    private final String confirm;
    private final String cancel;

    private DialogInterface.OnClickListener confirmClickListener;
    private DialogInterface.OnClickListener abortClickListener;

    public ConfirmDialog(String title, String message, String confirm, String cancel) {
        this.title = title;
        this.message = message;
        this.confirm = confirm;
        this.cancel = cancel;
    }

    public void setConfirmClickListener(DialogInterface.OnClickListener confirmClickListener) {
        this.confirmClickListener = confirmClickListener;
    }

    public void setAbortClickListener(DialogInterface.OnClickListener abortClickListener) {
        this.abortClickListener = abortClickListener;
    }

    public AlertDialog getDialog(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(confirm,confirmClickListener);
        builder.setNegativeButton(cancel, abortClickListener);
        return builder.create();
    }
}
