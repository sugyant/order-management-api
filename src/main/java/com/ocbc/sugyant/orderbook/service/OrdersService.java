package com.ocbc.sugyant.orderbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocbc.sugyant.orderbook.model.Instrument;
import com.ocbc.sugyant.orderbook.model.OrderBook;
import com.ocbc.sugyant.orderbook.model.OrderBookMaster;
import com.ocbc.sugyant.orderbook.model.OrderRequest;
import com.ocbc.sugyant.orderbook.repository.InstrumentRepository;
import com.ocbc.sugyant.orderbook.repository.OrderBookRepository;
import com.ocbc.sugyant.orderbook.repository.OrdersRepository;

@Service
public class OrdersService {


	@Autowired
	OrdersRepository ordsRepository;

	@Autowired
	OrderBookRepository ordBookMstRepository;

	@Autowired
	InstrumentRepository instrumentRepository;


	// CREATE 
	public OrderBook createOrderBook(OrderBook ordBook) {
		return ordsRepository.save(ordBook);
	}

	// READ
	public List<OrderBook> getOrderBook() {
		return ordsRepository.findAll();
	}

	// DELETE
	public void deleteOrderBook(Long ordBookId) {
		ordsRepository.deleteById(ordBookId);
	}

	// IMPL
	public OrderBook addOrders(OrderRequest ordReq) {

		Instrument instrument = instrumentRepository.findByIname(ordReq.getInstrument_name());

		OrderBookMaster ordBookMaster = ordBookMstRepository.findByInstrument(instrument);


		OrderBook ob = new OrderBook();

		if(ordBookMaster.getOrder_book_status().equalsIgnoreCase("close")) {

			ob.setRemarks("REQUEST FAILED: The order book for "+instrument.getIname()+" has been closed. So no more orders can be added!");
			return ob;
		}
		else {
			ob.setMaster(ordBookMaster);
			ob.setOrder_quantity(ordReq.getOrder_quantity());
			ob.setOrder_type(ordReq.getOrder_type());
			ob.setEntry_date(new java.util.Date());
			ob.setSell_or_buy(ordReq.getSell_or_buy());
			ob.setRemarks("new order added successfully for instrument: " +instrument.getIname());


			if (!ordReq.getOrder_type().equalsIgnoreCase("limit") && !ordReq.getSell_or_buy().equalsIgnoreCase("SELL")) {

				ob.setOrder_type("market");
				ob.setPrice(null);
			}
			else {
				ob.setPrice(ordReq.getPrice());
			}

			if(ordReq.getSell_or_buy().equalsIgnoreCase("SELL")) {
				ob.setOrder_type(null);
			}


		 createOrderBook(ob); 
		 return ob;

			
		}
	}


}
