package task;

public class Task {

    private final String taskId;
    private String name;
    private String description;

    public Task (String taskId, String name, String description){
        if (taskId == null || taskId.length() > 10){
            throw new IllegalArgumentException ("Task ID cannot be null or longer than 10 characters.");
        }
        if (name == null ||name.length() > 20){
            throw new IllegalArgumentException ("Name cannot be null or longer than 20 characters.");
        }
        if ( description == null ||description.length() > 50){
            throw new IllegalArgumentException("Description cannot be null or longer than 50 characters.");
        }
        this.description = description;
        this.name = name;
        this.taskId = taskId;
    }

    public  String getTaskId(){
        return this.taskId;
    }

    public void setName (String name){
        if (name == null || name.length() > 20){
            throw new IllegalArgumentException ("Name cannot be null or longer than 20 characters.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription (String description){
        if (description == null || description.length() > 50){
            throw new IllegalArgumentException ("Description cannot be null or longer than 50 characters.");
        }
        this.description = description;
    }

    public  String getDescription(){
        return this.description;
    }



}