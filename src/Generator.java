/* Generator.java
 * Cameron Connell 
 * 4/9/19
 */

import java.io.*;
import java.util.Scanner;

public class Generator
{
		//public String fileName = "/RecursionPlate.txt";
		//public String fileName = "/home/camsn0w/Documents/Java-PrepGenerator/src/RecursionPlate.txt";
		public static String fileName = "RecursionPlate.txt";
		public static String currentMethodType = null;
		public static String currentInputType = null;
		public static String methodName = null;
		public static String inputName = null;


		public static void main(String []args)
		{
			//Generator g = new Generator();

			randomizer(read(fileName));
			System.out.println(RecursionPreFabs.getPrefab());



			/*try {
				Scanner filez = new Scanner(temp);
				while (filez.hasNext())
				{
					System.out.println(filez.nextLine());
				}
			}
			catch (IOException e)
			{
				System.out.println("Na");
			}*/

		}


		public static File read(String fileName)
		{

				try {
					Scanner inputer = new Scanner(new File(fileName));
					//File f = new File(String.valueOf(inputer));

					/*while (inputer.hasNext()) {
						System.out.println(inputer.nextLine());

					}*/
					//File f = new File(fileName);
					return new File(fileName);
				}
				catch (IOException e)
				{
					System.out.println("File not found");
				}
				return null;

		}

		public static void randomizer(File F)
		{
			if (F.length() == 0)
			{
				System.out.println("File is empty");
				return;
			}
			try
			{
				Scanner lookThrough = new Scanner(F);
				BufferedWriter writer = new BufferedWriter(new FileWriter("newestOutput.txt"));
				boolean insert = false;
				while (lookThrough.hasNext())
				{
					String temp = lookThrough.nextLine();

					if(temp.contains("#"))
					{
						String temp2 = "";
						for (int i = 0; i < temp.length(); i++)
						{
							if (temp.charAt(i) != '#')
							{
								temp2 += temp.charAt(i);
							}
							else
							{
								temp2 += chunkReplace(temp.charAt(i+1));
								i = i + 2;
							}

						}
						temp = temp2;


					}

					writer.write(temp + "\n");
					if(temp.contains("{") && !temp.contains("class"))
					{
						writer.write(RecursionPreFabs.getPrefab());

					}


				}
				writer.close();
			}
			catch (IOException e)
			{
				System.out.println("File not found during randomizer function");
			}
		}
		private static String chunkReplace(char s)
		{
			switch (s)
			{
				case 'n':
				String temp = randomNames();
				if(methodName == null)
				{
					methodName = temp;
					return temp;
				}
				else if(inputName == null)
				{
					inputName = temp;
					return temp;
				}

				case 't':
					String temp2 = randomTypes();
					if(currentMethodType == null)
					{
						currentMethodType = temp2;
						return temp2;
					}
					else if(currentInputType == null)
					{
						currentInputType = temp2;
						return temp2;
					}


			}
			return "ERROR";
		}
		private static String randomNames()
		{
			if(methodName == null)
			{
				return randomMethodName();
			}
			return randomVarName();

			/*String[] names = {"bleeper","munger","thingy"};

			return names[(int)(Math.random() * 2)];*/
		}
		private static String randomMethodName()
		{
			try
			{
				Scanner input = new Scanner(new File("VerbList.txt"));
				int wordNum = (int)(Math.random() * 1000) + 1;
				String word = "";
				for (int i = 0; i <=wordNum ; i++)
				{
					String temp = input.nextLine();
					if(i == wordNum)
					{
						word = temp;
					}
				}
				return word;
			}
			catch (FileNotFoundException e)
			{
				System.out.println("VerbList not found");
			}
			return null;
		}
		//TODO: Change randomVarName() to create method calls to the generated methods
		//TODO: And add them into the Runner.java file
		private static String randomVarName()
		{
			try
			{
				Scanner input = new Scanner(new File("NounList.txt"));
				int wordNum = (int)(Math.random() * 1000) + 1;
				String word = "";
				for (int i = 0; i <=wordNum ; i++)
				{
					String temp = input.nextLine();
					if(i == wordNum)
					{
						word = temp;
					}
				}
				return word;
			}
			catch (FileNotFoundException e)
			{
				System.out.println("NounList not found");
			}
			return null;
		}
		private static String randomTypes()
		{
			String[] types = {"String","int","double"};
			return types[(int)(Math.random() * 2)];
		}


}
