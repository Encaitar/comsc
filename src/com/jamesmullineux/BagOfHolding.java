package com.jamesmullineux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BagOfHolding
{    

  public static List<Item> packBag(List<Item> items, int capacity)
  {
    /*
     *  Table to fill in to perform dynamic programming.
     *  x axis is the maximum capacity currently being examined.
     *  y axis is the number of items from the list currently being examined.
     */
    int[][] table = new int[capacity + 1][items.size()];
    // Initialise the table to be the special value of -1
    for (int x = 0; x < capacity + 1; x++)
    {
      for (int y = 0; y < items.size(); y++)
      {
        table[x][y] = -1;
      }
    }

    // fills in the table with the best possible solutions at each position
    recursiveDynamicProgramming(items, capacity, items.size() - 1, table);

    List<Item> solution = findItemsFromMaxValuesTable(items, capacity, table);

    return solution;
  }

  /*
   * Look at the table containing the values produced by performing dynamic programming
   * to solve the problem and find the first occurance of each final increase 
   */
  private static List<Item> findItemsFromMaxValuesTable(List<Item> items, int capacity, int[][] table)
  {
    List<Item> solution = new ArrayList<Item>();
    
    // starting at the bottom left of the table
    int currentCapacityLimit = capacity;
    int numberOfItems = items.size() - 1;

    // while we are on a valid row
    while (numberOfItems >= 0)
    {
      Item item = items.get(numberOfItems);
      int previousBestValue = 0;

      // if we are not on the top row
      if(numberOfItems != 0)
      {
        // get the value from above
        previousBestValue = table[currentCapacityLimit][numberOfItems - 1];
      }

      // if this is the earliest occurrence of this value
      if (table[currentCapacityLimit][numberOfItems] != previousBestValue)
      {
        // this row must represent one of the optimal items
        solution.add(item);
        // move left along the table to find the previous items
        currentCapacityLimit -= item.getSize();
      }
      // move up the table to find the first occurrence if we haven't found it yet
      numberOfItems--;
    }
    return solution;
  }

  /*
   * Fills in the dynamic programming table that records the best possible value for
   * each capacity and number of items combination below the maximum capacity (x axis) and the 
   * maximum number of items in the list (y axis).
   */
  private static int recursiveDynamicProgramming(List<Item> items, int currentCapacity, int numberOfItemsToBeUsed, int[][] table)
  {
    // terminating condition for recursion
    if (currentCapacity < 0 || numberOfItemsToBeUsed < 0)
    {
      return 0;
    }
    // get next item to try
    Item item = items.get(numberOfItemsToBeUsed);
    
    int thisValue, previousBestValue = table[currentCapacity][numberOfItemsToBeUsed];

    // if cell has not been set, indicated by the special initialisation value -1
    if (table[currentCapacity][numberOfItemsToBeUsed] == -1)
    {
      // if this item has a size greater than the column we are considering, ignore it
      if (item.getSize() > currentCapacity)
      {
        // m[i,w] = m[i-1, w] if wi > w
        thisValue = -1;
      }
      // else we can consider this new item
      else
      {
        // m[i,w] = m[i-1, w - wi] if wi <= w
        thisValue = item.getValue() + recursiveDynamicProgramming(items, currentCapacity - item.getSize(), numberOfItemsToBeUsed - 1, table);
      }
      
      // m[i,w] = max(m[i-1, w]) if wi <= w
      previousBestValue = recursiveDynamicProgramming(items, currentCapacity, numberOfItemsToBeUsed - 1, table);
      // m[i,w] = max(m[i-1, w], m[i-1, w - wi]) if wi <= w
      table[currentCapacity][numberOfItemsToBeUsed] = Math.max(thisValue, previousBestValue);
    }
    
    return table[currentCapacity][numberOfItemsToBeUsed];
  }
  
  /*
   * Stores Items with values and sizes for the knapsack problem
   */
  public static class Item
  {
    private int value;
    private int size;
    
    public static Comparator<Item> byRatio() {
      return new Comparator<Item>() {
         public int compare(Item a, Item b) {
           return Double.compare(a.value/a.size, b.value/b.size);
         }
      };
   }

    public Item(int value, int size)
    {
      this.value = value;
      this.size = size;
    }
    
    public int getValue()
    {
      return this.value;
    }

    public int getSize()
    {
      return this.size;
    }
    
    public void increaseValue(int value)
    {
      this.value += value;
    }

    public void increaseSize(int size)
    {
      this.size += size;
    }

  }

}
