package com.ocbc.sugyant.orderbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocbc.sugyant.orderbook.model.ExecutionOrder;

@Repository
public interface ExecutionRepository extends JpaRepository<ExecutionOrder, Long>{





}
