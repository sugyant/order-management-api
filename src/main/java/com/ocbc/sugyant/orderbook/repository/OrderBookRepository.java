package com.ocbc.sugyant.orderbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocbc.sugyant.orderbook.model.Instrument;
import com.ocbc.sugyant.orderbook.model.OrderBookMaster;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBookMaster, Long>{

	public OrderBookMaster findByInstrument(Instrument instrument);



}
