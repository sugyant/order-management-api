package com.ocbc.sugyant.orderbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_BOOK_MASTER")

public class OrderBookMaster {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="order_book_status")
	private String order_book_status;

	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="instrument_id")
	public Instrument instrument;


	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOrder_book_status() {
		return order_book_status;
	}


	public void setOrder_book_status(String order_book_status) {
		this.order_book_status = order_book_status;
	}


	public Instrument getInstrument() {
		return instrument;
	}


	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}


}
