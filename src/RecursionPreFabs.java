
/* RecursionPreFabs.java
 * Cameron Connell 
 * 4/17/19
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RecursionPreFabs extends Generator {
	public static String getPrefab()
	{
		switch (currentMethodType + currentInputType) {
			case "StringString":
				break;
		}
		return preparePrefab(new File("RecursionIntPreFabTemplate.txt"));
	}

	public static String preparePrefab(File F) {
		if (F.length() == 0) {
			System.out.println("File is empty");
			return "";
		}
		try
		{
			Scanner lookThrough = new Scanner(F);
			String writer = "";
			String startKey = randomPrefabKey();
			String stopkey = startKey + "*";
			while (lookThrough.next() != stopkey) {
				String temp = lookThrough.nextLine();
				if (temp.contains("#"))
				{
					String temp2 = "";
					for (int i = 0; i < temp.length(); i++) {
						if (temp.charAt(i) != '#') {
							temp2 += temp.charAt(i);
						} else {
							temp2 += parsePeice(temp.charAt(i + 1));
							i = i + 2;
						}

					}
					temp = temp2;
				}

				writer += temp + "\n";

			}

			return writer;
		}
			/*while (lookThrough.hasNext()) {
				String temp = lookThrough.nextLine();
				if (temp.contains("#"))
				{
					String temp2 = "";
					for (int i = 0; i < temp.length(); i++) {
						if (temp.charAt(i) != '#') {
							temp2 += temp.charAt(i);
						} else {
							temp2 += parsePeice(temp.charAt(i + 1));
							i = i + 2;
						}

					}
					temp = temp2;
				}

				writer += temp + "\n";

			}

			return writer;
		}*/
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String parsePeice(char c)
	{
		if (c == 'v')
		{
			return inputName;
		}
		if (c == 'n')
		{
			return methodName;
		}
		return "ERROR";
	}
	public static String randomPrefabKey()
	{
		String[] fabKeys = {"*1","*2"};
		return fabKeys[(int)(Math.random() * 1)];
	}
}
