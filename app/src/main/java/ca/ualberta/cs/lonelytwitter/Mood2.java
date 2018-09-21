package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Mood2 extends CurrentMood {

    public Mood2 (String mood, Date date){
        super(mood,date);
    }

    @Override
    public Boolean isMood1() {
        return false;
    }

}
