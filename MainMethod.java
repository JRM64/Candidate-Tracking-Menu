import java.util.Scanner;

/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #3
 * 
 * @author Jack Mitchell
 */

public class MainMethod
{

   static Scanner kbd = new Scanner(System.in);
      //calling the element set
   private static ElementSet theElemSet = new ElementSet();
      
   public static void main (String[] args)
   {
      // calls the menu method
      menu();
   }
     
      /**
	 * Prompts the user if he wants to quit.
	 * 
	 * @return false if user does not want to quit, else returns true
	 */
      
   private static boolean getQuit()
   {
      System.out.println("Do you want to quit? Y) Yes N) No");
      if (kbd.next().toUpperCase().charAt(0) == 'N')
         return false;
      else 
         return true;
   }
      
      
      /**
	 * shows the user a menu, prompts for input, and then executes the
	 * user's choice.
	 */
   private static void menu()
   {
      boolean isValid = false;
      char input;
      String [] menu = {"Add a New Candidate", "Add a new Donor", "Display the names of all the candidates.","Display the names of all the donors", "Display all data for a specific candidate.",
         "Display all of the data for a specific Donor", "Remove a particular Candidate","Remove a particular Donor","Quit the program."};
      
      do
      {
         System.out.println("\n\nPresidential Candidate Tracking System Data Menu");
         for (int i = 0; i < 9; i++)
            System.out.println((i+1) + ")" + menu[i]);
            
         System.out.println("Enter a menu choice (1-9): ");
         input = kbd.nextLine().charAt(0);
            
         if (input <= '9' && input >= '1')
            isValid = true;
         else
            System.out.println("Invalid Choice. Please enter a number (1-9): ");
      }
       
      while (!isValid);
      
      //putting cases in a try statement
      try
      {
         switch (input)
         {
            case '1':
               addCandidate(theElemSet);
               break;
           
            case '2':
               addDonor(theElemSet);
               break;
           
            case '3':
               displayCandidateNames(theElemSet);
               break;
           
            case '4':
               displayDonorNames(theElemSet);
               break;
           
            case '5':
               displayCandidateData(theElemSet);
               break;
           
            case '6':
               displayDonorData(theElemSet);
               break;
           
            case'7':
               removeCandidate(theElemSet);          
               break;
           
            case '8':
               removeDonor(theElemSet);
               break;
           
         }
      }
      
      //catch clauses
      catch (CannotRetrieveException e)
      {
         System.out.println("CannotRetrieveException Thrown");
      }
      catch (CannotRemoveException e)
      {
         System.out.println("CannotRemoveException Thrown");
      
      }
      catch (DuplicateObjectException e)
      {
         System.out.println("DuplicateObjectException Thrown");
      }
       
       
   
         
      if (input != '9')
         menu();
      else if (!getQuit())
         menu();
      
   }
    
    /**
	 * Menu option 1: Add a new Candidate to the ElementSet list.
	 */
    
   private static void addCandidate(ElementSet object) throws DuplicateObjectException
   {
      Element anElement;
      anElement = new Candidate();
      anElement.readIn();
         
      boolean addResult;
      addResult = object.add(anElement);
         
      if (addResult = false)
      {
         System.out.println("Could not add. Set is full");
      }
      else
      {
         System.out.println("Add Successfull");
            
      }
   }
      
       /**
	 * Menu option 2: Add a new Donor to the ElementSet list.
	 */
   private static void addDonor (ElementSet object) throws DuplicateObjectException
   {
      Element anElement;
      anElement = new Donor();
      anElement.readIn();
         
      boolean addResult;
      addResult = object.add(anElement);
         
      if (addResult = false)
      {
         System.out.println("Could not add. Set is full");
      }
      else
      {
         System.out.println("Add Successfull");
            
      }
   }
         
       /**
	 * Menu option 3: display candidate names in the ElementSet list.
	 */
   private static void displayCandidateNames(ElementSet object)
   {
      Element anElement;
      String find = "Candidate";
      boolean found = false;
         
      for (int i = 0; i < object.size(); i++)
      {
         anElement = object.getCurrent();
         if (find.equals(anElement.getClassName()))
         {
          
            found = true;
            System.out.println(((Candidate) anElement).getName());
         }
      }
         
      if (!found)
      {
         System.out.println("There are no candidates in the set.");
      }
   }
       /**
	 * Menu option 4: display all donors in the ElementSet list.
	 */
   private static void displayDonorNames(ElementSet object)
   {
      Element anElement;
      String find = "Donor";
      boolean found = false;
         
      for (int i = 0; i < object.size(); i++)
      {
         anElement = object.getCurrent();
         if (find.equals(anElement.getClassName()))
         {
            found = true;
            System.out.println(((Donor) anElement).getName());
         }
      }
         
      if (!found)
      {
         System.out.println("There are no Donors in the set.");
      }
   }
      
       /**
	 * Menu option 5: display a certain candidate in the ElementSet list.
	 */
   private static void displayCandidateData (ElementSet object) throws CannotRetrieveException
   {
      System.out.println("Enter the Name of the Candidate Here: ");
      String name = kbd.nextLine().toUpperCase();
      Candidate can = new Candidate();
      can.setName(name);
      Element result = object.retrieveAnObject(can);
      
      //implementing try statement 
      try 
      {
         if (!object.isMemberOf(new Candidate(name,"","","")))
            throw new CannotRetrieveException("This Candidate could not be found.");
            
         else
            result.display();
      
      } 
    
      //catching data for invalid input
      catch (CannotRetrieveException e) {
         System.out.println("Candidate data could not be retrieved.");
      
       
      
      }   
   }
      
        /**
	 * Menu option 6: display a certain donor in the ElementSet list.
	 */
   private static void displayDonorData (ElementSet object) throws CannotRetrieveException
   {
      Scanner kbd = new Scanner (System.in);
      System.out.println("Enter the Name of the Donor Here: ");
      String name = kbd.nextLine().toUpperCase();
      Donor don = new Donor();
      don.setName(name);
      Element result = object.retrieveAnObject(don);
      
      //implementing try statement 
      try 
      {
         if (!object.isMemberOf(new Donor(name)))
            throw new CannotRetrieveException("This Donor could not be found.");
         else
            result.display();
      } 
      
      //catching data for invalid input
      catch (CannotRetrieveException e) 
      {
         System.out.println("Donor data cannot be retrieved.");
      }
         
   }
      
      
      
        /**
	 * Menu option 7: remove a certain candidate in the ElementSet list.
	 */
   private static void removeCandidate (ElementSet object) throws CannotRemoveException
   {
      Scanner kbd = new Scanner(System.in);
      System.out.print("Enter Candidates Name to Remove: ");
      String name = kbd.nextLine().toUpperCase();
       
      //implementing try statement   
      try
      {
         if (!object.isMemberOf(new Candidate(name,"","","")))
            throw new CannotRemoveException("");
         else
            System.out.println("The Candidate was successfully removed");
               
         Candidate found = new Candidate(name,"","","");
         object.removeAnObject(found);
      }
      //catching data for invalid action
      catch(CannotRemoveException e)
      {  
         System.out.println("The Candidate you specified is not in the set");
      } 
   }
        
          /**
	 * Menu option 8: remove a certain donor in the ElementSet list.
	 */
   private static void removeDonor (ElementSet object) throws CannotRemoveException
   {
      Scanner kbd = new Scanner(System.in);
      System.out.print("Enter Donors Name to Remove: ");
      String name = kbd.nextLine().toUpperCase();
      
      //implementing try statement   
      try
      {
         if (!object.isMemberOf(new Donor(name)))
            throw new CannotRemoveException("");
         else 
            System.out.println("The Donor was successfully removed");
               
         Donor found = new Donor(name);
         object.removeAnObject(found);
      }
      //catching data for invalid action
      catch (CannotRemoveException e)
      {
         System.out.println("The Donor you specified is not in the set");
      }
   }
}