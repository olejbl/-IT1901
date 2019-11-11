package todo.core;


public class Todo {

    private String desc;
    private double id;

    public Todo() {
        // Default Konstruktør for deserializing (IKKE SLETT)
    }

    public Todo(String desc, double id) {
        this.desc = desc;
        this.id = id;
    }

    //Setterss
    public void setId(double id) {
        this.id = id;
    }
    public void setContent(String desc) {
        this.desc = desc;
    }

    //Getters
    public String getContent(){
        return desc;
    }

    public double getId(){
        return id;
    }

    @Override
    public String toString() {
        return getContent();
    }
}
