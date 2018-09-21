package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

public class DomesticDuck extends Animal implements FlyingBehaviour{

    public DomesticDuck(String type, String food){
        super(type,food);
    }

    public void swim() {
        Log.d("tyler","I love swimming");

    }

    public void doesLikeFlying(){
        Log.d("tyler","can fly");
    }
}
