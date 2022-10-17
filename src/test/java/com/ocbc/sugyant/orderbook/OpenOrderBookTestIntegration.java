package com.ocbc.sugyant.orderbook;


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

import com.ocbc.sugyant.orderbook.model.Instrument;
import com.ocbc.sugyant.orderbook.model.OrderBookMaster;
import com.ocbc.sugyant.orderbook.repository.InstrumentRepository;
import com.ocbc.sugyant.orderbook.repository.OrderBookRepository;
import com.ocbc.sugyant.orderbook.service.OrderBookService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderBookService.class, Instrument.class, OrderBookMaster.class, H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class OpenOrderBookTestIntegration {
	
	@Autowired
	Instrument inst ;
	
	@Autowired
	OrderBookMaster ordbook;
	
	
	

	@TestConfiguration
	static class OpenOrderBookTestContextConfiguration {

		@Bean
		public OrderBookService orderBookService() {
			return new OrderBookService();
		}
	}
	
	@Autowired
    private OrderBookService orderBookSvc;

    @MockBean
    OrderBookRepository ordBookRepository;
    
    @MockBean
    InstrumentRepository instrumentRepository;
    
    
    
    @Test
	public void testOrderBookOpen() throws Exception {
		
		
		Long id = 1L;
    	
		inst.setId(id);
		inst.setIname("BTC");
		inst.setInstrument_desc("Bitcoin");
    	
    	
		ordbook.setId(id);
		ordbook.setInstrument(inst);
		ordbook.setOrder_book_status("close");
		
    	
    	Mockito.when(instrumentRepository.findByIname("BTC")).thenReturn(inst);
    	
    	Mockito.when(ordBookRepository.findByInstrument(inst)).thenReturn(ordbook);
    	
    	
    
		orderBookSvc.updateOrderBook("BTC","open");
		
		org.junit.Assert.assertEquals(ordbook.getOrder_book_status().toString(), "open");


	}
    
    
    @Test
	public void testOrderBookClose() throws Exception {
		
		
		Long id = 2L;
    	
		inst.setId(id);
		inst.setIname("TSLA");
		inst.setInstrument_desc("Tesla");
    	
    	
		ordbook.setId(id);
		ordbook.setInstrument(inst);
		ordbook.setOrder_book_status("open");
		
		//Instrument inst2 = new Instrument(id, "TSLA", "Tesla");
    	
    	//OrderBookMaster ordbook2 = new OrderBookMaster(id,"open",inst2);
    	
    	Mockito.when(instrumentRepository.findByIname("TSLA")).thenReturn(inst);
    	
    	Mockito.when(ordBookRepository.findByInstrument(inst)).thenReturn(ordbook);
    	
    	
    
		orderBookSvc.updateOrderBook("TSLA","close");
		
		org.junit.Assert.assertEquals(ordbook.getOrder_book_status().toString(), "close");


	}


}