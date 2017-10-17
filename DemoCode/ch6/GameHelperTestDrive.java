//DotComBust_test_code
import java.util.*;
public class GameHelperTestDrive {
	
	public static void main(String[] args){
		
		GameHelper helper = new GameHelper();
		
		//ArrayList<String> locationOfArrayList = helper.placeDotCom(3);
		//System.out.println(locationOfArrayList.toString());
		
		helper.placeDotCom(3);
		
		String testUserInput = helper.getUserInput("getTestUserInput please Iuput \"F0\" or \"f0\""); 
		//input f0 or F0 then result should be f0
		
		String testResult = "failed";
		
		if (testUserInput.equals("f0") ){
			
			testResult = "passed";
			
		}
		System.out.println(testResult);
		
	}
}