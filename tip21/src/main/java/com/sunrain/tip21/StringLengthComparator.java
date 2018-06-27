package com.sunrain.tip21;
/*
* 1、策略模式的应用，传递函数对象作为策略
* 2、类为无状态，单例模式创建，减少实例化开销
* 3、抽象Comparator接口，使用泛型，是比较器较为公用，更易于扩展
* */
public class StringLengthComparator  implements  Comparator<String>{
    private StringLengthComparator(){ }//因该类为无状态，单例模式创建
    private static final StringLengthComparator INSTANCE =
            new StringLengthComparator();

    @Override
    public int compare(String str1 ,String str2){
        return str1.length() - str2.length();
    }

    public static StringLengthComparator getInstance(){
        return INSTANCE;
    }
}
