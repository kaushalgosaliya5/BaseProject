package com.base.baseproject.designpattern.builderdesign;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;

import com.base.baseproject.R;
import com.base.baseproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuilderDesignPatternActivity extends BaseActivity {

    @BindView(R.id.tvTitle)
    AppCompatTextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder_design_pattern_activity);
        ButterKnife.bind(this);

        setValueOfPersonBean();
    }

    private void setValueOfPersonBean() {

         PersonBean personBean = new PersonBean.Builder("kaushal","gosaliya",10)
                 .setHeight(10)
                 .build();

         tvTitle.setText("FirstName: " + personBean.getFirstName() + " LastName: " + personBean.getLastName() + "\nAge: " + personBean.getAge() + " Height: " + personBean.getHeight());
    }
}
