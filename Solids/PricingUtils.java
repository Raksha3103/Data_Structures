import java.util.*;
public class PricingUtils {
    public static void main(String args[])
    {
        Product p1=new Product();
        Product p2=new Product();
        Product p3=new InHouseProduct();
        List<Product> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        for(Product product:list)
        {
            System.out.println(product.getDiscount());
        }
    }
}