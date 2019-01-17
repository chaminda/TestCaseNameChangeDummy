# README

## TEST-TestSuite.xml test name customization on runtime

### 1. Append description to the test case name
Requirement: User wants to customize testcase name as using own @Test attributes

> *Test attributes are @Test specific, and are to be specified right next to the @Test annotation*

ex:- description, dependsOnMethods, groups

Methodology:
Here org.testng.ITest interface is implement to change the test case name. Then @BeforeMethod is used to change the test case name dynamically before each Test method.

Sample code snipt...
```java
...
        @Test(description="1.1.1.1")
    	public void testLogin()
    	{
       		Assert.assertTrue(true);
       
    	}

	@BeforeMethod(alwaysRun = true)
        public void changeTestCaseName(Method method) {
		testInstanceName = method.getAnnotation(Test.class).description() + "_" + method.getName();
        }

	public String getTestName() {
		return testInstanceName;
	}
...
```
Results:
![Screenshot](images/results1.png)

You can find the complete source from [HERE](https://github.com/chaminda/TestCaseNameChangeDummy/blob/master/src/test/java/com/stldummy/testname/TestAPI.java).

### 2. Append dataprovider values to the test case name

Requirement: When some tests are run with Dataprovider, in the report, same test method name will be appeared multiple times on all the values of DataProvider.
So user wants to differentiate each test instances in the results(EST-TestSuite.xml). 

Methodology:
Here also we use the same method we used in above example. Additionally we append an value from DataProvider.

```Java
	@BeforeMethod(alwaysRun = true)
        public void changeTestCaseName(Method method) {
                testInstanceName = method.getAnnotation(Test.class).description() + "_" + method.getName() + "_" + apiName;
        }
```
Results:
![Screenshot](images/results2.png)


You can find the complete source from [HERE](https://github.com/chaminda/TestCaseNameChangeDummy/blob/master/src/test/java/com/stldummy/testname/TestAPIDD.java)

