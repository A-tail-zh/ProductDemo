import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        productService.addProduct(new Product("天选3","笔记本","张子贤桌上",2022));

        productService.addProduct(new Product("拯救者Y7000P", "游戏本", "李华书桌", 2023));

        productService.addProduct(new Product("MacBook Air", "轻薄本", "王伟办公室", 2024));

        productService.addProduct(new Product("暗影精灵9", "电竞本", "公司会议室", 2023));

        productService.addProduct(new Product("ThinkPad X1", "商务本", "赵明出差包", 2022));

        productService.addProduct(new Product("ROG枪神7", "高性能本", "电竞房桌面", 2024));

        productService.addProduct(new Product("Surface Pro", "二合一", "陈晨背包", 2023));

        productService.addProduct(new Product("小米Pro 15", "办公本", "前台接待处", 2022));

        productService.addProduct(new Product("戴尔XPS13", "超极本", "总经理办公室", 2024));

        productService.addProduct(new Product("华为MateBook", "全面屏", "销售部公共区", 2023));

        productService.addProduct(new Product("外星人m18", "旗舰游戏本", "VIP体验室", 2024));

        //查询所有信息
//        List<Product> allProducts = productService.getAllProducts();
//        for (Product product : allProducts) {
//            System.out.println(product);
//        }
        //流式接口
        productService.getAllProducts().forEach(System.out::println);

        System.out.println("=======================================");

        System.out.println("输入商品名称查询商品");
        productService.checkIfTheProductExists(productService.getProductByName(scanner.next()));


        System.out.println("=========================================");

        System.out.println("输入位置查询商品");
        productService.checkIfTheProductExists(productService.getProductByPlace(scanner.next()));

//        查询所有质保期过期的商品
        System.out.println("=========================================");

        System.out.println("输入质保期查询质保过期商品");
//        List<Product> allProductsWithExpiredWarranties = productService.allProductsWithExpiredWarranties(scanner.nextInt());
//        for (Product product : allProductsWithExpiredWarranties) {
//            System.out.println(product);
//        }
        Optional.ofNullable(productService.allProductsWithExpiredWarranties(scanner.nextInt()))
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        list -> list.forEach(System.out::println),
                        () -> System.out.println("未有商品")
                );




        System.out.println("模糊查询");
//        List<Product> pros = productService.getProductWithText(scanner.next());
//        for (Product product : pros) {
//            System.out.println(product);
//        }
        productService.getProductWithText(scanner.next()).forEach(System.out::println);
    }
}