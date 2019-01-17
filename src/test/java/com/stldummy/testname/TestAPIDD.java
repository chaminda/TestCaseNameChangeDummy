package com.stldummy.testname;


import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Scenario Tests for Scenario01_SubScenario1.1.1 with DataProvider
 */
public class TestAPIDD implements ITest
{
	private String apiName;
	
	String testInstanceName = "";
	Parameters tp;
	
	@Factory(dataProvider="apiDataProvider")
	public TestAPIDD(String apiName, String userName) {
		
		tp = new Parameters(apiName, userName);
		this.apiName = tp.getAPIName();
	}
	
	@DataProvider(name = "apiDataProvider")
    public Object[][] dataProvider() {
        return new Object[][] { { "multiResourceAPI", "publisher1" }, { "malformedAPI", "publisher2" }, { "wsdlAPI","admin" } };
    }
	
	/**
	 * Constructor for the class TestAPIDD
	 */
	public TestAPIDD() {
		
	}
	
	/**
	 * Login Test
	 */
	@Test(description="1.1.1.1")
    public void testLogin()
    {
	   System.out.println("USER NAME: "+ tp.getUserName());
       Assert.assertTrue(true);
       
    }
    
    @Test(description="1.1.1.2")
    public void testAPICreate() 
    {
    	System.out.println("APINAME: "+ tp.getAPIName());
    	this.helperMethod();
		Assert.assertTrue(true);
    }
    
    @BeforeMethod(alwaysRun = true)
    public void changeTestCaseName(Method method) {
		testInstanceName = method.getAnnotation(Test.class).description() + "_" + method.getName() +"_"+ apiName;
    }
    
    private void helperMethod() {
    	System.out.println("TEST HELPER");
    }
    
    /**
     * Implementation of the getTestName in org.testng.ITest Interface.
     * This will set the name for the test case in TEST-TestSuite.xml
     */
	public String getTestName() {
		return testInstanceName;
	}
    
}