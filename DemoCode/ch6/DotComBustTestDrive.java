//DotComBust_test_code
import java.util.*;
public class DotComBustTestDrive {
	
	public static void main(String[] args){
		
		DotComBust bust = new DotComBust();
		
		bust.setUpGame();
		
		GameHelper helper = new GameHelper();
		//bust.checkUserGuess(helper.getUserInput("test and waiting for user guess"));
		
		//bust.finishGame();
		bust.startPlaying();
		/*
		String testResult = "failed";
		
		if (result.equals("hit") ){
			
			testResult = "passed";
			
		}
		System.out.println(testResult);
		*/
	}
}