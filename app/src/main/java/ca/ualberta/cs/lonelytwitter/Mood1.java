package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Mood1 extends CurrentMood {

    public Mood1(String mood, Date date){
        super(mood,date);
    }

  @Override
    public Boolean isMood1() {
        return true;
    }


}
