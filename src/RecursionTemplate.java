
/* RecursionTemplate.java
 * Cameron Connell 
 * 4/9/19
 */

public class RecursionTemplate
{
	public static void main(String[]args)
	{
		System.out.println(munge("Cameron"));

	}

	public static String munge(String s)
	{
		if(s.length() < 2 || s.length() > 10)
		{
			return s;
		}
		String temp = s.charAt(0) + "";
		s = temp + (s + s.charAt(s.length()-1));

		return munge(s);
	}


}
