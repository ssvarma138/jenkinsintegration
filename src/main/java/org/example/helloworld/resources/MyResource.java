package org.example.helloworld.resources;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.helloworld.entity.Computation;
 import org.example.helloworld.entity.persistence.RequestsDataStorage;


@Path("/my-api")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {
     RequestsDataStorage requestsDataStorage = new RequestsDataStorage();
    Computation obj;

    @GET
    public Response sayHelloUsingGet(@QueryParam("a") int a,@QueryParam("b") int b,@QueryParam("operator") String operator){

        obj = new Computation(a,b,operator);

       String result = obj.compute();

       String data = obj.toString() ;

        if (result == "I cannot service your request") {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8084").path("my-api");



        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(data, MediaType.APPLICATION_JSON));


            return Response.ok(result).build();


      //return result ;
    }

 /*   @GET
    @Path("/data")
    public Computation getData(){
        return new Computation(10,20,"add");
    }

    @GET
    @Path("/data2")
    public String getData2() throws JsonProcessingException {
        return requestsDataStorage.toString();
    }  */
}