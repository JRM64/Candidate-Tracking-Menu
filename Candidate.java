

/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #3
 * 
 * @author Jack Mitchell
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Candidate extends Element
{
   Scanner kbd = new Scanner(System.in);
   
   private String name;
   private String age;
   private String party;
   private String issueList;
   
   //candidate constructor simply sets the name, age, party, and issues to an
   // empty string
   public Candidate()
   {
      name = "";
      age = "";
      party = "";
      issueList = "";
   
   }
   
       /*
    This candidate constructor initializes fields to values of input
    @param n Name 
    @param a age 
    @param p party
    */
   public Candidate (String n, String a, String p, String is)
   {
      name = n;
      age = a;
      party = p;
      issueList = is;
      
   }
   
   public Candidate (String n, String p, String isL)
   {
      name = n;
      party = p;
      issueList = isL;
   
   }
   
   // setter and mutator methods
   
    /*
    This method sets the name field to the value of the parameter, n
    @param n is the Value that the name field will be set to
    */
   
   public void setName(String n)
   {
      name = n.toUpperCase();
   }
   
   /*
    This method sets the age field to the value of the parameter, a
    @param a is the Value that the name field will be set to
    */
   public void setCandidateAge(String a)
   {
      age = a.toUpperCase();
   
   }
   /*
    This method sets the party field to the value of the parameter, p
    @param p is the Value that the name field will be set to
    */
   public void setCandidateParty(String p)
   {
      party = p.toUpperCase();
   }
    /*
    This method sets the issueList field to the value of the parameter, iList
    @param Ilist is the Value that the name field will be set to
    */
   public void setIssueList(String iList)
   {
      issueList = iList;
   }
   
   
   //getter methods
   
    public String getName()
    {
            return name;
    }        
    
    public String getCandidateAge()
    {
            return age;
    }
    
    public String getCandidateParty()
    {
        return party;
    }     
    
    public String getIssueList()
    {
        return issueList;
    }
    
    
    // the issue list tokenizers will take issues and seperate them in the feild
    public String issueListTokenizer (String issueList)
    {
      StringTokenizer big = new StringTokenizer(issueList, ";");
      String tokenList = "";
      
      while (big.hasMoreTokens())
      {
         issueList = (big.nextToken());
         tokenList = tokenList + issueList + "\n";
      }
      
      return tokenList;
    }
     
      /**
	 * read in method for input	 */
	public void readIn() {
		System.out.print("Enter the name of the candidate: ");
		name = kbd.nextLine().toUpperCase();
      
      System.out.print("Enter the age of the candidate: ");
      age = kbd.nextLine();

		System.out.print("Enter the party of the candidate: ");
		party = kbd.nextLine().toUpperCase();

		System.out.print("Enter the number of issues the candidate has: ");
		int num = Integer.parseInt(kbd.nextLine());

		System.out.print("Enter the candidates issue: \n");
		issueList = "";

		for (int i = 0; i < num; i++) {
			System.out.print((i + 1) + ") ");
			issueList += kbd.nextLine().toUpperCase();
			if (i != num - 1)
				issueList += ", ";
		}
	}   
    
   public void display()
   {
      String candidateDisplay = ("Age: " + age + "\nParty: " + party + 
               "\nImportant Issues: \n" + issueListTokenizer(issueList));
               
      System.out.println(candidateDisplay);
   
   }
   
   /*
   the displayCandidateNames method uses a loop that will store the names of candidates name
   as it passed through the i array
   @param candidate list is the array that contains the candidates names
   */
   
   public void displayCandidateNames(ArrayList<Candidate> candidateList)
   {
      System.out.println("\nCandidate Names: ");
      for(Candidate i: candidateList)
      {
         System.out.println(" " + i.getName());
      }
   }
     /*
   the searchCandidate method searches through the array and displays if they were found
   @param candidateList is the array that will be searched
   */
   public static void searchCandidate(ArrayList<Candidate> candidateList)
   {
   Scanner kbd = new Scanner(System.in);
   char response;
   String search;
   int found;
   
      do
      {  
         System.out.print("Enter the name of the candidate: ");
         search = kbd.nextLine().toUpperCase();
         
         found = binarySearch(candidateList, search); // binary search method looking for candidate search name
         
         if (found == -1)
         {
            System.out.println("This Candidate was not found");
         }
            else
            candidateList.get(found).display();
            
            
            System.out.println("Do you want to enter another candidate? \nYes \nNo");
            response = kbd.nextLine().toUpperCase().charAt(0);
      }
      
      while(response == 'Y');
      
    }
       /*
      the displayPoliticalParty method searches the candidates and will display who is part of that
      political party
       @param candidateList is the array that will be searched
      */
      public void displayPoliticalParty(ArrayList<Candidate> candidateList)
      {
         System.out.println("Enter the Name of a political Party: ");
         String political = kbd.nextLine().toUpperCase();
         ArrayList<Candidate> results = new ArrayList<Candidate>();
         
         for (Candidate c: candidateList)
         {
            if (c.getCandidateParty().equals(political))
               results.add(c);
         }
         
         if (results.size()>0)
         {
            System.out.println("\n" + political + "contains these candidates: ");
            for (Candidate c: results)
               System.out.println(" "+ c.getName());
         }
         else 
            System.out.println(political + "does not seem to have any candidates");
       
      
      }
     /*
      the displayCandidateWithIssue method searches for the specific issue and finds that candidate
       @param candidateList is the array that will be searched
      */
     public void displayCandidateWithIssue(ArrayList<Candidate> candidateList)
     {
      System.out.println("Enter an issue: ");
      String issue = kbd.nextLine().toUpperCase();
      ArrayList<Candidate> results = new ArrayList<Candidate>();
      
      for(Candidate c : candidateList)
      {
         if(c.getIssueList().contains(issue))
            results.add(c);
      }
      if(results.size()>0)
      {
         System.out.println("\n These Candidates have this issue " + issue + ": ");
         for(Candidate c : results)
            System.out.println(" "+ c.getName());
      }
         else
            System.out.println("No candidate has the issue of" + issue);
     }
       /*
      the binary search method will search through candidates to find a specific one
       @param candidateList is the array that will be searched
       @param searchKey the name
       @return returns the location in the array where the candidate was found
      */
     public static int binarySearch (ArrayList<Candidate> candidateList, String searchKey)
     { 
     
       int first = 0;
       int last = candidateList.size();
       int middle;
       int whereFound = -1;
       
       boolean found = false;
       String middleString;
       
       while(!found && first <= last)
       {
         middle = (first+last)/2;
         middleString = candidateList.get(middle).getName();
         
         if(middleString.equals(searchKey))
         {
            found = true;
            whereFound = middle;
         }
         
         else if (middleString.compareTo(searchKey)>0)
            last = middle -1;
         else
            first = middle + 1;
       }
         return whereFound;
       }  
       
   
      public boolean equals(Element dobj)
   {
      
       if (dobj.getClass().getName().contains("Candidate"))
         if (getName().equals(((Candidate) dobj).getName()))
            return true;
       
      if (dobj.getClass().getName().contains("Donor"))
         if (getName().equals(((Donor) dobj).getName()))
            return true;
            
      return false;
   }
   
    public Element clone()
   {
      Candidate clone = new Candidate();
      
      clone.setName(getName());
      clone.setCandidateAge(getCandidateAge());
      clone.setCandidateParty(getCandidateParty());
      clone.setIssueList(getIssueList());
      
      return clone;
   }
   
   
   

}