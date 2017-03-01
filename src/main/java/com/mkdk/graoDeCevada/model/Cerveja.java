package com.mkdk.graoDeCevada.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Cerveja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String marca;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Embalagem embalagem;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Fermentacao fermentacao;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Litragem litragem;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Nacionalidade nacionalidade;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Pais paisOrigem;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Sabor sabor;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoCerveja tipo;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private FaixaPreco faixaPreco;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((embalagem == null) ? 0 : embalagem.hashCode());
		result = prime * result + ((faixaPreco == null) ? 0 : faixaPreco.hashCode());
		result = prime * result + ((fermentacao == null) ? 0 : fermentacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((litragem == null) ? 0 : litragem.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((paisOrigem == null) ? 0 : paisOrigem.hashCode());
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Cerveja other = (Cerveja) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (embalagem == null) {
			if (other.embalagem != null)
				return false;
		} else if (!embalagem.equals(other.embalagem))
			return false;
		if (faixaPreco == null) {
			if (other.faixaPreco != null)
				return false;
		} else if (!faixaPreco.equals(other.faixaPreco))
			return false;
		if (fermentacao == null) {
			if (other.fermentacao != null)
				return false;
		} else if (!fermentacao.equals(other.fermentacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (litragem == null) {
			if (other.litragem != null)
				return false;
		} else if (!litragem.equals(other.litragem))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (paisOrigem == null) {
			if (other.paisOrigem != null)
				return false;
		} else if (!paisOrigem.equals(other.paisOrigem))
			return false;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
}
