package com.nicodangelo.item;

//version 1.12.19.1
public class Item {
	String itemName;
	int amountOfItem;
	int warnLow;
	boolean isSelected = false;
	
	public Item(String name, int ammount, int low)
	{
		itemName = name;
		amountOfItem = ammount;
		warnLow = low;
	}
   
   public Item(String name, int ammount)
	{
		itemName = name;
		amountOfItem = ammount;
		warnLow = 0;
	}
   
   public Item(String name)
	{
		itemName = name;
		amountOfItem = 0;
		warnLow = 0;
	}
	
	public Item()
	{
		itemName = "";
		amountOfItem = 0;
		warnLow = 0;
   }
	
	public String getName()
	{
		return itemName;
	}
	
	public int getAmmount()
	{
		return amountOfItem;
	}
	
	public void setName(String name)
	{
		itemName = name;
	}
	
	public void setAmmount(int newAmmount)
	{
		amountOfItem = newAmmount;
	}
   
    public int getLow()
	{
		return warnLow;
	}
	
	public void setLow(int low)
	{
		warnLow = low;
	}

	public boolean getSelected()
	{
		return isSelected;
	}

	public void setSelected(boolean stuff)
	{
		isSelected = stuff;
	}


	

	
   
}
