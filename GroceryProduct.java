public class GroceryProduct extends Product
{
    private int durability;

    public GroceryProduct(String productID, int quantity, String productName, double price, int durability)
    {
        super(productID, quantity, productName, price);
        this.durability = durability;
    }

    public int getDurability()
    {
        return durability;
    }

    @Override 
    public String getCategory()
    {
        return "Grocery";
    }
    @Override 
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Durability"+ durability);
    }
}
