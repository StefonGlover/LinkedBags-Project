/**
 * Data Structures Programming Project 1: Linking Nodes
 * @author Stefon Glover
 * @version 9/2/2020
 */
import java.util.*;

public class LinkedBagProject {

    public static void main(String[] args)
    {
        //Scanner Object for user input
        Scanner in = new Scanner(System.in);

       //Bag object of names
       LinkedBag2<String> namesBag = new LinkedBag2<>();

       //New bag object created via displayScreen 
      //using the original bag object
      LinkedBag2<String> names = displayScreen(namesBag);

      //Ask ythe user for a name and delete it from the bag
      System.out.print("Please enter a name to delete: ");
      String nameToDelete = in.next();
      if(names.remove(nameToDelete))
      {
          System.out.println("The name "+nameToDelete+" has been successfully deleted from your bag.");
      }
      else
      {
        System.out.println("The name was not found/deleted in your bag.");
      }

      //Ask for a name and check whether it is in the bag or not
      System.out.print("Please enter a name to check if it’s in your bag or not: ");
      String checkName = in.next();
      if(names.contains(checkName))
      {
          System.out.println("The name "+checkName+" is in your bag.");
      }
      else
      {
          System.out.println(checkName+ " was not found in your bag.");
      }
      
      //Prints out all the names in the bag.
      printAll(names);
    }

    /**
    * Method to show the welcome screen and add entries to the bag.
    * @param namesBag
    * @return LinkedBag2 object.
    */
    public static LinkedBag2 displayScreen(LinkedBag2 namesBag)
    {
        //Scanner object for user input
        Scanner in = new Scanner(System.in);

        //LNew objects
        LinkedBag2<String> names = new LinkedBag2<>();

        //Welcome message
        System.out.println("Hello there! Welcome to your Personal Bag.");

        //Promp user for number of names to add
        System.out.print("How many names would you like to add to your bag? ");
        int numberOfNames = in.nextInt();

        //Loop to get names
        for(int i = 0; i < numberOfNames; i++)
        {
            System.out.print("Name "+(i+1)+": ");
            String name = in.next();
            namesBag.add(name);
        }
        return namesBag;

    }
    /**
     * Helper method to print all the names in the bag.
     * @param namesBag
     */
    public static void printAll(LinkedBag2 namesBag)
    {
        //Number of entries in the bag
        int numberOfEntries = namesBag.getCurrentSize();

        //Convert object Array to string
        Object[] namesArray = namesBag.toArray();
        
        System.out.print("List of names in the bag: ");

        //Print out every name in the array
        for(int i = 0; i < numberOfEntries; i++)
        {
            System.out.print(namesArray[i]+"| ");
        }
    }
    
}