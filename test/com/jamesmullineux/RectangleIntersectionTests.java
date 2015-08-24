package com.jamesmullineux;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jamesmullineux.Rectangle;

public class RectangleIntersectionTests {

	@Test
	public void testDoesntOverlayOrTouch() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		Rectangle r2 = new Rectangle(5.0, 2.0, 3.0, 3.0);
		
		assertFalse(r1.intersects(r2));
	}
	
	@Test
	public void testEquals() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		Rectangle r2 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		
		assertTrue(r1.intersects(r2));
	}

	@Test
	public void testEncompases() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		Rectangle r2 = new Rectangle(3.0, -1.0, -1.0, 2.0);
		
		assertTrue(r1.intersects(r2));
	}

	@Test
	public void testCornerOverlap() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 2.0);
		Rectangle r2 = new Rectangle(3.0, 1.0, 1.0, 3.0);
		
		assertTrue(r1.intersects(r2));
	}
	
	// check this overlap
	@Test
	public void testXOverlap() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 2.0);
		Rectangle r2 = new Rectangle(2.0, 1.0, 0.0, 3.0);
		
		assertTrue(r1.intersects(r2));
	}
	
	@Test
	public void testYOverlap() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		Rectangle r2 = new Rectangle(3.0, 0.0, 1.0, 1.0);
		
		assertTrue(r1.intersects(r2));
	}
	
	@Test
	public void testEdgeOnlyXTouching() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		Rectangle r2 = new Rectangle(2.0, 1.0, 0.0, 2.0);
		
		assertFalse(r1.intersects(r2));
	}
	
	@Test
	public void testEdgeOnlyYTouching() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		Rectangle r2 = new Rectangle(4.0, 0.0, 2.0, 1.0);
		
		assertFalse(r1.intersects(r2));
	}

	@Test
	public void testCornerOnlyTouching() {
		Rectangle r1 = new Rectangle(2.0, 0.0, 0.0, 1.0);
		Rectangle r2 = new Rectangle(4.0, 0.0, 2.0, 1.0);
		
		assertFalse(r1.intersects(r2));
	}

	@Test
	public void testDecimalValuesCornerOverlap() {
		Rectangle r1 = new Rectangle(2.1, 0.1, 0.1, 2.1);
		Rectangle r2 = new Rectangle(3.1, 1.1, 1.1, 3.1);
		
		assertTrue(r1.intersects(r2));
	}
	
	@Test
	public void testNegativeDecimalValuesCornerOverlap() {
		Rectangle r1 = new Rectangle(-0.1, -2.1, -2.1, -0.1);
		Rectangle r2 = new Rectangle(-1.1, -3.1, -3.1, -1.1);
		
		assertTrue(r1.intersects(r2));
	}
}
