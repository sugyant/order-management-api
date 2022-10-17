package com.ocbc.sugyant.orderbook.model;

import java.math.BigDecimal;

public final class OrderRequest {


	private String instrument_name;

	private String order_type;

	private String sell_or_buy;

	private Integer order_quantity;

	private BigDecimal price;


	public OrderRequest(String instrument_name, String order_type, Integer order_quantity, BigDecimal price, String sell_or_buy) {
		super();
		this.instrument_name = instrument_name;
		this.order_type = order_type;
		this.order_quantity = order_quantity;
		this.price = price;
		this.sell_or_buy=sell_or_buy;
	}


	public String getInstrument_name() {
		return instrument_name;
	}


	public String getOrder_type() {
		return order_type;
	}


	public Integer getOrder_quantity() {
		return order_quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}

	public String getSell_or_buy() {
		return sell_or_buy;
	}

}
