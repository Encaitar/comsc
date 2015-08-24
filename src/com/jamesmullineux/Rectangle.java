package com.jamesmullineux;

public class Rectangle
{
  private double top;
  private double left;
  private double bottom;
  private double right;

  public Rectangle(double top, double left, double bottom, double right)
  {
    this.top = top;
    this.left = left;
    this.bottom = bottom;
    this.right = right;
  }

  public boolean intersects(Rectangle r)
  {
    if(overlapsXaxis(this, r))
    {
      if(overlapsYaxis(this, r))
      {
        return true;
      }
    }
    return false;
  }

  private boolean overlapsXaxis(Rectangle r1, Rectangle r2)
  {
    Rectangle bigger = biggerX(r1, r2);
    Rectangle smaller = smallerX(r1, r2);

    if(containedWithin(smaller.right, smaller.left, bigger.right, bigger.left))
    {
    	return true;
    }
    if(overlapPartially(smaller.right, smaller.left, bigger.right, bigger.left))
    {
    	return true;
    }
    return false;
  }
  
  private boolean overlapsYaxis(Rectangle r1, Rectangle r2)
  {
    Rectangle bigger = biggerY(r1, r2);
    Rectangle smaller = smallerY(r1, r2);

    if(containedWithin(smaller.top, smaller.bottom, bigger.top, bigger.bottom))
    {
    	return true;
    }
    if(overlapPartially(smaller.top, smaller.bottom, bigger.top, bigger.bottom))
    {
    	return true;
    }
    return false;
  }

  private Rectangle biggerX(Rectangle r1, Rectangle r2)
  {
    return (Math.abs(r1.right - r1.left) >= Math.abs(r2.right - r2.left)) ? r1 : r2;
  }

  private Rectangle smallerX(Rectangle r1, Rectangle r2)
  {
    return (Math.abs(r1.right - r1.left) >= Math.abs(r2.right - r2.left)) ? r2 : r1;
  }

  private Rectangle biggerY(Rectangle r1, Rectangle r2)
  {
    return (Math.abs(r1.top - r1.bottom) >= Math.abs(r2.top - r2.bottom)) ? r1 : r2;
  }

  private Rectangle smallerY(Rectangle r1, Rectangle r2)
  {
    return (Math.abs(r1.top - r1.bottom) >= Math.abs(r2.top - r2.bottom)) ? r2 : r1;
  }

  private boolean containedWithin(double firstBigger, double firstSmaller, double secondBigger, double secondSmaller)
  {
    if(firstBigger <= secondBigger && firstBigger >= secondSmaller &&
       firstSmaller <= secondBigger && firstSmaller >= secondSmaller)
    {
      return true;
    }
    else
    {
  	  return false;
    }
  }
  
  private boolean overlapPartially(double firstBigger, double firstSmaller, double secondBigger, double secondSmaller)
  {
    if((firstBigger > secondSmaller && firstSmaller < secondSmaller) || 
       (firstSmaller < secondBigger && firstBigger > secondBigger))
    {
      return true;
    }
    else
    {
	  return false;
    }
  }

}
