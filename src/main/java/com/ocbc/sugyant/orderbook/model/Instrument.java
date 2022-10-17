package com.ocbc.sugyant.orderbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INSTRUMENT")

public class Instrument {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="iname")
	private String iname;

	@Column(name="idesc")
	private String idesc;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIname() {
		return iname;
	}


	public void setIname(String iname) {
		this.iname = iname;
	}


	public String getInstrument_desc() {
		return idesc;
	}


	public void setInstrument_desc(String instrument_desc) {
		this.idesc = instrument_desc;
	}





}
