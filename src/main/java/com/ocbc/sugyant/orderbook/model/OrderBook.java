package com.ocbc.sugyant.orderbook.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ORDER_BOOK")

public class OrderBook {



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderBookMaster getMaster() {
		return master;
	}

	public void setMaster(OrderBookMaster master) {
		this.master = master;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public Integer getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Integer order_quantity) {
		this.order_quantity = order_quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="order_book_id")
	private OrderBookMaster master;

	
	@Column(name="order_type")
	private String order_type;

	@Column(name="sell_or_buy")
	private String sell_or_buy;

	public String getSell_or_buy() {
		return sell_or_buy;
	}

	public void setSell_or_buy(String sell_or_buy) {
		this.sell_or_buy = sell_or_buy;
	}

	@Column(name="remarks")
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name="quantity")
	private Integer order_quantity;

	@Column(name="price")
	private BigDecimal price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="entry_date")
	private Date entry_date;    

}
