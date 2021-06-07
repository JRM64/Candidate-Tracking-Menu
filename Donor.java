import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Jack Mitchell
 */

public class Donor extends Element 
{
   private String name;
   private String location;
   private String amount;
   
   private static Scanner input = new Scanner(System.in);
   // donor constructor simply sets the name, location, amount, an
   // empty String
   public Donor()
   {
      name = "";
      location = "";
      amount = "";
   }
   
      /*
    This donor constructor initializes fields to values of input
    @param this.name name 
    @param location empty string
    @param amount empty string
    */
   public Donor(String name)
   {
      this.name = name;
      location = "";
      amount = "";
   }
   
   
     // setter and mutator methods
   
    /*
    This method sets the name field to the value of the parameter, name
    @param name is the Value that the name field will be set to
    */
   public String getName()
   {
      return name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
      /*
    This method sets the location field to the value of the parameter, location
    @param location is the Value that the name field will be set to
    */
   public String getLocation()
   {
      return location;
   }
   
   public void setLocation(String location)
   {
      this.location = location;
   }
      /*
    This method sets the amount field to the value of the parameter, amount
    @param amount is the Value that the name field will be set to
    */
   public String getAmount()
   {
      return amount;
   }
   
   public void setAmount(String amount)
   {
      this.amount = amount;
   }
   // read in method for input of the donors name location and donations.
   public void readIn()
   {
      System.out.print("Enter the Name of the Donor: ");
      name = input.nextLine().toUpperCase();
      
      System.out.print("Enter the location of the donation: ");
      location = input.nextLine().toUpperCase();
      
      System.out.print("Enter the amount of Donations: ");
      double num = Double.parseDouble(input.nextLine());
      
      System.out.print("Enter the amounts donated when prompted: \n");
      amount = "";
      // for loop that counts the number of amounts donated
      for (int i = 0; i < num; i++)
      {
         System.out.print ((i + 1) + ")");
         amount += input.nextLine().toUpperCase();
         if (i != num - 1)
               amount += ",";
               
      }    
   }
   // display method that will give all of the donors information
   public void display()
   {
      System.out.println("Name: " + name);
      System.out.println("Location: " + location);
      System.out.println("Amount: ");
      StringTokenizer token = new StringTokenizer(amount.replace(',',' '));
      while (token.hasMoreTokens())
      {
         System.out.println(" " + token.nextToken());
      }
   }
   
   public boolean equals(Element dobj)
   {
      if (dobj.getClass().getName().contains("Donor"))
         if (getName().equals(((Donor) dobj).getName()))
            return true;
            
      return false;
   }
   // clone method
   public Element clone()
   {
      Donor clone = new Donor();
      
      clone.setName(getName());
      clone.setLocation(getLocation());
      clone.setAmount(getAmount());
      
      return clone;
   }
}