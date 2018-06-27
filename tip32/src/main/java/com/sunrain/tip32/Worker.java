package com.sunrain.tip32;

import java.util.EnumSet;
import java.util.Set;

class Worker {
    String name;
    Set<Day> availableDays;
    
    public Worker(String name, Set<Day> availableDays) {
        this.name = name;
        this.availableDays = availableDays;
    }
    
    public String getName() {
        return name;
    }
    
    public Set<Day> getAvailableDays() {
        return availableDays;
    }

    public static void main(String[] args) {
        Worker[] workers = new Worker[]{
                new Worker("张三", EnumSet.of(
                        Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.FRIDAY)),
                new Worker("李四", EnumSet.of(
                        Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)),
                new Worker("王五", EnumSet.of(
                        Day.TUESDAY, Day.THURSDAY)),
        };
        //哪些天一个人都不会来？
        Set<Day> days1 = EnumSet.allOf(Day.class);
        for(Worker w : workers){
            days1.removeAll(w.getAvailableDays());
        }
        System.out.println("哪些天一个人都不会来？"+days1);

        //有哪些天至少会有一个人来？
        Set<Day> days2 = EnumSet.noneOf(Day.class);
        for(Worker w : workers){
            days2.addAll(w.getAvailableDays());
        }
        System.out.println("有哪些天至少会有一个人来？"+days2);

        //有哪些天所有人都会来？
        Set<Day> days3 = EnumSet.allOf(Day.class);
        for(Worker w : workers){
            days3.retainAll(w.getAvailableDays());
        }
        System.out.println("有哪些天所有人都会来？"+days3);
    }
}