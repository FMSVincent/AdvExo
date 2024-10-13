
public class TestRunnable implements Runnable{

	// 2.2
	
	@Override
	public void run() {
        String[] shapes = {
                "!*!",
                "\"**\"",
                "#***#",
                "$****$",
                "%*****%",
                "&******&",
                "'*******'",
                "(*******(",
                ")********)",
                "***********"
            };
        
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
		}
	}
	
	public static void main(String[] args) {
		 Thread thread = new Thread(new TestRunnable());
		 thread.start();
		 
	}

}
