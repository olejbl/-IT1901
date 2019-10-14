package todo.core;

public class Todo {

    private String desc;
    private boolean done;

<<<<<<< HEAD
=======
    //konstruktør
>>>>>>> df50ddb948bebdc4303ac5b557239b3b9836bfce
    public Todo(String desc, boolean done) {
        this.desc = desc;
        this.done = done;
    }

    //Setterss
    public void setDone(boolean done) {
        this.done = done;
    }
    public void setDescription(String desc) {
        this.desc = desc;
    }

    //Getters
    public String getDescription(){
        return desc;
    }

    public boolean getDone(){
        return done;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
