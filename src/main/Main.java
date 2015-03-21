package main;

public class Main {

    public static void main(String[] args) {
        Concatenator concatenator = new Concatenator();
        String output = concatenator.concatenate("Hello ", "world!");
        System.out.println(output);
    }
}
