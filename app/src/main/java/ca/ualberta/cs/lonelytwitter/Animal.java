package ca.ualberta.cs.lonelytwitter;

public abstract class Animal {
   protected String type;
   protected String food;

   public Animal(String type, String food){
       this.type=type;
       this.food=food;
   }

    public void setType(String type){
        this.type=type;
    }

    // a setter method
    public void setFood(String food){
        this.food=food;
    }
    // a getter method
    public String getType(){
        return this.type;
    }

    public String getFood(){
        return this.food;
    }

    // if your method is not defined in the parent class and you have to define it then we set it as abstract.
    // if a class has a single abstract method you must make it into an abstract class
    // you can never create an instance of an abstract class
    public abstract void swim();
    }
