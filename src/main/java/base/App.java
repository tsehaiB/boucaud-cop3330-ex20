/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Tsehai Boucaud
 */
package base;
import java.util.Scanner;
public class App {
    final static double taxIll = .08;
    final static double taxWisc = .05;
    final static double taxEauC = .005;
    final static double taxDunn = .004;
    Scanner inp = new Scanner(System.in);
    public static void main(String[] args){
        App myApp = new App();
        int amount = myApp.readAmount();
        String state = myApp.readState();
        double total = amount;
        double tax = 0.0;
        if(state.equalsIgnoreCase("Wisconsin")){
            tax = myApp.calcTax(amount,taxWisc);
            String county = myApp.readCounty();
            if(county.equalsIgnoreCase("Dunn"))
                tax += myApp.calcTax(amount, taxDunn);
            if(county.equalsIgnoreCase("Eau Claire"))
                tax += myApp.calcTax(amount, taxEauC);
            System.out.println("The tax is $" + tax + ".");
        }
        if(state.equalsIgnoreCase("Illinois")){
            tax = myApp.calcTax(amount, taxIll);
            System.out.println("The tax is $" + tax + ".");
        }
        total = myApp.calcTotal(amount, tax);
        System.out.println("The total is $" + total + ".");
    }
    private int readAmount(){
        System.out.print("What is the order amount? ");
        return Integer.parseInt(inp.nextLine());
    }
    private String readState(){
        System.out.print("What state do you live in? ");
        return inp.nextLine();
    }
    private String readCounty(){
        System.out.print("What county do you live in? ");
        return inp.nextLine();
    }
    private double calcTax(int amount, double rate){
        return amount * rate;
    }
    private double calcTotal(int amount, double tax){
        return amount + tax;
    }

}
