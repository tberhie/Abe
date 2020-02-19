import java.util.Scanner;
public class SphereVolume 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
			Scanner prompt = new Scanner(System.in);
		// print the purpose of the program
			System.out.println("This program calculates the volume of sphere by taking the diameter from the user ");
		// prompt user to enter diameter
			System.out.println("Enter the diameter of the sphere: ");
		// declare diam and read diameter
		double diam = prompt.nextDouble();
		double radius = diam / 2;
		// show radius
			System.out.println("The Diameter entered in radius is " + radius);
		// using the volume formula Math.pow calculate volume
		double volume = (4*Math.pow(radius,  3)*Math.PI)/3;
		// display volume of sphere
			System.out.println("The volume of the sphere is "+ volume + " cubic unit.");
		// Show program is ended
            System.out.println("Goodbye, program ended!");
	}

}
