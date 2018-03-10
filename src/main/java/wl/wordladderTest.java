package wl;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;


/** 
* wl.wordladder Tester.
* 
* @author <Authors name> 
* @since <pre>���� 10, 2018</pre> 
* @version 1.0 
*/ 
public class wordladderTest {

@Before
public void before() throws Exception {
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: letin(node n) 
* 
*/ 
@Test
@Ignore
public void testLetin() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: letout() 
* 
*/ 
@Test
@Ignore
public void testLetout() throws Exception { 
//TODO: Test goes here...
    wordladder w = new wordladder();
    assertEquals(null,w.letout());
} 

/** 
* 
* Method: push(node t, String obj) 
* 
*/ 
@Test
@Ignore
public void testPush() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: printNode(node n) 
* 
*/ 
@Test
@Ignore
public void testPrintNode() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: makeWordSet(String filename) 
* 
*/ 
@Test
public void testMakeWordSet() throws Exception { 
//TODO: Test goes here...
    wordladder w = new wordladder();
    assertEquals(false,w.makeWordSet("not exist"));
    assertEquals(true,w.makeWordSet("./src/dicts/dictionary.txt"));
} 

/** 
* 
* Method: findNearBy(node n, String dest) 
* 
*/ 
@Test
@Ignore
public void testFindNearBy() throws Exception { 
//TODO: Test goes here...
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here...
    //ignored
    testFindNearBy();
    testLetin();
    testLetout();
    testPrintNode();
    testMakeWordSet();
    testPush();
    wordladder w = new wordladder();
    ByteArrayInputStream in = null;
    in = new ByteArrayInputStream("data code".getBytes());
    System.setIn(in);
    w.main(null);
    in = new ByteArrayInputStream("metal azure".getBytes());
    System.setIn(in);
    w.main(null);
} 


} 
