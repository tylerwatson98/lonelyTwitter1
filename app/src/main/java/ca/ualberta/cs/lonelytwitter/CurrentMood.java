package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class CurrentMood {
    protected String mood;
    protected Date date;

    public CurrentMood(String mood, Date date){
        this.mood=mood;
        this.date=date;
    }

    public void setMode(String mode){
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
