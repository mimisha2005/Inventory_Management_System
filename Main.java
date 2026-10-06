import java.util.Scanner;
public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static InventoryManager inventorymanager = new InventoryManager();
    public  static void main(String[] args)
    {
        boolean running = true;

        while(running)
        {
            displayMenu();

            int choice = readInt("Enter your choice: ");

            try
            {
             switch (choice) 
             {
                case 1:
                    addProduct();
                    break;
                case 2:
                    inventorymanager.displayAllProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    updateStock();
                    break;
                case 5:
                    sellProduct();
                    break;
                case 6:
                    removeProduct();
                    break;
                case 7:
                    displayLowStock();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            
             }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
    


  private static void displayMenu()
  {
    System.out.println("\n-----Inventory Management System----\n");

    System.out.println("1. Add Product");
    System.out.println("2. View all Products");
    System.out.println("3. search products");
    System.out.println("4. Add Stock");
    System.out.println("5. Sell Product");
    System.out.println("6. Remove Stock");
    System.out.println("7. view low Stock");
    System.out.println("Exit");

  }

  private static void addProduct()
  {
    System.out.println("\n Select Product Category: ");

    System.out.println("1. Electronics");
    System.out.println("2. Grocery");
    System.out.println("3. Clothing");

    int category = readInt("Enter the category: ");

    String productID = readString("Enter Product Id: ");

    System.out.println("Enter Product Name: ");
    String name = scanner.nextLine();

    double price = readDouble("Enter Price: ");

    int quantity = readInt("Enter Quantity: ");

    Product product;

    switch (category) {
        case 1:
            int warranty = readInt("Enter warranty in months: ");

            product = new ElectronicsProduct(productID, quantity, name, price, warranty);
            break;
        case 2:
            int durability = readInt("Enter durability: ");
            System.out.println("Best Before "+ durability + "Months.");
        case 3:
            System.out.println("Cloth type: ");
            String type = scanner.nextLine();

            product = new ClothingProduct(productID, quantity, name, price, type);
    
        default:
            throw new IllegalArgumentException("Invalid Product Category!");
    }
    inventorymanager.addProduct(product);
  }

  private static void searchProduct()
  {
    String productID = readString("Enter Product ID: ");

    Product product = inventorymanager.searchProduct(productID);

    if(product == null)
    {
        System.out.println("Product not found!");
    } else{
        product.displayDetails();
    }
  }

  private static void updateStock()
  {
    String productID = readString("Enter Product Id");
    int amaount = readInt("Enter stock to add: ");
    inventorymanager.updateStock(productID, amaount);
  }

  private static void removeProduct()
  {
    String productID = readString("Enter product id: ");
    inventorymanager.removeProduct(productID);
  }

  private static void sellProduct()
  {
    String productID = readString("Enter Product Id: ");
    int amount = readInt("Enter quantity to send: ");
    inventorymanager.sellProduct(productID, amount);
  }

  private static  void displayLowStock()
  {
    int threshold = readInt("Low Stock Threshold: ");
    inventorymanager.displayLowStockProducts(threshold);
  }

   private static int readInt(String message)
   {
     while(true)
     {
        try
         {
            System.out.println(message);
            return Integer.parseInt(scanner.nextLine());
         }
         catch(NumberFormatException e)
         {
          System.out.println("Please enter a valid Integer.");
         }
     }
    }

   private static double readDouble(String message)
   {
      while(true)
      {
          try{
            System.out.println(message);
            return Double.parseDouble(scanner.nextLine());
            }catch(NumberFormatException e)
            {
            System.out.println("Please enter a valid Integer.");
            }
       }
    }
    private static String readString(String message)
    {
        while(true)
        {
            try
            {
              System.out.println(message);
              return scanner.nextLine();
            } catch(StringIndexOutOfBoundsException s)
            {
              System.out.println("Please enter a valid String");
            }
        }
    }
}




