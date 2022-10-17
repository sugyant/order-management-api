package com.ocbc.sugyant.orderbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocbc.sugyant.orderbook.model.Instrument;
import com.ocbc.sugyant.orderbook.model.OrderBookMaster;
import com.ocbc.sugyant.orderbook.repository.InstrumentRepository;
import com.ocbc.sugyant.orderbook.repository.OrderBookRepository;

@Service
public class OrderBookService {



	@Autowired
	OrderBookRepository ordBookRepository;

	@Autowired
	InstrumentRepository instrumentRepository;


	// CREATE 
	public OrderBookMaster createOrderBook(OrderBookMaster ordBook) {
		return ordBookRepository.save(ordBook);
	}

	// READ
	public List<OrderBookMaster> getOrderBook() {
		return ordBookRepository.findAll();
	}

	// DELETE
	public void deleteOrderBook(Long ordBookId) {
		ordBookRepository.deleteById(ordBookId);
	}
	
	// DELETE
	public void getOrderBook(Long ordBookId) {
			ordBookRepository.findById(ordBookId);
	}

	// UPDATE
	public OrderBookMaster updateOrderBook(String instrumentName, String ordBookStatus) {

		Instrument instrument = instrumentRepository.findByIname(instrumentName);

		OrderBookMaster ordBook = ordBookRepository.findByInstrument(instrument);

		ordBook.setOrder_book_status(ordBookStatus);
		ordBook.setInstrument(instrument);

		return ordBookRepository.save(ordBook);                                
	}
}
