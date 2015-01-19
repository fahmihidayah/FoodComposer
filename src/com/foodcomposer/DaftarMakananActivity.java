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
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class DaftarMakananActivity extends FragmentActivity {

	@InjectView(R.id.listViewMakanan)
	ListView listViewMakanan;
	
	DatabaseHelper dataBaseHelper;
	
	List<Makanan> listMakanan = new ArrayList<Makanan>();
	
	CustomAdapter<Makanan> customAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_makanan_activity);
        ButterKnife.inject(this);
        
        
        customAdapter = new CustomAdapter<Makanan>(this, R.layout.item_makanan_layout, listMakanan) {
			
			@Override
			public void setViewItems(View view, final Makanan data, int posisi) {
				ViewSetterUtilities.setTextToView(view, R.id.textViewNamaMakanan, data.getNamaMakanan());
				ViewSetterUtilities.setOnclickButton(view, R.id.buttonDelete, new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						getDataBaseHelper().getDaoMakanan().delete(data);
						listMakanan.remove(data);
						customAdapter.notifyDataSetChanged();
					}
				});
				ViewSetterUtilities.setOnclickButton(view, R.id.buttonEdit, new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(DaftarMakananActivity.this, SimpanMakananActivity.class);
						intent.putExtra("id", data.getId());
						DaftarMakananActivity.this.startActivity(intent);
					}
				});
			}
		};
		listViewMakanan.setAdapter(customAdapter);
    }
    
    @OnClick(R.id.buttonTambah)
    public void onClickTambah(View view){
    	Intent intent = new Intent(this, SimpanMakananActivity.class);
    	intent.putExtra("id", -1);
    	startActivity(intent);
    }

    @Override
    protected void onResume() {
    	listMakanan.clear();
    	listMakanan.addAll(getDataBaseHelper().getDaoMakanan().queryForAll());
    	customAdapter.notifyDataSetChanged();
    	super.onResume();
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
