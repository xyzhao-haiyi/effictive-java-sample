package com.sunrain.tip21;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringLengthComparator.getInstance().compare("1","12"));
        //推荐内部类写法，并且实现序列化，可以作为策略类来使用
        System.out.println(ComparatorContainer.STRING_LEN_COMPARATOR.compare
                ("1","12"));
    }
}
