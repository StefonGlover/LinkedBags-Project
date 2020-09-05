/**
 * Data Structures Programming Project 1: Linking Nodes
 * LinkedBag class that implements a generic Bag Interface.
 * @author Stefon Glover
 * @version 9/2/2020
 */


public final class LinkedBag2<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag2()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    //Implementations of the public methods declared in BagInterface.

    /**
     * Adds a new entry to this bag.
     *@param newEntry The object to be added as a new entry.
     *@return True 
     */
    public boolean add(T newEntry)
    {
        //Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; //Make new node reference rest of chain
                                  //(firstNode is null if chain is empty)
       firstNode = newNode;
       numberOfEntries++;

       return true;
    }

     /**
     * Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag.
     */
    public T[] toArray()
    {
        //The case is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; //Unchecked cast
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return result;
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;

        while ((loopCounter < numberOfEntries) && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
                frequency++;
            loopCounter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found &&(currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove()
    {
        T result = null;
        if(firstNode != null)
        {
            result = (T) firstNode.data;
            firstNode = firstNode.next; //Remove first node from chain
            numberOfEntries--;
        }
        return result;
    }

    //Locates a given entry within this bag.
    //Returns a reference to the node containing the entry, if located.
    //or null otherwise.
    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

    /**
     * Removes one occurence of a give entry from this bag, if possible.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not. 
     */
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if(nodeN != null)
        {
            nodeN.data = firstNode.data; //Replace located entry with entry
                                        //in first node
            firstNode = firstNode.next; //Remove first node
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    /**
     * Node private class
     * Define properties for the object
     */
    
    private class Node{

        //Instance variables
        private T data; //entry in collection
        private  Node next; //link to next node
    
        public Node(T dataPortion, Node nextNode)
        {
            this.data = dataPortion;
            this.next = nextNode;
        }
    
        public Node(T dataPortion)
        {
            this(dataPortion, null);
        }
    
        public T getData()
        {
            return data;
        }
        
        public Node getNextNode()
        {
            return next;
        }
    
        public void setData(T dataPortion)
        {
            data =dataPortion;
        }
    
        public void setNextNode(Node nextMode)
        {
            next = nextMode;
        }
    }

   /**
    * Gets the number of entries currently in this bag.
    @return The integer number of entries currently in this bag.
    */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Tests whether this bag is empty
     * @return True if this bag is empty.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while(!isEmpty())
        {
            remove();
        }

    }
}