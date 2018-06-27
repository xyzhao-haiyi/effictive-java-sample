package com.sunrain.tip41;

import java.util.*;
/*
*这个类做法是错误的，期望顺次打印Set，List，Unknown Collection；但是会打印三次Unknown Collection
* 原因：重载（overload）：参数是编译时决定的。编译时，参数类型都是Collection
*/
public class CollectionClassifier {
    public static String classify(Set<?> s){
        return "Set";
    }
    public static String classify(List<?> list){
        return "List";
    }
    public static String classify(Collection<?> c){
        return "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<String>[]  collections = new Collection[]{
                new TreeSet(),
                new ArrayList(),
                new HashMap<String,String>()
                .values()
        };
        for (Collection c : collections){
            System.out.println(classify(c));
        }
    }
}
