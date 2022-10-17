package com.ocbc.sugyant.orderbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocbc.sugyant.orderbook.model.ExecutionOrder;
import com.ocbc.sugyant.orderbook.model.ExecutionRequest;
import com.ocbc.sugyant.orderbook.model.OrderBook;
import com.ocbc.sugyant.orderbook.repository.ExecutionRepository;
import com.ocbc.sugyant.orderbook.repository.OrdersRepository;

@Service
public class ExecutionService {


	@Autowired
	ExecutionRepository exeRepository;

	@Autowired
	OrdersRepository ordRepository;



	// CREATE 
	public ExecutionOrder createExecutionOrder(ExecutionOrder exeOrder) {
		return exeRepository.save(exeOrder);
	}

	// READ
	public List<ExecutionOrder> getExecutionOrder() {
		return exeRepository.findAll();
	}

	// DELETE
	public void deleteExecutionOrder(Long ordBookId) {
		exeRepository.deleteById(ordBookId);
	}

	// UPDATE
	public ExecutionOrder addExecution(ExecutionRequest exeReq) {

		long ordId = exeReq.getOrder_book_id();

		Optional<OrderBook> ordBook = ordRepository.findById(ordId);


		ExecutionOrder eb = new ExecutionOrder();

		if(ordBook.get().getMaster().getOrder_book_status().equalsIgnoreCase("open")) {

			eb.setRemarks("REQUEST FAILED: The order book for "+ordBook.get().getMaster().getInstrument().getIname()+" is not closed. So you cannot add execution request yet!");
			return eb;
		}
		else {

			eb.setOrder_bk(ordBook.get());
			eb.setOrder_quantity(exeReq.getOrder_quantity());
			eb.setRemarks("new execution added successfully for instrument: " +ordBook.get().getMaster().getInstrument().getIname() +" in the order book.");
			eb.setPrice(exeReq.getPrice());
			eb.setEntry_date(new java.util.Date());


			createExecutionOrder(eb); 

			ordRepository.updateOrderBookById(eb.getOrder_quantity(),eb.getPrice(),eb.getOrder_bk().getId());


			return eb;

		}
	}



}
