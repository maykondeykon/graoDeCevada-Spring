package com.mkdk.graoDeCevada.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Cerveja cerveja;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtCadastro;

	private double aroma;

	private double aparencia;

	private double sabor;

	private double sensacao;

	private double conjunto;

	private String comentario;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aparencia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(aroma);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cerveja == null) ? 0 : cerveja.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		temp = Double.doubleToLongBits(conjunto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(sabor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sensacao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (Double.doubleToLongBits(aparencia) != Double.doubleToLongBits(other.aparencia))
			return false;
		if (Double.doubleToLongBits(aroma) != Double.doubleToLongBits(other.aroma))
			return false;
		if (cerveja == null) {
			if (other.cerveja != null)
				return false;
		} else if (!cerveja.equals(other.cerveja))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (Double.doubleToLongBits(conjunto) != Double.doubleToLongBits(other.conjunto))
			return false;
		if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(sabor) != Double.doubleToLongBits(other.sabor))
			return false;
		if (Double.doubleToLongBits(sensacao) != Double.doubleToLongBits(other.sensacao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro() {
		this.dtCadastro = new Date();
	}

	public double getAroma() {
		return aroma;
	}

	public void setAroma(double aroma) {
		this.aroma = aroma;
	}

	public double getAparencia() {
		return aparencia;
	}

	public void setAparencia(double aparencia) {
		this.aparencia = aparencia;
	}

	public double getSabor() {
		return sabor;
	}

	public void setSabor(double sabor) {
		this.sabor = sabor;
	}

	public double getSensacao() {
		return sensacao;
	}

	public void setSensacao(double sensacao) {
		this.sensacao = sensacao;
	}

	public double getConjunto() {
		return conjunto;
	}

	public void setConjunto(double conjunto) {
		this.conjunto = conjunto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
