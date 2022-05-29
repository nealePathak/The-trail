import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
 
public class Hunter{
   
   private static  int food;
   private static  int bullets;
   private static  Scanner scan = new Scanner(System.in);
    public Hunter(int f, int b){
    food = f;
    bullets = b;
    }
 
 
 
public static int Hunt(){

    for(int i = 0; i<=5;i++){
        if(bullets == 0){
            System.out.println("Sorry! You have no ammunition");
            break;
        }
        System.out.println("Do you want to shoot?");
    String shoot = scan.nextLine();
 
 
    ArrayList<String> qs = new ArrayList<String>();
    qs.add("What year was the Declaration of Independence signed?");
    qs.add("The United States bought Alaska from which country");
    qs.add("Who was the Fourth President of the United States");
    qs.add("Who was the First woman to make a Million dollars in America?");
    ArrayList<String> ans = new ArrayList<String>();
    ans.add("1776");
    ans.add("Russia");
    ans.add("James Madison");
    ans.add("Madam C.J. Walker");
   
    if(shoot.contains("yes")){
        System.out.println(qs.get(i));
        shoot = scan.nextLine();
        bullets -= 1;
        if (shoot.equals(ans.get(i)))
        {
            food += 10;
        }
        System.out.println("Correct!");
        System.out.println("New food Amount: " + food);
 
    }
 
    else if(shoot.contains("no")){
        System.out.println("New Food Amount: " + food);
        break;
    }
 
}
    return food;
    
}

}




