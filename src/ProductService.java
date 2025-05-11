import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<Product>();
    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
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
        for (Product product : products) {
            if (product.getPlace().equals(productPlace)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> allProductsWithExpiredWarranties(int warrantyDate) {
        for (Product product : products) {
            if(product.getWarranty() < warrantyDate) {
                return products;
            }
        }
        return null;
    }

    public List<Product> getProductWithText(String productText) {
        String text = productText.toLowerCase();
        List<Product> pros = new ArrayList<>();
        for (Product product : products) {
            String productName = product.getName().toLowerCase();
            String productPlace = product.getPlace().toLowerCase();
            String productType = product.getType().toLowerCase();

            if (productName.contains(text)|| productType.contains(text) ||productPlace.contains(text)){
                pros.add(product);
            }
        }return pros;
    }
}
