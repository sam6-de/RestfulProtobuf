package de.sam6.demo.microservice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Sascha
 * Date: 19.06.2015
 * Time: 23:39
 */
public class HelloWorldServiceTest {

    HelloWorldService testService;

    @Before
    public void setUp() throws Exception {
         testService = new HelloWorldService();
    }

    @After
    public void tearDown() throws Exception {
        testService = null;
    }

    @Test
    public void testGetName() throws Exception {
        Response expected = Response.status(200).entity("Hello, UnitTest!").build();
        Response actual = testService.getName("UnitTest");
        assertEquals("Service did not say hello to me.", expected.getEntity(), actual.getEntity());
        assertEquals("HTTP response code did not match.", expected.getStatus(), actual.getStatus());
    }
}