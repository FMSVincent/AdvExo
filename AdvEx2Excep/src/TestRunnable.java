
public class TestRunnable implements Runnable{

	// 2.2
	
	@Override
	public void run() {
		for (int i = 0; i < 1; i++) {
			System.out.println("!*!");
			System.out.println("\"**\"");
			System.out.println("#***#");
			System.out.println("$****$");
			System.out.println("%*****%");
			System.out.println("&******&");
			System.out.println("'*******'");
			System.out.println("(*******(");
			System.out.println(")********)");
			System.out.println("***********");
		}
	}
	
	public static void main(String[] args) {
		 Thread thread = new Thread(new TestRunnable());
		 thread.start();
		 
	}

}
