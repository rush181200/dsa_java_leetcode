class Solution {
    public boolean areNumbersAscending(String s) {
       String[] arrOfStr = s.split(" ");
		int prevInt = -1;
		
		for(String str : arrOfStr)
		{
			if(Character.isDigit(str.charAt(0)))
			{
				if(prevInt < Integer.parseInt(str))
				{
					prevInt = Integer.parseInt(str);
				}
				else
				{
					return false;
				}
			}
		}
		
		return true;
    }
}