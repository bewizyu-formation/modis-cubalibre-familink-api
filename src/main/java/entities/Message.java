package entities;

import java.util.Date;

public class Message {

    private int id;
    private  Contact sender;
    private Contact receiver;
    private Date createDate;
    private boolean isRead;
    private Group group;

    /**
     * Constructor vide
     */
    public Message() {
    }

    /**
     * Constructor
     * @param id
     * @param sender
     * @param receiver
     * @param createDate
     * @param isRead
     * @param group
     */
    public Message(int id, Contact sender, Contact receiver, Date createDate, boolean isRead, Group group) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.createDate = createDate;
        this.isRead = isRead;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public Contact getSender() {
        return sender;
    }

    public Contact getReceiver() {
        return receiver;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setAsRead() {
       if (!isRead){
           this.isRead = true;
       }
    }

    public Group getGroup() {
        return group;
    }


}
