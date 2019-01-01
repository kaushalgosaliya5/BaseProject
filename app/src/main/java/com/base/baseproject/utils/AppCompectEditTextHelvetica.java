package com.base.baseproject.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;

import com.base.baseproject.base.Constant;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppCompectEditTextHelvetica extends AppCompatEditText {

    public AppCompectEditTextHelvetica(@NonNull Context context) {
        super(context);
        init();
    }

    public AppCompectEditTextHelvetica(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AppCompectEditTextHelvetica(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        if(!isInEditMode()){
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), Constant.FONT_HELVETICA_CONDENSED_BOLD);
            setTypeface(tf);
        }
    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        text = decodeFromNonLossyAscii(text.toString());
        super.setText(text, type);
    }

    @Override
    public Editable getText() {
        Editable editable = new SpannableStringBuilder(encodeToNonLossyAscii(super.getText().toString()));
        return editable;
    }

    @NonNull
    public static String encodeToNonLossyAscii(@NonNull String original) {
        Charset asciiCharset = Charset.forName("US-ASCII");
        if (asciiCharset.newEncoder().canEncode(original)) {
            return original;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c < 128) {
                stringBuffer.append(c);
            } else if (c < 256) {
                String octal = Integer.toOctalString(c);
                stringBuffer.append("\\");
                stringBuffer.append(octal);
            } else {
                String hex = Integer.toHexString(c);
                stringBuffer.append("\\u");
                stringBuffer.append(hex);
            }
        }
        return stringBuffer.toString();
    }

    private static final Pattern UNICODE_HEX_PATTERN = Pattern.compile("\\\\u([0-9A-Fa-f]{4})");
    private static final Pattern UNICODE_OCT_PATTERN = Pattern.compile("\\\\([0-7]{3})");

    public static String decodeFromNonLossyAscii(@NonNull String original) {
        Matcher matcher = UNICODE_HEX_PATTERN.matcher(original);
        StringBuffer charBuffer = new StringBuffer(original.length());
        while (matcher.find()) {
            String match = matcher.group(1);
            char unicodeChar = (char) Integer.parseInt(match, 16);
            matcher.appendReplacement(charBuffer, Character.toString(unicodeChar));
        }
        matcher.appendTail(charBuffer);
        String parsedUnicode = charBuffer.toString();

        matcher = UNICODE_OCT_PATTERN.matcher(parsedUnicode);
        charBuffer = new StringBuffer(parsedUnicode.length());
        while (matcher.find()) {
            String match = matcher.group(1);
            char unicodeChar = (char) Integer.parseInt(match, 8);
            matcher.appendReplacement(charBuffer, Character.toString(unicodeChar));
        }
        matcher.appendTail(charBuffer);
        return charBuffer.toString();
    }
}
