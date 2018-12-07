package br.com.unip.helpdesk.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etiqueta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date dataInicioGarantia;
	private Date dataFimGarantia;
	private String codigo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataInicioGarantia() {
		return dataInicioGarantia;
	}
	public void setDataInicioGarantia(Date dataInicioGarantia) {
		this.dataInicioGarantia = dataInicioGarantia;
	}
	public Date getDataFimGarantia() {
		return dataFimGarantia;
	}
	public void setDataFimGarantia(Date dataFimGarantia) {
		this.dataFimGarantia = dataFimGarantia;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


}
