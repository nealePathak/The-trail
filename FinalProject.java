import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinalProject {
    // Make objects
    // intialize
    // static user propmpts
    static int miles = 0;
    static int playersAlive = 3;
    static int daysTravelled = 0;
    static String name = "";
    static String job = "";
    static int money = 400;
    static int quitSelect = 0;
    static String ration = "";
    static String pace = "";
    static String rations = "";
    static int choice;
    static int horses = 0;
    static int ammo = 0;
    static int days = 0;
    static int food = 30;

    static ArrayList<Person> personList = new ArrayList<Person>();

    static Scanner scan = new Scanner(System.in);
    static Scanner txtScan;

    public static void main(String Args[]) {

        //Trys code in first brackets if gets an in/out exception it does code in second brackets - doesnt matter
        try {
            txtScan = new Scanner(new File("FileA.txt"));  
        } catch (IOException ex) {
        }
        System.out.println("Most updated Code");
        System.out.println("");
        System.out.println(txtScan.nextLine());
        System.out.println("");
        //System.out.println("")
        System.out.println(txtScan.nextLine());
        System.out.println(txtScan.nextLine());
        System.out.println(txtScan.nextLine());
        System.out.println(txtScan.nextLine());

        //for loop to add person objects to an array list
        for (int i = 0; i < 3; i++) {
            System.out.println("What will you like the name of the person to be?");
            name = scan.nextLine();
            System.out.println("What job will they have? - Enter doctor, hunter, farmer");
            job = scan.nextLine();
            while (!job.equals("farmer") && !job.equals("hunter")&& !job.equals("doctor")){
                System.out.println("Please enter a valid job - hunter, doctor, or farmer");
                job = scan.nextLine();
            }
            Person p = new Person(name, job);
            personList.add(p);
        }
        Party party = new Party(personList);


        //First time shop and pace
        for (int i = 0; i<1; i++){

            //Store
        System.out.println(txtScan.nextLine());
        System.out.println(txtScan.nextLine());
        System.out.println(txtScan.nextLine());
        System.out.println("Store");
        System.out.println("...................");

        for (i = 0; i<20; i++) {
            System.out.println( "No Refunds! Buy wisely, you will not be able to revisit this shop!");
            System.out.println("\nHorses: 100$ (Select 1 to buy)");
        
        System.out.println("Ammunition: 20$ (Select 2 to buy)");
        int select = scan.nextInt();
         
        if ((select==1) && (money>=100)) {
                money = money - 100;
                System.out.println("Thanks for visiting the store! Press 1 to exit and 2 to continue shopping!");
                System.out.println("“Current Balance:" +money);
                horses ++;
                 quitSelect = scan.nextInt();
            } else if ((select==2) && (money>20)) {
                money = money - 20;
                System.out.println("Thanks for visiting the store! Press 1 to exit and 2 to continue shopping!");
                System.out.println("“Current Balance:"+money);
                ammo ++;
                 quitSelect = scan.nextInt();
            } else if (select == 1) {
                System.out.println("You do not have enough money to buy this product!");
                System.out.println("Thanks for visiting the store! Press 1 to exit and 2 to continue shopping!");
                System.out.println("“Current Balance: "+ money);
                 quitSelect = scan.nextInt();
            } else if (select == 2) {
                System.out.println("You don't have enough money to buy this product!");
                System.out.println("Thanks for visiting the store! Press 1 to exit and 2 to continue shopping!");
                System.out.println("Current Balance: "+money);
                 quitSelect = scan.nextInt();
            } else {
                System.out.println("Sorry, what you have entered cannot be recognized by the store! Please enter 1 to exit and 2 to continue shopping!");
                 quitSelect = scan.nextInt();
            }

            if (quitSelect == 1) {
                System.out.println("You have exited the store. Please visit again!");
                            
                System.out.println("");
                System.out.println("");
                System.out.println("Now you will choose the pace for the journey, you can choose between: fast, average, and slow.");
                System.out.println("Be careful, the faster the pace- the more hunger you lose.");
                pace = scan.next();
                Party.partyPace(pace);
                System.out.println("Now you will choose the rations given. You can choose between plenty, meager, and average.");
                rations = scan.next();
                Party.partyRation(rations);
                System.out.println("");
                System.out.println("The more rations you give, the more health will be restored to each player.");
                System.out.println("You will start the game with 30 pounds of food. Per each day you will go through 8 pounds of food per character alive.");
                break;
            }

    
        }
        //personList.get(0).subtractHealth(99);
        //personList.get(1).subtractHealth(99);
        //System.out.println(miles);
        //System.out.println(personList);
        //System.out.println(daysTravelled);
        //personList.get(2).addHealth(1000);
        while (miles < 145 && personList.size() > 0 && daysTravelled < 14){
            miles = miles + 3;

            if(personList.size() == 0){
                break;
            }
            if (food <= 0){
                food = 0;
                for (i = 0; i < personList.size();i++){
                    personList.get(i).subtractHealth(20);
                }
            }
            if(horses > 2){
                horses = 2;
            }
            System.out.println("____________________________________________");
            if (pace.equals("fast")){
                miles = miles + (horses * 6) + 5 ;
            }
            else if (pace.equals("slow")){
                miles = miles + (horses * 3) + 3;
            }
            else if (pace.equals("average")){
                miles = miles + (horses * 4) + 4;
            }
            
            
            if (food > 0){
                food = food - (8 * personList.size());
            }

            if(food <= 0){
                for(i = 0; i < personList.size(); i++){
                    personList.get(i).subtractHealth(20);
                }
            }
            daysTravelled ++;


//Change here
            for (i = 0; i < personList.size(); i++){
                if (personList.get(i).getHunger() <= 0){
                    personList.get(i).subtractHealth(55);
                }
                else if (personList.get(i).getHunger() <= 50){
                    personList.get(i).subtractHealth(15);
                }
            }

            
            for (i = 0; i < personList.size(); i++){
                if(personList.get(i).getHealth() <= 0){
                    if(personList.size() == 0){
                        System.out.println("You lose!");
                        break;
                    }
                    else{
                        System.out.println(personList.get(i).getName() + " has died!");
                        personList.remove(i);
                        if(personList.size() == 0){
                            System.out.println("You lose!");
                            break;
                        }
                        else{
                            System.out.println("There are " + personList.size() + " people alive");
                    }
                }
            }
        }


            


        if(personList.size() == 0){
            break;
        }
            //System.out.println("TEST");
            System.out.println(txtScan.nextLine());
            System.out.println(txtScan.nextLine());
            System.out.println(txtScan.nextLine());
            
            System.out.println("Days Travelled: " + daysTravelled);
            System.out.println("Miles Covered: " + miles);
            System.out.println("Current Pace: " + pace);
            System.out.println("Current Rations: " + rations);
            
            System.out.println("You May:");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Continue on the trail");
            System.out.println("2. Check Supplies");
            System.out.println("3. Change Pace");
            System.out.println("4. Change Rations");
            System.out.println("5. Stop to rest");
            System.out.println("6. View the health of everyone");
            System.out.println("7. Hunt");
            choice = scan.nextInt();
            
            while (choice != 1){

                if (choice == 2){  
                    System.out.println("");
                    System.out.println("Ammo: " + ammo);
                    System.out.println("Horses: " + horses);
                    System.out.println("Food: " + food);
                }
                else if (choice == 3){
                    System.out.println("What would you like the pace to be? (fast, average, or slow)");
                    pace = scan.next();
                    Party.partyPace(pace);
                }
                else if (choice == 4){
                    System.out.println("What would you like to set the rations to? (meager, plenty, or average)");
                    rations = scan.next();
                    Party.partyRation(ration);
                }
                else if (choice == 5){
                    System.out.println("How many days would you like to stop for?");
                    days = scan.nextInt();
                    for (i = 0; i<personList.size(); i++){
                        personList.get(i).addHealth(4 * days);
                    }

                    daysTravelled = daysTravelled + days;

                }
                else if (choice == 6){
                    if(personList.size() == 0){
                        break;
                    }
                    System.out.println("");
                    System.out.println("The average health system is ranked from good to ok to poor ");
                    System.out.println("Good falls from an average health above 90, Ok is from 40 to 90, and poor is from 0 to 40");
                    System.out.println("");
                    System.out.println("The average group health: " + party.partyHealth());
                    System.out.println("The average group hunger: " + party.partyHunger());
                    for (i = 0; i < personList.size(); i++){
                        System.out.println(personList.get(i).getName() + ": Health is " + personList.get(i).getHealth());
                        System.out.println("");
                        System.out.println(personList.get(i).getName() + ": Hunger is " + personList.get(i).getHunger());
                        System.out.println("");
                    }

                }
                else if (choice == 7){
                    Hunter hunter = new Hunter(food,ammo);
                    System.out.println("Current Ammunition: " + ammo);
                    System.out.println("Current Food: " + food);
                    System.out.println("");
                
                    food = food + Hunter.Hunt();

                    

                }
                else{
                    System.out.println("Please enter a valid number.");
                }    

                System.out.println("");
                System.out.println("");
                System.out.println("You May:");
                System.out.println("1. Continue on the trail");
                System.out.println("2. Check Supplies");
                System.out.println("3. Change Pace");
                System.out.println("4. Change Rations");
                System.out.println("5. Stop to rest");
                System.out.println("6. View the health of everyone");
                System.out.println("7. Hunt");
                choice = scan.nextInt();
                
            }



        }
        if(personList.size() == 0){
            System.out.println("The president sends his regards to the familes. Play again for a better ending");
            System.out.println("Thank you for playing.");
        }
        else{
            System.out.println("You won with " + personList.size() + " player alive!");
            System.out.println("President Wilson thanks you for your effort.");
            if (personList.size()<3){
                System.out.println("Regards are sent to the familes of the deceased, you tried your best.");
            }
            System.out.println("Thank you for playing!");
        }




        

        



    }

}
}

