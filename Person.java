public class Person {
    String name;
    String job;
    int health;
    int hunger;
  
    public Person (String n, String j) {
        name = n;
        job = j;
        if ((j.equals("farmer")) || (j.equals("hunter"))){
            health = 80;
        } else if (j.equals("doctor")) {
            health = 120;
        }
        hunger = 90;
        if ((j.equals("farmer"))){
            hunger = 110;
        }
       
       
  
    }

    public String toString(){
        return name + " " + job + " " + health + " " + hunger;
    }
    public String getName(){
        return name;
    }
   
    public int getHealth() {
        return health;
    }
    public int addHealth(int h) {
        health += h;
        return health;
    }
    public int subtractHealth (int h){
  
        health -= h;
       
        return health;
    }
    public int getHunger() {
        return hunger;
    }
    public int addHunger(int h){
        hunger += h;
        return hunger;
    }
    public int subtractHunger(int h){
        hunger-= h;
        return hunger;
    }
  
 }
 