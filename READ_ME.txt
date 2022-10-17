
Below are the Rest end-points made available

1) list  All Available Instruments
	GET http://localhost:8080/orderbook/instruments
	
2) Open OrderBook for particular Instrument
	PUT  http://localhost:8080/orderbook/instruments/{InstrumentName}/{status}
		eg) http://localhost:8080/orderbook/instruments/TSLA/open
		
3) List All Orders in the OrderBook
	GET http://localhost:8080/orders
	
4) Add an Order to the Order Book
	POST http://localhost:8080/orders with below JSON Request body 
	
	example..
	{
    "instrument_name":"BTC",
    "sell_or_buy":"BUY",
    "order_type":"limit",
    "order_quantity":"500",
    "price":20.50
	}
	
5) Create Execution request after an OrderBook is closed

	POST http://localhost:8080/execution  with below JSON RequestBody
	
	example..
	{
    "order_book_id":2,
    "order_quantity":200,
    "price": 200.50
	}
	
6) List All executions
	GET http://localhost:8080/execution
	
------

Other FAQs

1) What happens when User tries to add Order when an order book is closed?
Ans: The Response body contains remarks attribute with the message: 
	 "remarks": "REQUEST FAILED: The order book for TSLA has been closed. So no more orders can be added!",
	 and all other response params are null.
	 
2) What happens when User tries to add Execution request when an order book is still open?
Ans: The Response body contains remarks attribute with the message: 
	 "remarks": "REQUEST FAILED: The order book for TSLA is not closed. So you cannot add execution request yet!",
	 and all other response params are null.
	 

