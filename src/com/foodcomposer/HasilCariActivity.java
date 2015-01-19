package com.foodcomposer;

import java.util.ArrayList;
import java.util.Collection;
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
import android.widget.ListView;
import android.widget.Toast;


public class HasilCariActivity extends Activity {
	DatabaseHelper dataBaseHelper;
	
	@InjectView(R.id.listViewHasilCari)
	ListView listViewHasilCari;
	
	CustomAdapter<Makanan> customAdapter;
	
	List<Makanan> listMakanan = new ArrayList<Makanan>();
	
	private void doTfTdf(){
		
		ArrayList<String> listKategori = (ArrayList<String>) getIntent().getSerializableExtra("listKategori");
//		Toast.makeText(this,  "do tdf kat : " + listKategori.size(), Toast.LENGTH_LONG).show();
		int count = 0;
		List<Makanan> listMakanan = getDataBaseHelper().getDaoMakanan().queryForAll();
		for (Makanan makanan : listMakanan) {
			Collection<BahanMakanan> bahanMakanans = makanan.getDaftarBahanMakanan();
//			Toast.makeText(this,  "do tdf list mak" + listMakanan.size(), Toast.LENGTH_LONG).show();
//			Toast.makeText(this,  "do tdf bahan mak" + bahanMakanans.size(), Toast.LENGTH_LONG).show();
			for (BahanMakanan bahanMakanan : bahanMakanans) {
				for (String kategori : listKategori) {
					if(bahanMakanan.getNamaBahanMakanan().toLowerCase().contains(kategori)){
						count++;
					}
				}
			}
			
			makanan.setCount(count);
			count = 0;
		}
		
//		ArrayList<Makanan> resultMakanan = new ArrayList<Makanan>();
		for (Makanan makanan : listMakanan) {
			if(makanan.getCount() > 0){
				this.listMakanan.add(makanan);
			}
		}
//		listMakanan.clear();
//		listMakanan.addAll(resultMakanan);
//		customAdapter.notifyDataSetChanged();
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_cari_activity);
        ButterKnife.inject(this);
        doTfTdf();
        customAdapter = new CustomAdapter<Makanan>(this, R.layout.item_hasil_layout, listMakanan) {
			
			@Override
			public void setViewItems(View view, Makanan data, int posisi) {
				ViewSetterUtilities.setTextToView(view, R.id.textViewNamaMakanan, data.getNamaMakanan());
			}
		};
		listViewHasilCari.setAdapter(customAdapter);
		
    }

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(dataBaseHelper != null){
			OpenHelperManager.releaseHelper();
			dataBaseHelper = null;
		}
	}
	
	private DatabaseHelper getDataBaseHelper(){
		if(dataBaseHelper == null){
			dataBaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		}
		return dataBaseHelper;
	}



}
