package com.kreker.duedate;

import java.util.Date;

/**
 * Created by kreker on 30.08.15.
 */
public class DueDate {
    private String name;
    private Date date;
    private Date created;

    public DueDate(String name, Date date) {
        super();
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}