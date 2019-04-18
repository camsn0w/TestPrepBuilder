
/* Generator.java
 * Cameron Connell 
 * 4/9/19
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Generator
{
		//public String fileName = "/RecursionPlate.txt";
		//public String fileName = "/home/camsn0w/Documents/Java-PrepGenerator/src/RecursionPlate.txt";
		public static String fileName = "input/RecursionPlate.txt";
		public static void main(String []args)
		{
			//Generator g = new Generator();
			//g.read();
			read();
		}

		public Generator()
		{

		}
		public static File read()
		{

				try {
					Scanner inputer = new Scanner(new File(fileName));
					//File f = new File(String.valueOf(inputer));

					while (inputer.hasNext()) {
						System.out.println(inputer.nextLine());

					}
					return new File(fileName);
				}
				catch (IOException e)
				{
					System.out.println("File not found");
				}
				return null;

		}




}
