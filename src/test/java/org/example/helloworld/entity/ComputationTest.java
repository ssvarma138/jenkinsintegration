package org.example.helloworld.entity;

import org.testng.annotations.Test;
import org.testng.Assert;

public class ComputationTest {
    Computation computation ;
    String result;

    @Test
    public void cAddTest(){
        result = new Computation(14,12,"add").compute();
        Assert.assertEquals(result,"26");
    }

    @Test
    public void cSubtarctTest(){
        result = new Computation(14,12,"subtract").compute();
        Assert.assertEquals(result,"2");
       }

    @Test
    public void cMultiplyTest(){
        result = new Computation(14,12,"multiply").compute();
        Assert.assertEquals(result,"168");
    }
    @Test
    public void cDivisionTest(){
        result = new Computation(14,12,"division").compute();
        Assert.assertEquals(result,"1");
    }

}
