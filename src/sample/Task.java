package sample;

public class Task {
    private long DateCreated;
    private String description;
    private String task;

    public Task() {
    }

    public Task(long dateCreated, String description, String task) {
        DateCreated = dateCreated;
        this.description = description;
        this.task = task;
    }

    public long getDateCreated() {
        return DateCreated;
    }

    public String getDescription() {
        return description;
    }

    public String getTask() {
        return task;
    }

    public void setDateCreated(long dateCreated) {
        DateCreated = dateCreated;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
