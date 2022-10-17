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
@Table(name="EXECUTION_ORDER")

public class ExecutionOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="order_book_id")
	private OrderBook order_bk;

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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderBook getOrder_bk() {
		return order_bk;
	}

	public void setOrder_bk(OrderBook order_bk) {
		this.order_bk = order_bk;
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

}
