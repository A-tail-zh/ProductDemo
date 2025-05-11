import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products = new ArrayList<Product>();
    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByName(String productName) {
       return products.stream().filter(product -> product.getName().equals(productName)).findFirst().orElse(null);
    }

    public void checkIfTheProductExists(Product product) {
        if (product != null) {
            System.out.println("商品如下：");
            System.out.println(product);
        }else {
            System.out.println("商品不存在");
        }
    }

    public Product getProductByPlace(String productPlace) {
        return products.stream().filter(product -> product.getPlace().equals(productPlace)).findFirst().orElse(null);
    }

    public List<Product> allProductsWithExpiredWarranties(int warrantyDate) {
        return products.stream().filter(product -> product.getWarranty() < warrantyDate).collect(Collectors.toList());
    }

    public List<Product> getProductWithText(String productText) {
        String text = productText.toLowerCase();
       return products.stream().filter(product ->
               product.getName().toLowerCase().contains(text)||
               product.getType().toLowerCase().contains(text)||
               product.getPlace().toLowerCase().contains(text)).collect(Collectors.toList());
    }
}
