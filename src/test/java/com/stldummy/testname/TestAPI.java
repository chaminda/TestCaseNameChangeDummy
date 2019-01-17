package com.stldummy.testname;


import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class TestAPI implements ITest
{
	
	String testInstanceName = "";
 
	/**
	 * Login Test
	 */
	@Test(description="1.1.1.1")
    public void testLogin()
    {
       Assert.assertTrue(true);
       
    }
    
    @Test(description="1.1.1.2")
    public void testAPICreate() 
    {
    	this.helperMethod();
		Assert.assertTrue(true);
    }
    
	@Test(description="1.1.1.3")
    public void testCreateAPIfromWSDL()
    {
       Assert.assertTrue(true);
       
    }
	
	@Test(description="1.1.1.4")
    public void testCreateAPIfromIvalidName()
    {
       Assert.assertTrue(true);
    }
    
    @BeforeMethod(alwaysRun = true)
    public void changeTestCaseName(Method method) {
		testInstanceName = method.getAnnotation(Test.class).description() + "_" + method.getName();
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