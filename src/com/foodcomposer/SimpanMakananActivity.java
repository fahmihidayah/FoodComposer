package com.foodcomposer;

import java.util.ArrayList;
import java.util.List;

import com.database_helper.DatabaseHelper;
import com.framework.adapter.CustomAdapter;
import com.framework.common_utilities.ViewSetterUtilities;
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
import android.widget.ListView;
import android.widget.Toast;

public class SimpanMakananActivity extends Activity {

	@InjectView(R.id.editTextNamaBahanMakanan)
	EditText editTextNamaBahanMakanan;
	@InjectView(R.id.editTextJenisMasakan)
	EditText editTextJenisMasakan;
	@InjectView(R.id.listViewBahanMakanan)
	ListView listViewBahanMakanan;
	
	CustomAdapter<BahanMakanan> customAdapter;
	
	@OnClick(R.id.buttonTambahBahanMakanan)
	public void onClickTambahBahanMakanan(View view) {
		if(id != -1){
			Intent intent = new Intent(this, SimpanBahanMakananActivity.class);
			intent.putExtra("idMakanan", makanan.getId());
			startActivity(intent);
		}else {
			Toast.makeText(this, "Mohon data makanan disimpan terlebih dahulu", Toast.LENGTH_LONG).show();
		}
		
	}

	@OnClick(R.id.buttonSimpan)
	public void onClickSimpan(View view) {
		makanan.setJenisMakanan(editTextJenisMasakan.getText().toString());
		makanan.setNamaMakanan(editTextNamaBahanMakanan.getText().toString());
		if(id == -1){
			getDataBaseHelper().getDaoMakanan().create(makanan);
			id = makanan.getId();
		}
		else {
			dataBaseHelper.getDaoMakanan().update(makanan);
		}
		Toast.makeText(this, "sukses menyimpan makanan", Toast.LENGTH_LONG).show();
	}

	
	int id;
	
	DatabaseHelper dataBaseHelper;

	Makanan makanan;
	
	List<BahanMakanan> listBahanMakanan = new ArrayList<BahanMakanan>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simpan_makanan_activity);
		ButterKnife.inject(this);
		id = getIntent().getIntExtra("id", -1);
		if(id == -1){
			makanan = new Makanan();
	
		}
		else {
			makanan = getDataBaseHelper().getDaoMakanan().queryForId(id);	
			editTextJenisMasakan.setText(makanan.getJenisMakanan());
			editTextNamaBahanMakanan.setText(makanan.getNamaMakanan());
		}
		
		customAdapter = new CustomAdapter<BahanMakanan>(this, R.layout.item_makanan_layout, listBahanMakanan) {
			
			@Override
			public void setViewItems(View view, final BahanMakanan data, int posisi) {
				ViewSetterUtilities.setTextToView(view, R.id.textViewNamaMakanan, data.getNamaBahanMakanan());
				ViewSetterUtilities.setOnclickButton(view, R.id.buttonDelete, new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						makanan.getDaftarBahanMakanan().remove(data);
						listBahanMakanan.remove(data);
						customAdapter.notifyDataSetChanged();
					}
				});
				ViewSetterUtilities.setOnclickButton(view, R.id.buttonEdit, new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(SimpanMakananActivity.this, SimpanBahanMakananActivity.class);
						intent.putExtra("idMakanan", makanan.getId());
						intent.putExtra("idBahanMakanan", data.getId());
						startActivity(intent);
					}
				});
			}
		};
		listViewBahanMakanan.setAdapter(customAdapter);
	}

	@Override
	protected void onResume() {
		if(id != -1){
			makanan = getDataBaseHelper().getDaoMakanan().queryForId(id);	
		}
		if(makanan.getDaftarBahanMakanan() != null){
			listBahanMakanan.clear();
			listBahanMakanan.addAll(makanan.getDaftarBahanMakanan());	
		}
		
		customAdapter.notifyDataSetChanged();
		super.onResume();
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
