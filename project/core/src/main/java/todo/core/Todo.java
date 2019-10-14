package todo.core;

public class Todo {

    private String desc;
    private boolean done;

    /*@JsonCreator
    public Todo(@JsonProperty("description") String desc, @JsonProperty("done") boolean done) {
        this.desc = desc;
        this.done = done;
    }*/
    public Todo(String desc, boolean done) {
        this.desc = desc;
        this.done = done;
    }

    //Setterss
    private void setDone(boolean done) {
        this.done = done;
    }
    private void setDescription(String desc) {
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
