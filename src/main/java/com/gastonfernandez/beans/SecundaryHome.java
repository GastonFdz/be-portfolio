package com.gastonfernandez.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SecundaryHome {

	private String moneda;
	private String casa;
	private String nombre;
	private double compra;
	private double venta;
	@JsonProperty("fechaActualizacion")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date fecha;

	public SecundaryHome() {
		this.moneda = "";
		this.casa = "";
		this.nombre = "";
		this.compra = 0;
		this.venta = 0;
		this.fecha = new Date();
	}

	public SecundaryHome(String moneda, String casa, String nombre, double compra, double venta, Date fecha) {
		this.moneda = moneda;
		this.casa = casa;
		this.nombre = nombre;
		this.compra = compra;
		this.venta = venta;
		this.fecha = fecha;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCompra() {
		return compra;
	}

	public void setCompra(double compra) {
		this.compra = compra;
	}

	public double getVenta() {
		return venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
