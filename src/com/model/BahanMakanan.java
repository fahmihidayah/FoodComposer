package com.model;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class BahanMakanan implements Serializable{
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private String namaBahanMakanan = "";
	@DatabaseField
	private String satuanUrt = "";
	@DatabaseField
	private double takaran = 0.0;
	@DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
	private Makanan makanan;
	
	public BahanMakanan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamaBahanMakanan() {
		return namaBahanMakanan;
	}
	public void setNamaBahanMakanan(String namaBahanMakanan) {
		this.namaBahanMakanan = namaBahanMakanan;
	}
	public String getSatuanUrt() {
		return satuanUrt;
	}
	public void setSatuanUrt(String satuanUrt) {
		this.satuanUrt = satuanUrt;
	}
	public double getTakaran() {
		return takaran;
	}
	public void setTakaran(double takaran) {
		this.takaran = takaran;
	}
	public Makanan getMakanan() {
		return makanan;
	}
	public void setMakanan(Makanan makanan) {
		this.makanan = makanan;
	}
	
}
