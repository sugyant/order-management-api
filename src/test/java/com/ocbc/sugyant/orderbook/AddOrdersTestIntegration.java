package com.ocbc.sugyant.orderbook;


import java.math.BigDecimal;

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

import com.ocbc.sugyant.orderbook.model.Instrument;
import com.ocbc.sugyant.orderbook.model.OrderBook;
import com.ocbc.sugyant.orderbook.model.OrderBookMaster;
import com.ocbc.sugyant.orderbook.model.OrderRequest;
import com.ocbc.sugyant.orderbook.repository.InstrumentRepository;
import com.ocbc.sugyant.orderbook.repository.OrderBookRepository;
import com.ocbc.sugyant.orderbook.repository.OrdersRepository;
import com.ocbc.sugyant.orderbook.service.OrdersService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrdersService.class, Instrument.class, OrderBookMaster.class, H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class AddOrdersTestIntegration {

	
	@Autowired
	Instrument inst ;
	
	@Autowired
	OrderBookMaster ordbook;
	
	
	@TestConfiguration
	static class AddOrdersTestContextConfiguration {

		@Bean
		public OrdersService ordersService() {
			return new OrdersService();
		}
	}
	
	@Autowired
    private OrdersService ordersSvc;

    @MockBean
    OrderBookRepository ordBookMstRepository;
    
    @MockBean
    InstrumentRepository instrumentRepository;
    
    @MockBean
    OrdersRepository ordsRepository;
    
    
    
    @Test
	public void testAddLimitBuyOrder() throws Exception {
		
		
		Long id = 3L;
		
		inst.setId(id);
		inst.setIname("ETH");
		inst.setInstrument_desc("Ethereum");
    	
    	
		ordbook.setId(id);
		ordbook.setInstrument(inst);
		ordbook.setOrder_book_status("open");
    	
    	//Instrument inst3 = new Instrument(id, "ETH", "Ethereum");
    	
    	//OrderBookMaster ordbook3 = new OrderBookMaster(id,"open",inst3);
    	
    	Mockito.when(instrumentRepository.findByIname("ETH")).thenReturn(inst);
    	
    	Mockito.when(ordBookMstRepository.findByInstrument(inst)).thenReturn(ordbook);
    	
    	
    	OrderRequest ordr3 = new OrderRequest(inst.getIname(), "limit", 100, new BigDecimal(99.95), "BUY");	
    
    	OrderBook orBk3 = ordersSvc.addOrders(ordr3);
		
    	
    	Assert.assertEquals(orBk3.getMaster().getInstrument().getIname(),"ETH");
    	


	}
    
    
    @Test
	public void testAddLimitSellOrder() throws Exception {
		
		
		Long id = 4L;
    	
		inst.setId(id);
		inst.setIname("DOGE");
		inst.setInstrument_desc("Dogecoin");
    	
    	
		ordbook.setId(id);
		ordbook.setInstrument(inst);
		ordbook.setOrder_book_status("open");
		
		//Instrument inst4 = new Instrument(id, "DOGE", "Dogecoin");
    	
    	//OrderBookMaster ordbook4 = new OrderBookMaster(id,"open",inst4);
    	
    	Mockito.when(instrumentRepository.findByIname("DOGE")).thenReturn(inst);
    	
    	Mockito.when(ordBookMstRepository.findByInstrument(inst)).thenReturn(ordbook);
    	
    	
    	OrderRequest ordr4 = new OrderRequest(inst.getIname(), "limit", 200, new BigDecimal(199.95), "SELL");	
    
    	OrderBook orBk4 = ordersSvc.addOrders(ordr4);
		
    	
    	Assert.assertEquals(orBk4.getMaster().getInstrument().getIname(),"DOGE");
    	


	}
    
    
    @Test
	public void testAddMarketSellOrder() throws Exception {
		
		
		Long id = 5L;
    	
		inst.setId(id);
		inst.setIname("AMAZN");
		inst.setInstrument_desc("Amazon");
    	
    	
		ordbook.setId(id);
		ordbook.setInstrument(inst);
		ordbook.setOrder_book_status("open");
		
		//Instrument inst5 = new Instrument(id, "AMAZN", "Amazon");
    	
    	//OrderBookMaster ordbook5 = new OrderBookMaster(id,"open",inst5);
    	
    	Mockito.when(instrumentRepository.findByIname("AMAZN")).thenReturn(inst);
    	
    	Mockito.when(ordBookMstRepository.findByInstrument(inst)).thenReturn(ordbook);
    	
    	
    	OrderRequest ordr5 = new OrderRequest(inst.getIname(), "limit", 200, new BigDecimal(199.95), "SELL");	
    
    	OrderBook orBk5 = ordersSvc.addOrders(ordr5);
		
    	
    	Assert.assertEquals(orBk5.getMaster().getInstrument().getIname(),"AMAZN");
    	


	}
    
    
    @Test
	public void testAddMarketBuyOrder() throws Exception {
		
		
		Long id = 5L;
    	
		inst.setId(id);
		inst.setIname("APPL");
		inst.setInstrument_desc("Apple");
    	
    	
		ordbook.setId(id);
		ordbook.setInstrument(inst);
		ordbook.setOrder_book_status("open");
		
		//Instrument inst5 = new Instrument(id, "APPL", "Apple");
    	
    	//OrderBookMaster ordbook5 = new OrderBookMaster(id,"open",inst5);
    	
    	Mockito.when(instrumentRepository.findByIname("APPL")).thenReturn(inst);
    	
    	Mockito.when(ordBookMstRepository.findByInstrument(inst)).thenReturn(ordbook);
    	
    	
    	OrderRequest ordr5 = new OrderRequest(inst.getIname(), "limit", 300, new BigDecimal(299.95), "BUY");	
    
    	OrderBook orBk5 = ordersSvc.addOrders(ordr5);
		
    	
    	Assert.assertEquals(orBk5.getMaster().getInstrument().getIname(),"APPL");
    	


	}
   
    
    @Test
	public void testFailAddOrderForclosedOrderBook() throws Exception {
		
		
		Long id = 6L;
    	
		inst.setId(id);
		inst.setIname("TWTR");
		inst.setInstrument_desc("Twitter");
    	
    	
		ordbook.setId(id);
		ordbook.setInstrument(inst);
		ordbook.setOrder_book_status("close");
		
		//Instrument inst5 = new Instrument(id, "APPL", "Apple");
    	
    	//OrderBookMaster ordbook5 = new OrderBookMaster(id,"open",inst5);
    	
    	Mockito.when(instrumentRepository.findByIname("TWTR")).thenReturn(inst);
    	
    	Mockito.when(ordBookMstRepository.findByInstrument(inst)).thenReturn(ordbook);
    	
    	
    	OrderRequest ordr6 = new OrderRequest(inst.getIname(), "limit", 400, new BigDecimal(399.95), "BUY");	
    
    	OrderBook orBk6 = ordersSvc.addOrders(ordr6);
		
    	
    	Assert.assertEquals(orBk6.getRemarks(),"REQUEST FAILED: The order book for TWTR has been closed. So no more orders can be added!");
    	


	}
    
    

}