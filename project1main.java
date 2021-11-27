
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
public class project1main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Scanner in = new Scanner(new File (args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		TreeMap<Student, Boolean> students = new TreeMap<Student, Boolean>();
		TreeSet<House> houses = new TreeSet<House>();
		
		//read input file, assign values to "houses" and "students" 
		while(in.hasNext()) 
		{
			
			var type = in.next();
		
			if(type == null)
			{
				break;
			}
			if(type.startsWith("h"))
			{
				
				int id = in.nextInt();
				int duration = in.nextInt();
				double rating = in.nextDouble();
				House house = new House(id, duration, rating);
				houses.add(house);
				
			}
			else if(type.startsWith("s"))
			{
				
				int id = in.nextInt();
				String name = in.next();
				int duration = in.nextInt();
				double rating = in.nextDouble();
				students.put(new Student(id, name, duration, rating), false);
			}
			
	
		}
		int semester = 0;
		
		// while loop for each semester
		while(semester < 8)
		{
			for(Student s: students.keySet())
			{
				int duration = s.getDuration() - semester;
				if(!students.get(s) && duration > 0)
				{
					
					double threshold = s.getRating();

					for(House h: houses)
					{
						int houseDuration = h.getDuration() - semester;
						if(houseDuration == 0)
						{
							if(h.getRating() >= threshold)
							{
								
								h.changeDuration(duration);
								students.replace(s, true);
								break;
							}
						}
					}
				}
			}
			

			
			semester++;
		}
		
		//write homeless students to output file
		for(Student s: students.keySet())
		{
			if(!students.get(s))
			{
				out.println(s.name);
			}
		}
		

	}

}
