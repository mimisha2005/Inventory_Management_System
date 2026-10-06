public class ElectronicsProduct extends Product
{
    private int warrantyMonths;

    public ElectronicsProduct(String productID, int quantity, String productName, double price, int warrantyMonths)
    {
     super(productID, quantity, productName, price);
     this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths()
    {
        return warrantyMonths;
    }
@Override
  public String getCategory()
  {
    return "Electronics Products";
  }
@Override 
  public  void displayDetails()
  {
    super.displayDetails();
    System.out.println("Warranty Months" + warrantyMonths + "Months");
  }
}