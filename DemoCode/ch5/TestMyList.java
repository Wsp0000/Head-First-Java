public class TestMyList {
	
	public static void main(String[] args){
		String[] myList = new String[2];
		
		String a = new String("whoohoo");
		myList[0] = a;
		System.out.println("a="+a.toString());
		System.out.println("myList[0]="+myList[0].toString());
		String b = new String("Frog");
		myList[1] = b;
		System.out.println("b="+b.toString());
		System.out.println("myList[1]="+myList[1].toString());
		
		int theSize = myList.length;
		System.out.println("theSize="+theSize);
		
		Object o = myList[0];
		System.out.println("o="+o.toString());
		
		String[] myListAfterRemoveOne = {myList[0]};
		System.out.println("myListAfterRemoveOne[0]="+myListAfterRemoveOne[0].toString());
	}
}