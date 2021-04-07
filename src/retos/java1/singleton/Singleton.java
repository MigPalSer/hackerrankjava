package retos.java1.singleton;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

/* https://www.hackerrank.com/challenges/java-singleton/problem
 * TASK: Design a plane "singleton" and let the hackerrank compiler do all
 * */

class Singleton{

    public static String str="";
    
    private Singleton(){
    }
    
    public static Singleton getSingleInstance(){
        return new Singleton();
    }
    
}