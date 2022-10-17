package com.ocbc.sugyant.orderbook.model;

import java.math.BigDecimal;

public final class ExecutionRequest {


	private Long order_book_id;

	private Integer order_quantity;

	private BigDecimal price;


	public ExecutionRequest(Long order_book_id, Integer order_quantity, BigDecimal price) {
		super();
		this.order_book_id = order_book_id;
		this.order_quantity = order_quantity;
		this.price = price;
	}


	public Long getOrder_book_id() {
		return order_book_id;
	}


	public Integer getOrder_quantity() {
		return order_quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


}
