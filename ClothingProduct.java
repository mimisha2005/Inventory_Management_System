public class ClothingProduct extends Product 
{
    private String type;

    public ClothingProduct(String productID, int quantity, String productName, double price, String type)
    {
        super(productID, quantity, productName, price);
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    @Override 
    public String getCategory()
    {
        return "Clothing";
    }

    @Override 
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Type of cloth used: "+ type);
    }
}
