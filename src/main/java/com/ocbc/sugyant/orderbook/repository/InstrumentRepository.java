package com.ocbc.sugyant.orderbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocbc.sugyant.orderbook.model.Instrument;



@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long>{

	Instrument findByIname(String name);



}
