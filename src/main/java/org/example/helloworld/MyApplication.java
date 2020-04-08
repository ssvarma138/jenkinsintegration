package org.example.helloworld;


import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.helloworld.resources.MyResource;



import sun.jvm.hotspot.HelloWorld;


public class MyApplication extends Application<MyConfiguration>
{

    public static void main(String[] args) throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("The current working directory is " + currentDirectory);
        new MyApplication().run(args);
    }



    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {

        final MyResource myResource = new MyResource();
       environment.jersey().register(myResource);

    }
}
