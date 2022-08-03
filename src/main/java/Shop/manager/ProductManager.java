package Shop.manager;

import Shop.shopsProducts.Product;
import Shop.repository.ProductRepository;
import Shop.negativeExceptions.NotFoundException;
import Shop.negativeExceptions.DuplicateException;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] getProducts() {
        return repository.getProducts();
    }

    public void add(Product newProduct) {
        if (searchById(newProduct.getId()) == null) {
            repository.save(newProduct);
        }else{
            throw new DuplicateException(
                    "Element with id: " + newProduct.getId() + " has already exists!"
            );
        }
    }

    public void deleteById(int id) {
        if (searchById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found!"
            );
        }else{
            repository.deleteById(id);
        }
    }

    public Product[] searchByName(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public Product searchById(int id) {
        for (Product product: repository.getProducts()) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
