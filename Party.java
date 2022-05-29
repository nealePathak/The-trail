import java.util.*;

public class Party {

    static ArrayList <Person> pList;
    public Party( ArrayList <Person> personList){
        pList = personList;
  
    }

    //Get health method---is this ok to use perosn method?
    public String partyHealth(){
        int avg = 0;

        for(int i = 0; i < pList.size(); i++){
            avg = avg + pList.get(i).getHealth();
        }

       avg = avg/pList.size();

       if (avg >= 90){
           return ("Good");
       }
       
       else if (avg >= 40){
           return ("Ok");
       }

       else{
           return ("Poor");
       }
    }

    public  String partyHunger(){
        int avg = 0;

        for(int i = 0; i < pList.size();i++){
            avg = avg + pList.get(i).getHunger();
        }

        avg = avg/pList.size();

        if (avg >= 90){
            return ("Good");
        }
        
        else if (avg >= 40){
            return ("Ok");
        }
 
        else{
            return ("Poor");
        }
    }

    public static void partyPace(String p){
        for(int i = 0; i < pList.size();i++){

            if (p.equals("fast")){
                pList.get(i).subtractHealth(35); 
            }
            if (p.equals("average")){
                pList.get(i).subtractHealth(25);
            }
            if (p.equals("slow")){
                pList.get(i).subtractHealth(20);
            }

        }
    }

    public static void partyRation(String r){
        for(int i = 0; i < pList.size();i++){

            if (r == "plenty"){
                pList.get(i).addHealth(30);
            }
            if (r == "average"){
                pList.get(i).addHealth(10);
            }
            if (r == "meager"){
                pList.get(i).addHealth(5);
            }
        }
    }





}