import java.util.*;

/**
 * //DotComBust_real_code
 */
class DotComBust {
	GameHelper helper = new GameHelper();
	ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	int numOfGuesses = 0;
	
	public void setUpGame(){
		//first make some dot coms and give them names and locations
		DotCom dotCom1 = new DotCom();
		dotCom1.setName("Go2.com");
		dotComsList.add(dotCom1);
		//dotCom1.setLocationCells(helper.placeDotCom(3));
		
		DotCom dotCom2 = new DotCom();
		dotCom2.setName("Pets.com");
		dotComsList.add(dotCom2);
		//dotCom2.setLocationCells(helper.placeDotCom(3));
		
		DotCom dotCom3 = new DotCom();
		dotCom3.setName("AskMe.com");
		dotComsList.add(dotCom3);
		//dotCom3.setLocationCells(helper.placeDotCom(3));
		
		System.out.println("DotComBust Game setUp!");
		System.out.println("Your goal is input guess to sink the dot coms! ");
		System.out.println("Try to sink all dotComs in the fewest number of guesses!! ");
		
		for (DotCom dotComToSet : dotComsList){
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}// close for loop
	}// close setUpGame method
	public void startPlaying(){
		
		while( !dotComsList.isEmpty() ){
			String userGuessInput = helper.getUserInput("waiting for user guess");
			checkUserGuess(userGuessInput);
		}// close while
		finishGame();
	}// close startPlaying method
	public void checkUserGuess(String userGuess){
		//
		numOfGuesses++;
		String result = "miss";
		for(DotCom aDotCom : dotComsList){
			String checkResult = aDotCom.checkYourself(userGuess);
			if ( checkResult.equals("hit") ){
				result = "hit";
				break;
			}
			if ( checkResult.equals("kill") ){
				result = "kill";
				dotComsList.remove(aDotCom);
				break; //wsp mistake
			}
		} // close for
		System.out.println(result);
	} // close method
	public void finishGame(){
		System.out.printf("game over! had guess %d times \n",numOfGuesses);
		if (numOfGuesses < 20 ){
			System.out.println("GJ!");
		} else {
			System.out.println("unfortunely!");
		}
	} // close method
	public static void main(String[] args){
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
} // close class