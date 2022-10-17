package com.ocbc.sugyant.orderbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ocbc.sugyant.orderbook.model.OrderBookMaster;
import com.ocbc.sugyant.orderbook.service.OrderBookService;

@RestController
@RequestMapping("/orderbook")
public class OrderBookController {

	@Autowired
	OrderBookService ordBookSvc;


	@RequestMapping(value="/instruments", method=RequestMethod.GET)
	public List<OrderBookMaster> readorderBook() {
		return ordBookSvc.getOrderBook();
	}

	@RequestMapping(value="/instruments/{instrumentName}/{status}", method=RequestMethod.PUT)
	public OrderBookMaster updateOrderBook(@PathVariable String instrumentName, @PathVariable String status)  {


		return ordBookSvc.updateOrderBook(instrumentName, status);
	}

}
