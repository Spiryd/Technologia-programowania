package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Greetings greetings = new Greetings();
        System.out.println(greetings.sayHello(args.length>0?args[0]:null));
    }
}
