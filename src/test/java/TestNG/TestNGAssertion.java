package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    public int multiplication (int number1, int number2){
        return number1 * number2;
    }
    @Test
    public void validateMultiplication(){
int actualResult = multiplication(3,4);
int expectedResult = 12;


   /*
     if (actualResult==expectedResult){
    System.out.println("PASSED");
    }else{
    }
    */
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test
   public void validateZero(){
 int actual = multiplication(0,9999);
 int expceted=0;
 Assert.assertTrue(actual==expceted);
    }



    @Test
    public void validateNegativeWithPositive(){
int actual = multiplication(-1,9);
int expected = -9;
Assert.assertFalse(actual!=expected);
    }
    @Test
    public void validateNegativeWithNegative(){
        //int actual = multiplication(-1,-5);
        //int expected =5;
        Assert.assertEquals(multiplication(-1,-5),5);

    }
}
