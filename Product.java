public abstract class Product {
    private String productID;
    private int quantity;
    private String productName;
    private double price;


    public Product(String productID, int quantity, String productName, double price)
    {
        this.productID = productID;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public String getID()
    {
      return productID;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public String getproductName()
    {
        return productName;
    }
    public double getprice()
    {
        return price;
    }

    public  void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void addStock(int amount)
    {
      if(amount <= 0)
      {
        throw new IllegalArgumentException("Please add some positive amount to add products in your stock!");
      }
      quantity += amount;
      System.out.println("Current Stock: "+ quantity);
    }
    public void removeStock(int amount)
    {
        if(amount > quantity)
        {
            throw new IllegalArgumentException("Insufficient Stock");
        }
        quantity -= amount;
    }

    public abstract String getCategory();

    public void displayDetails()
    {
        System.out.println(
       "Product ID: "+ productID + "\n" +
       "Price: ₹"+ price + "\n" + 
       "Product Name: "+ productName + "\n" +
       "Product Quantity: "+ quantity + "\n" +
       "Product Category: "+ getCategory()
     );
    }
}
