package com.ocbc.sugyant.orderbook.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ocbc.sugyant.orderbook.model.OrderBook;

@Repository
public interface OrdersRepository extends JpaRepository<OrderBook, Long>{



	@Modifying
	@Transactional
	@Query("update OrderBook u set u.order_quantity = ?1, u.price = ?2 where u.id = ?3")
	void updateOrderBookById(Integer quantity, BigDecimal price, Long orderbookId);


}
