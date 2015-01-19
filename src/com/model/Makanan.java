package com.model;

import java.io.Serializable;
import java.util.Collection;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Makanan implements Serializable{
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private String namaMakanan = "";
	@DatabaseField
	private String jenisMakanan = "";
	@ForeignCollectionField(eager = true)
	private Collection<BahanMakanan> daftarBahanMakanan;

	private int count = 0;

	public Makanan(String namaMakanan, String jenisMakanan) {
		super();
		this.namaMakanan = namaMakanan;
		this.jenisMakanan = jenisMakanan;
	}

	public Makanan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaMakanan() {
		return namaMakanan;
	}

	public void setNamaMakanan(String namaMakanan) {
		this.namaMakanan = namaMakanan;
	}

	public String getJenisMakanan() {
		return jenisMakanan;
	}

	public void setJenisMakanan(String jenisMakanan) {
		this.jenisMakanan = jenisMakanan;
	}

	public Collection<BahanMakanan> getDaftarBahanMakanan() {
		return daftarBahanMakanan;
	}

	public void setDaftarBahanMakanan(
			Collection<BahanMakanan> daftarBahanMakanan) {
		this.daftarBahanMakanan = daftarBahanMakanan;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
