package sample;

import java.sql.Time;
import java.sql.Timestamp;

public class Task {
    private int UserID;
    private int TaskID;
    private Timestamp DateCreated;
    private String description;
    private String task;

    public Task() {
    }

    public Task(Timestamp dateCreated, String description, String task) {
        DateCreated = dateCreated;
        this.description = description;
        this.task = task;
    }

    public Timestamp getDateCreated() {
        return DateCreated;
    }

    public String getDescription() {
        return description;
    }

    public String getTask() {
        return task;
    }

    public void setDateCreated(Timestamp dateCreated) {
        DateCreated = dateCreated;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getUserID() {
        return UserID;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
    }

}
