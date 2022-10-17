package com.ocbc.sugyant.orderbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocbc.sugyant.orderbook.model.ExecutionOrder;
import com.ocbc.sugyant.orderbook.model.ExecutionRequest;
import com.ocbc.sugyant.orderbook.service.ExecutionService;

@RestController
@RequestMapping("/execution")
public class ExecutionController {


	@Autowired
	ExecutionService exeSvc;


	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ExecutionOrder addExecution(@RequestBody ExecutionRequest exeReq)  throws Exception{


		return exeSvc.addExecution(exeReq);
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List <ExecutionOrder> listExecutionOrder()  {


		return exeSvc.getExecutionOrder();
	}

}



