package com.ocbc.sugyant.orderbook;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OpenOrderBookTestIntegration.class, AddOrdersTestIntegration.class, AddExecutionTestIntegration.class })
public class All_Integration_Tests {

}
