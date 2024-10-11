
public class TestThread extends Thread {
	// 2.1
	public TestThread(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(this.getName());
		}
	}

	public static void main(String[] args) {
		TestThread t = new TestThread("1-");
		TestThread t5 = new TestThread("5-");
		TestThread t4 = new TestThread("4-");
		TestThread t3 = new TestThread("3-");
		TestThread t2 = new TestThread("2-");

		t.start();
		t5.start();
		t4.start();
		t3.start();
		t2.start();
	}

}
// 2.2
// chaque thread s'execute de façon parallele
// c'est le systeme d'exploitation qui gere quel Thread s'excutea a quel moment
// donc apparition dans un ordre aléatoire