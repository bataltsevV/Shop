package Shop.manager;

import Shop.shopsProducts.Product;
import Shop.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagersTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Product(1, "Rick", 12);
    Product product2 = new Product(2, "Batman", 45);
    Product product3 = new Product(3, "Titans", 15);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void testGetProduct() {
        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDeleteProduct() {
        manager.deleteById(2);
        Product[] expected = {product1, product3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotIdForDeleteProduct() {
        manager.deleteById(10);
        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchBy() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Rick");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSetSearchBy() {
        Product product4 = new Product(4, "Rick and Morty", 30);
        manager.add(product4);
        Product[] expected = {product1, product4};
        Product[] actual = manager.searchBy("Rick");
        Assertions.assertArrayEquals(expected, actual);
    }
}
