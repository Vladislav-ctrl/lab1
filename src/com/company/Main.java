package com.company;


public class Main {
    public static void main(String[] args) {
	List<Integer> a=new List<Integer>();
	a.addLast(34);
	a.addLast(32);
	a.addLast(31);
	for(int i=0;i<=a.size()-1;i++){
	    System.out.println(a.get(i));
    }
    }
}
