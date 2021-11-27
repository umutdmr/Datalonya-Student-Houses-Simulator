
public class Student implements Comparable<Student>
{
	//fields
	String name;
	private int id;
	private int duration;
	private double rating;
	
	// constructor
	public Student(int id, String name, int duration, double rating)
	{
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.rating = rating;
	}
	
	//compareTo method
	public int compareTo(Student student)
	{
		if(id  == student.id)
		{
			return 0;
		}
		else if(id > student.id)
		{
			return 1;
		}
		else
		{
			return -1;
		}
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
