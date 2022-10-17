package com.ocbc.sugyant.orderbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocbc.sugyant.orderbook.model.OrderBook;
import com.ocbc.sugyant.orderbook.model.OrderRequest;
import com.ocbc.sugyant.orderbook.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	OrdersService ordsSvc;


	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public OrderBook addOrders(@RequestBody OrderRequest ordReq)  throws Exception{


		return ordsSvc.addOrders(ordReq);
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List <OrderBook> listOrderBook()  {


		return ordsSvc.getOrderBook();
	}

}
