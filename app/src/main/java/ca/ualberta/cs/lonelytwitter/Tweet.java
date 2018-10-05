
// Represents a Tweet



/*
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this
 * code under terms and conditions of the Code of Students Behavior at University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Collection;
import java.util.Date;


public abstract class Tweet {
    protected String message;
    protected Date date;

    /**
     * * Constructs Tweet objects
     *
     * @param message tweet message
     * @param date tweet date
     */

    private static final Integer MAX_CHARS = 140;

    Collection<CurrentMood> currentMoods;



    Tweet() {
        this.date = new Date();
        this.message = "I am a default message scrawl";

    }


    Tweet(String message) {
        this.date = new Date();
        this.message = message;

    }

    public void setMessage(String message) throws MaxTextLength {
        if (message.length() <= this.MAX_CHARS) {
            this.message = message;
        } else {
            throw new MaxTextLength();
        }
    }

    public String toString() {
        return this.date.toString() + " | " + this.message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getDate() {
        return this.date;
    }

    public abstract Boolean isImportant();
}
