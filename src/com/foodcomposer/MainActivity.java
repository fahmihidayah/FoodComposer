package com.foodcomposer;

import butterknife.ButterKnife;
import butterknife.OnClick;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
    
    @OnClick(R.id.buttonMenuMakanan)
    public void onClickMenuMakanan(View view){
    	startActivity(new Intent(this, DaftarMakananActivity.class));
    }
    
    @OnClick(R.id.buttonMetode)
    public void onClickMetode(View view){
    	startActivity(new Intent(this, CariActivity.class));
    }

}
