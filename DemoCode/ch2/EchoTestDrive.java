public class EchoTestDrive {
	public static void main (String[] args){
		Echo e1 = new Echo();
		Echo e2 = e1;
		int x = 0;
		
		while (x < 4) {
			System.out.println("just start while loop while x="+x+" e1.count="+e1.count+" e2.count="+e2.count);//test
			e1.hello();
			e1.count = e1.count + 1;
			if (x > 0){
				e2.count = e2.count + 1;
			}
			if (x > 1){
				e2.count = e2.count + e1.count;
			}
			x = x + 1;
			System.out.println("just end   while loop while x="+x+" e1.count="+e1.count+" e2.count="+e2.count);//test
			System.out.println();//test
		}
			System.out.println("result e2.count:"+e2.count);
	}
}