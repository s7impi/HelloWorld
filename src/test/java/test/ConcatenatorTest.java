package test;

import main.Concatenator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/** 
* main.Concatenator Tester.
* 
* @author Witold Oleszkiewicz
* @sinceMar 21, 2015
* @version 1.0 
*/ 
public class ConcatenatorTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: concatenate(String one, String two) 
* 
*/ 
@Test
public void testConcatenate() throws Exception { 
    Concatenator concatenator = new Concatenator();
    String result = concatenator.concatenate("Hello ", "world!");
    Assert.assertEquals("Hello world!", result);


} 


} 
