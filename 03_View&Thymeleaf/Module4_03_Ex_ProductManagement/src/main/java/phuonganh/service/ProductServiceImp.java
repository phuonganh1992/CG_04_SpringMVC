package phuonganh.service;

import phuonganh.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements IProductService{
    private static Map<Integer,Product> productMap;

    static {
        productMap=new HashMap<>();
        productMap.put(1,new Product(1,"iPhone 11",799,12,"Purple, Yellow, Green","Description 1","iPhone"));
        productMap.put(2,new Product(2,"iPhone 11 Pro",1100,12,"Green, Black, White","Description 2","iPhone"));
        productMap.put(3,new Product(3,"iPhone X",749,13,"Coral","Description 3","iPhone"));
        productMap.put(4,new Product(4,"Smart TV màn hình 4K UHD 49 inch RU7300",1000000,13,"Black","Description 4","smart TV"));
        productMap.put(5,new Product(5,"Samsung Galary S10E",420,10,"Blue, Black","Description 5","Samsung Phone"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
