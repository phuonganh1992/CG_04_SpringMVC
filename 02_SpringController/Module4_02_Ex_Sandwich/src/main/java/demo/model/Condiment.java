package model;

public class Condiment implements Cloneable {
    private int id;
    private String name;

    public Condiment() {
    }

    public Condiment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Condiment clone(){
        Condiment condiment=new Condiment();
        condiment.setId(id);
        condiment.setName(name);
        return condiment;
    }

}

