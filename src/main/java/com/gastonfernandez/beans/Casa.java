package com.gastonfernandez.beans;

import java.util.Date;

public class Casa {
	private String nombre;
	private String compra;
	private String venta;
	private String decimales;
	private Date actualizationDate;

	public Casa() {
		this.nombre = "";
		this.compra = "";
		this.venta = "";
		this.decimales = "";
		this.actualizationDate = new Date();
	}

	public Casa(String nombre, String compra, String venta, String decimales) {
		this.nombre = nombre;
		this.compra = compra;
		this.venta = venta;
		this.decimales = decimales;
		this.actualizationDate = new Date();
	}

	public Casa(String nombre, String compra, String venta, Date actualizationDate) {
		this.nombre = nombre;
		this.compra = compra;
		this.venta = venta;
		this.decimales = "";
		this.actualizationDate = actualizationDate;
	}

	public Casa(String nombre, String compra, String venta, String decimales, Date actualizationDate) {
		this.nombre = nombre;
		this.compra = compra;
		this.venta = venta;
		this.decimales = decimales;
		this.actualizationDate = actualizationDate;
	}

	public Date getActualizationDate() {
		return actualizationDate;
	}

	public void setActualizationDate(Date actualizationDate) {
		this.actualizationDate = actualizationDate;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompra() {
		return compra;
	}

	public void setCompra(String compra) {
		this.compra = compra;
	}

	public String getVenta() {
		return venta;
	}

	public void setVenta(String venta) {
		this.venta = venta;
	}

	public String getDecimales() {
		return decimales;
	}

	public void setDecimales(String decimales) {
		this.decimales = decimales;
	}

}
