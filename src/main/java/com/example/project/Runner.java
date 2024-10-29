package com.example.project;
public class Runner{
    public static void main(String[] args) {
        LinearCalculator c2 = new LinearCalculator("(10,5)","(6,-1)");
        System.out.println(c2.printInfo());
        System.out.println();
        LinearCalculator c3 = new LinearCalculator("(0,0)","(0,4)");
        System.out.println(c3.printInfo());
        System.out.println();
        LinearCalculator c33 = new LinearCalculator("(-3,-1)","(4,-3)");
        System.out.println(c33.printInfo());
        System.out.println();
        LinearCalculator c4 = new LinearCalculator("(1,2)","(3,4)");
        System.out.println(c4.printInfo());
        System.out.println();
        LinearCalculator c5 = new LinearCalculator("(-1,-2)","(5,10)");
        System.out.println(c5.printInfo());

        System.out.println(c2.slope());
        System.out.println(c2.equation());
        System.out.println(c33.yInt());
     
    }
}