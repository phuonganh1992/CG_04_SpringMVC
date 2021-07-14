package demo.service;

import demo.model.Condiment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CondimentServiceImp implements CondimentService{
    private static List<Condiment> condiments;
    private static int autoIncrement=0;
    static {
        condiments=new ArrayList<>();
        condiments.add(new Condiment(autoIncrement++,"Lettuce"));
        condiments.add(new Condiment(autoIncrement++,"Tomato"));
        condiments.add(new Condiment(autoIncrement++,"Mustard"));
        condiments.add(new Condiment(autoIncrement++,"Sprouts"));
    }

    @Override
    public List<Condiment> findAll() {
        return this.condiments ;
    }

    @Override
    public Condiment findOne(int id) {
        return this.condiments.stream()
                .filter(condiment -> (condiment.getId()==id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Condiment save(Condiment condiment) {
        Condiment current=findOne(condiment.getId());
        current.setName(condiment.getName());
        return current;
    }

    @Override
    public List<Condiment> save(List<Condiment> condiments) {
        return condiments.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(int id) {
        return this.condiments.stream().anyMatch(condiment -> condiment.getId()==id);
    }

    @Override
    public List<Condiment> findAll(List<Integer> ids) {
        return ids.stream().map(this::findOne).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return this.condiments.size();
    }

    @Override
    public void delete(int id) {
        this.condiments.removeIf(condiment -> condiment.getId()==id);
    }

    @Override
    public void delete(Condiment condiment) {
        delete(condiment.getId());
    }

    @Override
    public void delete(List<Condiment> condiments) {
        condiments.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        this.condiments.forEach(this::delete);
    }

    private Condiment persist(Condiment condiment){
        Condiment clone=condiment.clone();
        clone.setId(autoIncrement++);
        condiments.add(clone);
        return clone;
    }
}
