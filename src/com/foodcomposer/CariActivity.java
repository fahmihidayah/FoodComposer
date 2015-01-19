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
import android.widget.EditText;
import android.widget.ListView;

public class CariActivity extends Activity {

	@InjectView(R.id.editTextKategoriCari)
	EditText editTextKategoriCari;

	@InjectView(R.id.listViewKategoriCari)
	ListView listViewKategoriCari;

	@OnClick(R.id.buttonTambah)
	public void onClickTambah(View view) {
		if (idxKategori == -1) {
			listKategori.add(editTextKategoriCari.getText().toString());
		}else {
			listKategori.set(idxKategori, editTextKategoriCari.getText().toString());
			idxKategori = -1;
		}
		customAdapter.notifyDataSetChanged();
	}

	@OnClick(R.id.buttonCari)
	public void onClikCari(View view) {
		Intent intent = new Intent(this, HasilCariActivity.class);
		intent.putExtra("listKategori", (ArrayList<String>) listKategori);
		startActivity(intent);
		
	}

	List<String> listKategori = new ArrayList<String>();

	CustomAdapter<String> customAdapter;

	int idxKategori = -1;

	DatabaseHelper dataBaseHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cari_activity);
		ButterKnife.inject(this);
		customAdapter = new CustomAdapter<String>(this,
				R.layout.item_makanan_layout, listKategori) {

			@Override
			public void setViewItems(View view, final String data,
					final int posisi) {
				ViewSetterUtilities.setTextToView(view,
						R.id.textViewNamaMakanan, data);
				ViewSetterUtilities.setOnclickButton(view, R.id.buttonDelete,
						new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								// delete
								listKategori.remove(data);
								customAdapter.notifyDataSetChanged();
							}
						});

				ViewSetterUtilities.setOnclickButton(view, R.id.buttonEdit,
						new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								// edit
								idxKategori = posisi;
								editTextKategoriCari.setText(data);
								customAdapter.notifyDataSetChanged();
							}
						});
			}
		};
		listViewKategoriCari.setAdapter(customAdapter);
	}
	



}
