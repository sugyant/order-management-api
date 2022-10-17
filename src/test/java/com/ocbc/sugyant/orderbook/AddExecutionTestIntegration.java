package com.ocbc.sugyant.orderbook;


import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ocbc.sugyant.orderbook.model.ExecutionOrder;
import com.ocbc.sugyant.orderbook.model.ExecutionRequest;
import com.ocbc.sugyant.orderbook.model.Instrument;
import com.ocbc.sugyant.orderbook.model.OrderBook;
import com.ocbc.sugyant.orderbook.model.OrderBookMaster;
import com.ocbc.sugyant.orderbook.repository.ExecutionRepository;
import com.ocbc.sugyant.orderbook.repository.InstrumentRepository;
import com.ocbc.sugyant.orderbook.repository.OrderBookRepository;
import com.ocbc.sugyant.orderbook.repository.OrdersRepository;
import com.ocbc.sugyant.orderbook.service.ExecutionService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ExecutionService.class, Instrument.class, OrderBook.class, OrderBookMaster.class, H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class AddExecutionTestIntegration {

	
	@Autowired
	Instrument inst ;
	
	@Autowired
	Optional<OrderBook> ordbook;
	
	@Autowired
	OrderBookMaster master;
	
	
	@TestConfiguration
	static class AddExecutionTestContextConfiguration {

		@Bean
		public ExecutionService execService() {
			return new ExecutionService();
		}
	}
	
	@Autowired
    private ExecutionService execSvc;

   
    @MockBean
    ExecutionRepository exeRepository;
    
    @MockBean
    OrdersRepository ordRepository;
    
    @MockBean
    OrderBookRepository ordBookMstRepository;
    
    @MockBean
    InstrumentRepository instrumentRepository;
    
    
    
    @Test
	public void testAddExecutionForClosedOrderBook() throws Exception {
		
		
		long id = 7L;
		
		inst.setId(id);
		inst.setIname("SPCX");
		inst.setInstrument_desc("Space X");
		
		master.setId(id);
		master.setInstrument(inst);
    	master.setOrder_book_status("close");
    	
		ordbook.get().setId(id);
		ordbook.get().setMaster(master);
		ordbook.get().setOrder_quantity(300);
		ordbook.get().setOrder_type("limit");
		ordbook.get().setPrice(new BigDecimal(99.90));
		ordbook.get().setRemarks("Test Execution Order");
		ordbook.get().setSell_or_buy("BUY");
		ordbook.get().setEntry_date(new java.util.Date());
    	
    	ExecutionRequest exe3 = new ExecutionRequest(ordbook.get().getId(), 400, new BigDecimal(100.90));	
	    
		
    	Mockito.when(ordRepository.findById(id)).thenReturn(ordbook);
    	
    	
    	ExecutionOrder exOrd3 = execSvc.addExecution(exe3);
		
    	
    	Assert.assertEquals(exOrd3.getRemarks(),"new execution added successfully for instrument: SPCX in the order book.");
    	


	}
    
    
    @Test
	public void testFailExecutionForOpenOrderBook() throws Exception {
		
		
		long id = 8L;
		
		inst.setId(id);
		inst.setIname("MSFT");
		inst.setInstrument_desc("Microsoft");
		
		master.setId(id);
		master.setInstrument(inst);
    	master.setOrder_book_status("open");
    	
		ordbook.get().setId(id);
		ordbook.get().setMaster(master);
		ordbook.get().setOrder_quantity(250);
		ordbook.get().setOrder_type("limit");
		ordbook.get().setPrice(new BigDecimal(50.90));
		ordbook.get().setRemarks("Test Execution Order");
		ordbook.get().setSell_or_buy("BUY");
		ordbook.get().setEntry_date(new java.util.Date());
    	
    	ExecutionRequest exe3 = new ExecutionRequest(ordbook.get().getId(), 260, new BigDecimal(60.90));	
	    
		
    	Mockito.when(ordRepository.findById(id)).thenReturn(ordbook);
    	
    	
    	ExecutionOrder exOrd3 = execSvc.addExecution(exe3);
		
    	
    	Assert.assertEquals(exOrd3.getRemarks(),"REQUEST FAILED: The order book for MSFT is not closed. So you cannot add execution request yet!");
    	


	}
    
    
    
    

}