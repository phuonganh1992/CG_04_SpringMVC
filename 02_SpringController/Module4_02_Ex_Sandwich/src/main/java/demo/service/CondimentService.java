package demo.service;

import demo.model.Condiment;

import java.util.List;

public interface CondimentService {
    List<Condiment> findAll();

    Condiment findOne(int id);

    Condiment save(Condiment condiment);

    List<Condiment> save(List<Condiment> condiments);

    boolean exists(int id);

    List<Condiment> findAll(List<Integer> ids);

    int count();

    void delete(int id);

    void delete(Condiment condiment);

    void delete(List<Condiment> condiments);

    void deleteAll();
}
