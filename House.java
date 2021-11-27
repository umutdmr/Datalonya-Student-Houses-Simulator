
public class House implements Comparable<House>
{
	//fields
	private int id;
	private int duration;
	private double rating;
	
	//constructor
	public House(int id, int duration, double rating)
	{
		this.id = id;
		this.duration = duration;
		this.rating = rating;
	}
	
	//compareTo method
	public int compareTo(House house)
	{
		if(id  == house.id)
		{
			return 0;
		}
		else if(id > house.id)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	// used for changing the duration while new student added
	public void changeDuration(int amount)
	{
		duration += amount;
	}
	
	//getter methods
	public int getDuration()
	{
		return this.duration;
	}
	public double getRating()
	{
		return this.rating;
	}
	
	
}
