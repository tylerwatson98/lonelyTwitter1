package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class CurrentMood {
    protected String mood;
    protected Date date;

    CurrentMood(){
        this.date=new Date();
        this.mood="default mood";
    }

    CurrentMood(String mood, Date date){
        this.mood=mood;
        this.date=date;
    }

    public void setMood(String mood){
            this.mood=mood;
        }

        public void setDate(Date date){
            this.date=date;
        }

        public String getMood(){
            return this.mood;
        }

        public Date getDate(){
            return this.date;
        }

        public abstract Boolean isMood1();
    }
