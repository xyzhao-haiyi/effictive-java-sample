package com.sunrain.tip35;

public class Sample2 {
    @ExceptionTest(value = ArithmeticException.class)
    public static void m1(){ //Test should pass
        int i =0;
        i = i/i;
    }
    @ExceptionTest(value = ArithmeticException.class)
    public static  void  m2(){  //fail(wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }
    @ExceptionTest(value = ArithmeticException.class)
    public static void m3(){}   //fail
}
