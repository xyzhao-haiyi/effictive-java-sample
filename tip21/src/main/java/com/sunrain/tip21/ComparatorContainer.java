package com.sunrain.tip21;

import java.io.Serializable;
/*
* 1、使用工厂类产生不同的比较器
* 2、改造匿名类创建比较器方式，减少匿名类实例化开销
* 3、实现序列化，可以作为策略类来使用
* */
public class ComparatorContainer {
    public static final Comparator<String> STRING_LEN_COMPARATOR =
            new StrLenCmp();

    private static class StrLenCmp
            implements Comparator<String>,Serializable{

        @Override
        public int compare(String t1, String t2) {
            return t1.length()-t2.length();
        }
    }


}
