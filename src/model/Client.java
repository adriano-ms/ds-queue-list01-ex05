package model;

public class Client {

    private Integer id;
    private String name;

    public Client() {
        super();
    }

    public Client(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + ", Name: " + getName() + "]";
    }
}
