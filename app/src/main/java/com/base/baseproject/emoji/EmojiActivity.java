package com.base.baseproject.emoji;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.base.baseproject.R;
import com.base.baseproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmojiActivity extends BaseActivity implements View.OnClickListener {

    @Nullable
    @BindView(R.id.etEmoji)EditText etEmoji;
    @Nullable
    @BindView(R.id.etEmojiTwo)EditText etEmojiTwo;
    @Nullable
    @BindView(R.id.tvEmoji)TextView tvEmoji;
    @Nullable
    @BindView(R.id.btnEmoji)Button btnEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);

        ButterKnife.bind(this);
    }

    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()){
            case R.id.btnEmoji: displayEmojiEdittext();break;
        }
    }

    private void displayEmojiEdittext() {
        tvEmoji.setText(etEmoji.getText());
        etEmojiTwo.setText(etEmoji.getText());
    }
}
