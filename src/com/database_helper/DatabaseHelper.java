package com.database_helper;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.model.BahanMakanan;
import com.model.Makanan;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	
	private Context context;
	private static String DATA_BASE_NAME = "FOOD_COMPOSER.DB";
	private static int DATA_BASE_VERSION = 1;
	private RuntimeExceptionDao<BahanMakanan, Integer> daoBahanMakanan;
	private RuntimeExceptionDao<Makanan, Integer> daoMakanan;
	
	public DatabaseHelper(Context context) {
		super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		try {
			TableUtils.createTable(arg1, Makanan.class);
			TableUtils.createTable(arg1, BahanMakanan.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		try {
			TableUtils.dropTable(arg1, Makanan.class, false);
			TableUtils.dropTable(arg1, BahanMakanan.class, false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public RuntimeExceptionDao<BahanMakanan, Integer> getDaoBahanMakanan() {
		if(daoBahanMakanan == null){
			try {
				daoBahanMakanan = RuntimeExceptionDao.createDao(getConnectionSource(), BahanMakanan.class);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return daoBahanMakanan;
	}
	
	public RuntimeExceptionDao<Makanan, Integer> getDaoMakanan() {
		if(daoMakanan == null){
			try {
				daoMakanan = RuntimeExceptionDao.createDao(getConnectionSource(), Makanan.class);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return daoMakanan;
	}

}
