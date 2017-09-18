//SimpleDotCom_test_code
public class SimpleDotCom {
	
	int[] locationCells;// = new int[3];
	int numOfHits = 0;
	
		public void setLocationCells(int[] locs){
		locationCells = locs;
	}
	
	public String checkYourself(String stringGuess){
		int guess = Integer.parseInt(stringGuess);
		
		String result = "miss";
		
		for (int cell : locationCells){
			if (guess == cell){
				result = "hit";
				numOfHits++;
				break;
			}
		}//out of the loop
		
		if (numOfHits == locationCells.length){
			result = "kill";
		}//end if
		
		System.out.println(result);
		
		return result;
	}// end method
}// end class