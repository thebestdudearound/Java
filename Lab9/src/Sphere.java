/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: Represents a sphere.
 * Due Date: 11/02/2015
 * Name: Henry Goldman & Sebastian Kleinerman
 * File Name: Sphere.java
 * Lab #9
 */

public class Sphere extends Shape
{
    private double radius;  //radius in feet

   //----------------------------------
   //  Constructor: Sets up the sphere.
   //----------------------------------
   public Sphere(double r)
   {  
      super("Sphere");
      radius = r;
   }

   //-----------------------------------------
   //  Returns the surface area of the sphere.
   //-----------------------------------------
   public double area()
   {
       return 4*Math.PI*radius*radius;
   }

   //-----------------------------------
   //  Returns the sphere as a String.
   //----------------------------------- 
   public String toString()
   {
       return super.toString() + " of radius " + radius;
   }

}