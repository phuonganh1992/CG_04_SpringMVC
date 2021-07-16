package phuonganh.service;

import phuonganh.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements IProductService{
    private List<Product> products=new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product:products) {
            if(product.getId()==id) return product;
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p = product;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }
}
