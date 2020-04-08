package org.example.helloworld.resources;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.example.helloworld.MyApplication;
import org.example.helloworld.MyConfiguration;
import org.junit.ClassRule;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

public class AllResourcesTest {
    @ClassRule
    public static final DropwizardAppRule<MyConfiguration> RULE =
            new DropwizardAppRule<>(MyApplication.class, ResourceHelpers.resourceFilePath("hello-world.yaml"));

    @Test
    public void myApiTest() {
        Client client = RULE.client();

     /*   Response response = client.target(String.format("http://localhost:%d/my-api", RULE.getLocalPort())).queryParam("a", 14).queryParam("b", 12).queryParam("operator", "add")
                .request()
                .get();       */

       // Assert.assertEquals(response.getStatus(),200);
    }
}
