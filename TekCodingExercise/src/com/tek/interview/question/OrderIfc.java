package com.tek.interview.question;

import com.tek.interview.question.impl.OrderLine;
//Implementing Interface for Order
public interface OrderIfc
{
  public int size();

  public OrderLineIfc get(int i);

  public void clear();

  public void add(OrderLine o)
    throws Exception;


}
