package com.base.baseproject.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.base.baseproject.R;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class BaseActivity extends AppCompatActivity {

    protected Dialog loadDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected double round(double value, int decimalValAfterPoint) {
        DecimalFormat df;

        if (decimalValAfterPoint == 2)
            df = new DecimalFormat("#0.00");
        else
            df = new DecimalFormat("#0.0");
        return Double.parseDouble(df.format(value));
    }


    protected String encryptTextMessage(String message) {
        byte[] cipherText = null;
        try {

            byte[] input = message.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest("galleryApp_PEOMAM".getBytes("UTF-8"));
            SecretKeySpec skc = new SecretKeySpec(thedigest, "AES/ECB/PKCS5Padding");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skc);

            cipherText = new byte[cipher.getOutputSize(input.length)];
            int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
            ctLength += cipher.doFinal(cipherText, ctLength);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.encodeToString(cipherText, Base64.DEFAULT);
    }



    /*
  On pressed back button
  */
//    public void onBtnClickBack(View view) {
//        exitActivityWithAnimation();
//    }


    protected int getScreenMesure() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.x;
    }

//    protected void startActivitywithAnimation(Intent intent, boolean isFinishActivity) {
//        hideKeyboard();
//        startActivity(intent);
//        if (isFinishActivity)
//            finish();
//        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_left);
//    }
//
//    protected void startSettingActivitywithAnimation(Intent intent, boolean isFinishActivity) {
//        hideKeyboard();
//        startActivity(intent);
//        if (isFinishActivity)
//            finish();
//        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_right);
//    }


//    protected void exitActivityWithAnimation(Intent intent) {
//        hideKeyboard();
//        startActivity(intent);
//        finish();
//        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_right);
//    }
//
//    protected void exitActivityWithAnimation() {
//        hideKeyboard();
//        finish();
//        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_right);
//    }

//    protected void exitSettingActivityWithAnimation() {
//        hideKeyboard();
//        finish();
//        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_left);
//    }

//    protected void showSpinner(Context context) {
//        if (loadDialog != null) {
//            if (loadDialog.isShowing())
//                loadDialog.dismiss();
//        }
//        loadDialog = new Dialog(context, R.style.TransparentDialogTheme);
//        loadDialog.setContentView(R.layout.spinner_rotate);
//        loadDialog.setCanceledOnTouchOutside(false);
//
//        loadDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK)
//                    return true;
//                return false;
//            }
//        });
//
//        loadDialog.show();
//    }

    /**
     * below method is for hide the spinner
     */
    protected void hideSpinner() {
        if (loadDialog.isShowing())
            loadDialog.dismiss();
    }

//    public void addFragment(Fragment fragment, boolean addToBackStack,
//                            String tagName) {
//
//        try {
//            FragmentTransaction transaction = getSupportFragmentManager()
//                    .beginTransaction();
//            if (addToBackStack) {
//                transaction.addToBackStack(tagName);
//            }
//            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_out_left, R.anim.enter_from_left, R.anim.exit_out_right);
//            transaction.add(R.id.fragIntro, fragment);
//            transaction.commitAllowingStateLoss();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

    public void popFragment(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager()
//                .beginTransaction();
//        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_out_left);
//        transaction.remove(fragment);
//        transaction.commitAllowingStateLoss();
        getSupportFragmentManager().popBackStackImmediate();
    }

    protected void hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus()
                    .getWindowToken(), 0);
        }
    }

    protected void showAlertDialog(Context context, String textMessage, final boolean isCancelBtnVisible, DialogInterface.OnClickListener clickListener) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(textMessage);
        String positiveBtnText = "";
        if(getResources().getString(R.string.alert_text).equals(textMessage)){
            positiveBtnText = "Reset";
        }else{
            positiveBtnText = getString(android.R.string.ok);
        }

        if (clickListener != null)
            builder.setPositiveButton(positiveBtnText, clickListener);
        else
            builder.setPositiveButton(positiveBtnText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // positive button logic
                            dialog.dismiss();
                        }
                    });

        builder.setCancelable(false);

        String negativeBtnText = getString(android.R.string.cancel);

        if (isCancelBtnVisible) {
            builder.setNegativeButton(negativeBtnText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // negative button logic
                            dialog.dismiss();
                        }
                    });
        }

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    protected void showAppCloseAlert(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Exit From App")
                .setMessage("Are you sure, you want to leave application?")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                moveTaskToBack(true);
                                System.gc();
                                android.os.Process
                                        .killProcess(android.os.Process
                                                .myPid());
                                System.exit(10);
                                finish();
                            }
                        })
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                            }
                        }).show();
    }

//    @Override
//    public void onBackPressed() {
//        exitActivityWithAnimation();
//    }
}