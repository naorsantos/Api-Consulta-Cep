package com.naorsantos.consulta_cep.domain;

import java.time.LocalDateTime;

import com.naorsantos.consulta_cep.converter.LocalDateTimeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ENDERECO")
public class Cep {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "CEP", nullable = false, length = 8)
	private String cep;
	
	@Column(name = "LOGADOURO", nullable = false)
	private String lograDouro;
	
	@Column(name = "COMPLEMENTO", nullable = true)
	private String complemento;
	@Column(name = "UNIDADE", nullable = true)
	private String unidade;
	
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "LOCALIDADE", nullable = false)
	private String localidade;
	
	@Column(name = "UNIDADE_FEDERATIVA", nullable = false)
	private String uf;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@Column(name = "REGIAO", nullable = true)
	private String regiao;
	
	@Column(name = "CODIGO_IBGE", nullable = true)
	private String ibge;
	
	@Transient
	private String gia;
	
	@Column(name = "DDD", nullable = false)
	private Integer ddd;
	
	@Transient
	private String siafi;
	
	@Column(name = "DATA_HORA_INCLUSAO", nullable = false)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataHoraInclusao;
	
	public Cep(String cep, String lograDouro, String complemento, String unidade, String bairro,
			String localidade, String uf, String estado, String regiao, String ibge, String gia, Integer ddd,
			String siafi, LocalDateTime dataHoraInclusao) {
		super();
		this.cep = cep;
		this.lograDouro = lograDouro;
		this.complemento = complemento;
		this.unidade = unidade;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.estado = estado;
		this.regiao = regiao;
		this.ibge = ibge;
		this.gia = gia;
		this.ddd = ddd;
		this.siafi = siafi;
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLograDouro() {
		return lograDouro;
	}

	public void setLograDouro(String lograDouro) {
		this.lograDouro = lograDouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

	public LocalDateTime getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cep other = (Cep) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cep [id=");
		builder.append(id);
		builder.append(", cep=");
		builder.append(cep);
		builder.append(", lograDouro=");
		builder.append(lograDouro);
		builder.append(", complemento=");
		builder.append(complemento);
		builder.append(", unidade=");
		builder.append(unidade);
		builder.append(", bairro=");
		builder.append(bairro);
		builder.append(", localidade=");
		builder.append(localidade);
		builder.append(", uf=");
		builder.append(uf);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", regiao=");
		builder.append(regiao);
		builder.append(", ibge=");
		builder.append(ibge);
		builder.append(", gia=");
		builder.append(gia);
		builder.append(", ddd=");
		builder.append(ddd);
		builder.append(", siafi=");
		builder.append(siafi);
		builder.append(", dataHoraInclusao=");
		builder.append(dataHoraInclusao);
		builder.append("]");
		return builder.toString();
	}

	
}
