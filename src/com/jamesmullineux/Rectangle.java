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
    if(this.overlapsXaxis(r) && this.overlapsYaxis(r))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  // can collapse these two check to a single check of is the first within, return true, else check the other one is in, return true, finally return false
  private boolean overlapsXaxis(Rectangle r2)
  {
    Rectangle bigger = bigger(this.left, this.right, r2.left, r2.right) ? this : r2;
    Rectangle smaller = bigger(this.left, this.right, r2.left, r2.right) ? r2 : this;

    if(containedWithin(smaller.left, smaller.right, bigger.left, bigger.right))
    {
    	return true;
    }
    if(overlapPartially(smaller.left, smaller.right, bigger.left, bigger.right))
    {
    	return true;
    }

    return false;
  }
  
  private boolean overlapsYaxis(Rectangle r2)
  {
    Rectangle bigger = bigger(this.bottom, this.top, r2.bottom, r2.top) ? this : r2;
    Rectangle smaller = bigger(this.bottom, this.top, r2.bottom, r2.top) ? r2 : this;

    if(containedWithin(smaller.bottom, smaller.top, bigger.bottom, bigger.top))
    {
    	return true;
    }
    if(overlapPartially(smaller.bottom, smaller.top, bigger.bottom, bigger.top))
    {
    	return true;
    }

    return false;
  }

  private boolean bigger(double line1Start, double line1End, double line2Start, double line2End)
  {
    return (Math.abs(line1End - line1Start) >= Math.abs(line2End - line2Start)) ? true : false;
  }

  private boolean containedWithin(double smallerStart, double smallerEnd, double biggerStart, double biggerEnd)
  {
    if(smallerEnd <= biggerEnd && smallerEnd >= biggerStart &&
        smallerStart <= biggerEnd && smallerStart >= biggerStart)
    {
      return true;
    }
    else
    {
  	  return false;
    }
  }
  
  private boolean overlapPartially(double smallerStart, double smallerEnd, double biggerStart, double biggerEnd)
  {
    if((smallerEnd > biggerStart && smallerStart < biggerStart) || 
       (smallerStart < biggerEnd && smallerEnd > biggerEnd))
    {
      return true;
    }
    else
    {
	  return false;
    }
  }

}
