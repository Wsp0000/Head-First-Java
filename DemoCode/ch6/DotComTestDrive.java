import java.util.*;
public class DotComTestDrive {
	/**
	 * //DotCom_test_code
 	 * @param args
	 */
	public static void main(String[] args){
		
		DotCom dot = new DotCom();
		
		ArrayList<String> locations = new ArrayList<String>();
		locations.add("B0");
		locations.add("C0");
		locations.add("D0");
		dot.setLocationCells(locations);
		
		String[] names = {"Go2.com"};
		dot.setName(names[0]);
		
		String userGuess = "B0";
		String result = dot.checkYourself(userGuess);
		
		userGuess = "C0";
		result = dot.checkYourself(userGuess);
		
		userGuess = "D0";
		result = dot.checkYourself(userGuess);
		
		
		String testResult = "failed";
		
		if (result.equals("kill") ){
			
			testResult = "passed";
			
		}
		System.out.println(testResult);
	}
}