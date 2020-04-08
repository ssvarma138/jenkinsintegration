package org.example.helloworld.resources;

   import org.junit.FixMethodOrder;
   import org.junit.Test;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import org.example.helloworld.MyApplication;
import org.example.helloworld.MyConfiguration;
import org.junit.ClassRule;
   import org.junit.runners.MethodSorters;

import org.junit.Assert;

import java.net.URI;
import java.util.Map;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MyResourceTest {

 MyResource myResource = new MyResource();

     Response response1 ;
    String expected ,result;
    @Test
   public void addTest(){
     response1 = myResource.sayHelloUsingGet(12,14,"add");
     result = (String) response1.getEntity();

        Assert.assertEquals("26", result);


    }
    @Test
    public void subtractTest(){
     response1 = myResource.sayHelloUsingGet(12,14,"subtract");
        result = (String) response1.getEntity();

     Assert.assertEquals("-2", response1.getEntity());
    }
    @Test
    public void multiplyTest(){
     response1 = myResource.sayHelloUsingGet(12,14,"multiply");
        result = (String) response1.getEntity();

     Assert.assertEquals("168", response1.getEntity());
    }
    @Test
    public void divisionTest(){
     response1 = myResource.sayHelloUsingGet(12,14,"division");
        result = (String) response1.getEntity();

     Assert.assertEquals("0", response1.getEntity() );
    }

   @Test
   public void zmyApiTest(){
       Client client = ClientBuilder.newClient();
      /*  client.target(
               "http://localhost:8082").path("my-api").queryParam("a",14).queryParam("b",12).queryParam("operator","add")
               .request(MediaType.APPLICATION_JSON)
               .get();


       client.target(
               "http://localhost:8082").path("my-api").queryParam("a",14).queryParam("b",12).queryParam("operator","subtract")
               .request()
               .get() ;
          */
       Response response = client.target("http://localhost:8084").path("my-api/data")
                            .request(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .get();
      String actual = response.readEntity(String.class);
      expected = "12 14 add 26 12 14 division 0 12 14 multiply 168 12 14 subtract -2" ;
       Assert.assertEquals(response.getStatus(),200);

       Assert.assertEquals(expected,actual);
   }



  /*  @ClassRule
    public static final DropwizardAppRule<MyConfiguration> RULE =
            new DropwizardAppRule<MyConfiguration>(MyApplication.class,  "hello-world.yml");

    @Test
    public void myApiTest1() {
      //  Client client = RULE.client();

       Response response = client.target(String.format("http://localhost:%d/my-api", RULE.getLocalPort())).queryParam("a", 14).queryParam("b", 12).queryParam("operator", "add")
                .request()
                .get();

        // Assert.assertEquals(response.getStatus(),200);
    }

  */



}
