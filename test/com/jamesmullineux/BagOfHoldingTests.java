package com.jamesmullineux;

import org.junit.Test;

import com.jamesmullineux.BagOfHolding;
import com.jamesmullineux.BagOfHolding.Item;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class BagOfHoldingTests {

  @Test
  public void testRecursive() {
    int capacity = 5;
    List<Item> items = new ArrayList<Item>();
    items.add(new Item(3, 2));
    items.add(new Item(7, 3));
    items.add(new Item(2, 4));
    items.add(new Item(9, 5));
    
    List<Item> solution = BagOfHolding.packBag(items, capacity);
    assertEquals(2, solution.size());
  }
  @Test
  public void testRecursive2() {
    int capacity = 5;
    List<Item> items = new ArrayList<Item>();
    items.add(new Item(9, 5));
    items.add(new Item(2, 4));
    Item answerOne = new Item(7, 3);
    items.add(answerOne);
    Item answerTwo = new Item(3, 2);
    items.add(answerTwo);

    List<Item> solution = BagOfHolding.packBag(items, capacity);
    List<Item> correctAnswer = new ArrayList<Item>();
    correctAnswer.add(answerTwo);
    correctAnswer.add(answerOne);
    assertTrue(solution.containsAll(correctAnswer));
    assertEquals(2, solution.size());
  }
  
  @Test
  public void testRecursive26() {
    int capacity = 26;
    List<Item> items = new ArrayList<Item>();
    items.add(new Item(24, 12));
    Item answerOne = new Item(13 , 7);
    items.add(answerOne);
    Item answerTwo = new Item(23, 11);
    items.add(answerTwo);
    Item answerThree = new Item(15, 8);
    items.add(answerThree);
    items.add(new Item(16, 9));

    List<Item> solution = BagOfHolding.packBag(items, capacity);
    List<Item> correctAnswer = new ArrayList<Item>();
    correctAnswer.add(answerTwo);
    correctAnswer.add(answerOne);
    correctAnswer.add(answerThree);
    assertTrue(solution.containsAll(correctAnswer));
    assertEquals(3, solution.size());
  }
  
  @Test
  public void testRecursive50() {
    int capacity = 50;
    List<Item> items = new ArrayList<Item>();
    Item answerOne = new Item(70 , 31);
    items.add(answerOne);
    items.add(new Item(20, 10));
    items.add(new Item(39, 20));
    Item answerTwo = new Item(37, 19);
    items.add(answerTwo);
    items.add(new Item(7, 4));
    items.add(new Item(5, 3));
    items.add(new Item(10, 6));

    List<Item> solution = BagOfHolding.packBag(items, capacity);
    List<Item> correctAnswer = new ArrayList<Item>();
    correctAnswer.add(answerTwo);
    correctAnswer.add(answerOne);
    assertTrue(solution.containsAll(correctAnswer));
    assertEquals(2, solution.size());
  }

  @Test
	public void testZeroCapacity() {
		int capacity = 0;
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1, 1));
		items.add(new Item(9, 9));
		items.add(new Item(1, 10));

		List<Item> solution = BagOfHolding.packBag(items, capacity);
		assertEquals(0, solution.size());
	}

	@Test
	public void testZeroItems() {
		int capacity = 10;
		List<Item> items = new ArrayList<Item>();

		List<Item> solution = BagOfHolding.packBag(items, capacity);
		assertEquals(0, solution.size());
	}

}
