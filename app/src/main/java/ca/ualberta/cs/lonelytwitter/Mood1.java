package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Mood1 extends CurrentMood {


    /**
     * * Constructs Mood1 objects
     *
     * @param mood string
     * @param date date
     */
     Mood1(String mood, Date date){
        super(mood,date);
    }


    @Override
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(Date date) {
        super.setDate(date);
    }

  @Override
    public Boolean isMood1() {
        return true;
    }


}
