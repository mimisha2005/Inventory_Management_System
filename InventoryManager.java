import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager()
    {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product)
    {
        if(inventory.containsKey(product.getID()))
        {
            throw new IllegalArgumentException("Product Id already exists.");
        }
        inventory.put(product.getID(), product);

        System.out.println("Product added successfully.");
    }

    public void removeProduct(String productID)
    {
      if(!inventory.containsKey(productID))
      {
        throw new IllegalArgumentException("Product not found.");
      }
      inventory.remove(productID);

      System.out.println("Product removed successfully.");
    }

    public Product searchProduct(String productID)
    {
        return inventory.get(productID);
    }
 
    public void updateStock(String productID, int amount)
    {
        Product product = inventory.get(productID);

        if(product == null)
        {
            throw new IllegalArgumentException("Product not found!");
        }
        product.addStock(amount);

        System.out.println("Stock updated successfully!");
    }

    public void sellProduct(String productID, int amount)
    {
        Product product = inventory.get(productID);
        
        if(product == null)
        {
            throw new IllegalArgumentException("Product not found!");
        }
        product.removeStock(amount);

        System.out.println("Sale successfull!");
    }

    public void displayAllProducts()
    {
        if(inventory.isEmpty())
        {
            System.out.println("Inventory is Empty.");
            return;
        }

        for(Product product: inventory.values())
        {
            product.displayDetails();
            System.out.println("--------------------------------");
        }
    }

    public List<Product> getProductsAsList() 
    {
        return new ArrayList<>(inventory.values());
    }
    
    public void displayLowStockProducts(int threshold)
    {
        List<Product> lowStockProducts = new ArrayList<>();
        
        for(Product product: inventory.values())
            {
                if(product.getQuantity() <= threshold)
                {
                    lowStockProducts.add(product);
                }
            }
        if(lowStockProducts.isEmpty())
        {
            System.out.println("Sufficient stock available.");
            return;
        }
        System.out.println("Low Stock Products: ");

        for(Product product : lowStockProducts)
        {
            product.displayDetails();
        }
    }
}

