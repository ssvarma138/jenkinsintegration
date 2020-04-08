package org.example.helloworld.entity;


public class Computation {
    final int num1;
    final int num2;
    final String operator;
    public String result;

    public Computation(int num1,int num2,String operator){
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(num1+" ").append(num2+" ").append(operator+" ").append(result);

        return sb.toString();
    }
    public String compute(){

        if(operator.equals("add")){
            result = Integer.toString(num1+num2);
        }
        else if(operator.equals("subtract")){
            result = Integer.toString(num1-num2);
        }
        else if(operator.equals("multiply")){
            result = Integer.toString(num1*num2) ;
        }
        else if(operator.equals("division")){
            if(num2==0) result =  "b cannot be zero" ;
            result = Integer.toString(num1/num2);
        }
        else {
            result = "I cannot service your request";
        }

        return result ;
    }

}
