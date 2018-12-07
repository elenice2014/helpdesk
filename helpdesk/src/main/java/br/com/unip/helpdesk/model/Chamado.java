package br.com.unip.helpdesk.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Chamado {

	@Id
	@GeneratedValue
	private Long id;
	private String codigo_equipamento;
	private String descricao_equipamento;
	private String descricao_detalhada;
	private String analista;
	private String usuario;
	private String produto;
	private Date dataAbertura;
	private String status;

	// @OneToOne
	// private Analista analista;
	// @OneToMany
	// private Produto produto;
	// @OneToMany
	// private Usuario usuario;

	@Transient
	private String dataFormatada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnalista() {
		return analista;
	}

	public void setAnalista(String analista) {
		this.analista = analista;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getCodigo_equipamento() {
		return codigo_equipamento;
	}

	public void setCodigo_equipamento(String codigo_equipamento) {
		this.codigo_equipamento = codigo_equipamento;
	}

	public String getDescricao_equipamento() {
		return descricao_equipamento;
	}

	public void setDescricao_equipamento(String descricao_equipamento) {
		this.descricao_equipamento = descricao_equipamento;
	}

	public String getDescricao_detalhada() {
		return descricao_detalhada;
	}

	public void setDescricao_detalhada(String descricao_detalhada) {
		this.descricao_detalhada = descricao_detalhada;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataFormatada() {
		
		if(dataAbertura != null) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String date = format.format(dataAbertura);
			System.out.println(date);
			return date;
		} else {
			return "";
		}
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

}
