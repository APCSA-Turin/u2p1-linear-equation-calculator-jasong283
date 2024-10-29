package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private double slope;
    private double yInt;
    private double distance;
    private String equation; 

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(10,5)" and "(3,-4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String c1, String c2) { // <--add 2 string parameters to this constructor

        String a1 = c1.substring(c1.length() - (c1.length() - 1), 2);
        String aa = c1.substring(c1.length() - (c1.length() - 1), 3);
        

        if(a1.contains("-")) {
            a1 = c1.substring(c1.length() - (c1.length() - 1), 3);
        }
        if(aa.contains("0") && c1.length() == 6) {
            a1 = c1.substring(c1.length() - (c1.length() - 1), 3);
        }
        x1 = Integer.parseInt(a1);


        String a2 = "";
        if(c1.length() == 7) {
            a2 = c1.substring(4, 6);
        }
        if(c1.length() == 6 && c1.indexOf("-") == 1) {
            a2 = c1.substring(4, 5);
        }
        if(c1.length() == 6 && c1.indexOf("-") == 3) {
            a2 = c1.substring(3, 5);
        }
        if(c1.length() == 5) {
            a2 = c1.substring(3, 4);
        }
        if(c1.length() == 6 && c1.indexOf(",") == 2 && c1.indexOf("-") != 3) {
            a2 = c1.substring(3, 5);
        }
        if(c1.length() == 6 && c1.indexOf(",") == 3 && c1.indexOf("-") != 1) {
            a2 = c1.substring(4, 5);
        }
        y1 = Integer.parseInt(a2);


        String a3 = c2.substring(c1.length() - (c1.length() - 1), 2);
        if(a3.contains("-")) {
            a3 = c2.substring(c1.length() - (c1.length() - 1), 3);
        }
        x2 = Integer.parseInt(a3);


        String a4 = "";
        if(c2.length() == 7) {
            a4 = c2.substring(4, 6);
        }
        if(c2.length() == 6 && c2.indexOf("-") == 1) {
            a4 = c2.substring(4, 5);
        }
        if(c2.length() == 6 && c2.indexOf("-") == 3) {
            a4 = c2.substring(3, 5);
        }
        if(c2.length() == 6 && c2.indexOf(",") == 2 && c2.indexOf("-") != 3) {
            a4 = c2.substring(3, 5);
        }
        if(c2.length() == 6 && c2.indexOf(",") == 3 && c2.indexOf("-") != 1) {
            a4 = c2.substring(4, 5);
        }
        if(c2.length() == 5) {
            a4 = c2.substring(3, 4);
        }
        y2 = Integer.parseInt(a4);
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    public void setX1(int newX1) {
        x1 = newX1;
    }
    public void setY1(int newY1) {
        y1 = newY1;
    }
    public void setX2(int newX2) {
        x2 = newX2;
    }
    public void setY2(int newY2) {
        y2 = newY2;
    }
    
    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance() {
        distance = Math.round(((Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2))) * 100));
        distance = distance / 100;
        return distance;
    }

    //((slope * (0 - x1)) + y1) == 0)

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope() {
        if(x2 - x1 == 0) {
            slope = -999.99;
        } else {
            slope = Math.round(((double) (y2 - y1) / (x2 - x1) * 100));
            slope = slope / 100;
        }
        return slope;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation() {

        if(slope() == -999.99) {
            equation = "undefined";
        } else if(slope == 0.0) {
            equation = "y=" + yInt();
        } else if(yInt() == 0 || yInt() == -999.99) {
            equation = "y=" + slope() + "x";
        } else {      
            equation = "y=" + slope() + "x+" + yInt();
        }
        String str = yInt() + "";
        if(str.contains("-") && yInt() != -999.99) {
            equation = "y=" + slope() + "x" + yInt();
        }
        return equation;
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int is undefined, should return -999.99
    public double yInt() {
        if((x1 - x2) == 0) {
            yInt = -999.99;
        } else {
            yInt = Math.round(((slope() * (-x1)) + y1) * 100);
            yInt = yInt / 100;
        }
        return yInt;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x) {
        return 0.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo() {
        String str = "The two points are: (" + getX1() + "," + getY1()  + ")";
        str += " and " + "(" + getX2() + "," + getY2() + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        return str;
    }
}