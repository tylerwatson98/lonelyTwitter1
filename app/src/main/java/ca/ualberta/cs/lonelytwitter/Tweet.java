package ca.ualberta.cs.lonelytwitter;

import java.util.Collection;
import java.util.Date;

public abstract class Tweet {
    protected String message;
    protected Date date;
    private static final Integer MAX_CHARS = 140;

    Collection<CurrentMood> currentMoods;

    Tweet(){
        this.date=new Date();
        this.message="I am a default message scrawl";

    }


    Tweet(String message){
        this.date= new Date();
        this.message=message;

    }

    public void setMessage(String message) throws MaxTextLength {
        if (message.length()<=this.MAX_CHARS){
            this.message=message;
        }
        else {
            throw new MaxTextLength();
        }
    }

    public String toString(){
        return this.date.toString()+" | "+this.message;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public String getMessage(){
        return this.message;
    }

    public Date getDate(){
        return this.date;
    }

    public abstract Boolean isImportant();
}
