package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.add("4");
        System.out.println(list.size());
        list.remove(3);
        System.out.println(list.size());

        System.out.println("__________________________________");

        List<String> list1 = new LinkedList<>();
        list1.add("first");
        list1.add("second");
        list1.add("third");
        list1.add("fourth");
        list1.add("fifth");
        System.out.println(list1.size());
        System.out.println(list1.get(3));
        list1.remove(3);
        System.out.println(list1.get(3) + " " + list1.size());


    }
}
