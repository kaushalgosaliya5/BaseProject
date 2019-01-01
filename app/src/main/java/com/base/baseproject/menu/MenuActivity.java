package com.base.baseproject.menu;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.base.baseproject.R;
import com.base.baseproject.base.BaseActivity;

public class MenuActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//          //  case R.id.menu_settings: Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();break;
//            case R.id.menu_menu1: Toast.makeText(this, "Menu 1", Toast.LENGTH_SHORT).show();break;
//            case R.id.menu_menu2: Toast.makeText(this, "Menu 2", Toast.LENGTH_SHORT).show();break;
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_setting: Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();return true;
            case R.id.menu_menu1: Toast.makeText(this, "Menu 1", Toast.LENGTH_SHORT).show();return true;
            case R.id.menu_menu2: Toast.makeText(this, "Menu 2", Toast.LENGTH_SHORT).show();return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
