package com.foodcomposer;

import java.sql.SQLException;

import com.database_helper.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.model.BahanMakanan;
import com.model.Makanan;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SimpanBahanMakananActivity extends Activity {

	@InjectView(R.id.editTextNamaBahanMakanan)
	EditText editTextNamaBahanMakanan;
	@InjectView(R.id.editTextSatuanUrt)
	EditText editTextSatuanUrt;
	@InjectView(R.id.editTextTakaran)
	EditText editTextTakaran;
	
	@OnClick(R.id.buttonSimpan)
	public void onClickSimpan(View view){
		bahanMakanan.setTakaran(Double.parseDouble(editTextTakaran.getText().toString()));
		bahanMakanan.setNamaBahanMakanan(editTextNamaBahanMakanan.getText().toString());
		bahanMakanan.setSatuanUrt(editTextSatuanUrt.getText().toString());
		bahanMakanan.setMakanan(makanan);
		if(idBahanMakanan == -1){
			makanan.getDaftarBahanMakanan().add(bahanMakanan);
		}
		else {
			makanan.getDaftarBahanMakanan().remove(bahanMakanan);
			makanan.getDaftarBahanMakanan().add(bahanMakanan);
		}
		Toast.makeText(this,"sukses menyimpan bahan makanan", Toast.LENGTH_LONG).show();
	}
	
	int idMakanan, idBahanMakanan;
	BahanMakanan bahanMakanan;
	
	Makanan makanan;
	DatabaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpan_bahan_makanan_activity);
        ButterKnife.inject(this);
        
        idBahanMakanan = getIntent().getIntExtra("idBahanMakanan", -1);
        idMakanan = getIntent().getIntExtra("idMakanan", -1);
        makanan = getDataBaseHelper().getDaoMakanan().queryForId(idMakanan);
        if(makanan == null){
        	Toast.makeText(this, "null",Toast.LENGTH_LONG).show();
        }
        if(idBahanMakanan == -1){
        	bahanMakanan = new BahanMakanan();
        	return;
        }
        bahanMakanan = getDataBaseHelper().getDaoBahanMakanan().queryForId(idBahanMakanan);
        editTextNamaBahanMakanan.setText(bahanMakanan.getNamaBahanMakanan());
        editTextSatuanUrt.setText(bahanMakanan.getSatuanUrt());
        editTextTakaran.setText(bahanMakanan.getTakaran()+"");
    }
    

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (dataBaseHelper != null) {
			OpenHelperManager.releaseHelper();
			dataBaseHelper = null;
		}
	}

	private DatabaseHelper getDataBaseHelper() {
		if (dataBaseHelper == null) {
			dataBaseHelper = OpenHelperManager.getHelper(this,
					DatabaseHelper.class);
		}
		return dataBaseHelper;
	}
    

}
