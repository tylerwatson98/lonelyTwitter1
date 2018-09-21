package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet {
    protected String message;
    protected Date date;

    public void setMessage(String message) throws MaxTextLength {
        if (this.message.length()>140){
            throw new MaxTextLength();
        }
        this.message=message;
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
