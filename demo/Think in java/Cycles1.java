interface Cycle {
	void run();
}

interface CycleFactory {
	Cycle getCycle();
}

class Unicycle implements Cycle {
	private Unicycle() {}
	public void run() {
		System.out.println("unicycle running~~~");
	}
	public static CycleFactory factory() {
		return new CycleFactory() {
			public Cycle getCycle() {
				return new Unicycle();
			}
		};
	}
}

class Bicycle implements Cycle {
	private Bicycle() {}
	public void run() {
		System.out.println("bicycle running~~~");
	}
	public static CycleFactory factory() {
		return new CycleFactory() {
			public Cycle getCycle() {
				return new Bicycle();
			}
		};
	}
}

class Tricycle implements Cycle {
	private Tricycle() {}
	public void run() {
		System.out.println("tricycle running~~~");
	}
	public static CycleFactory factory() {
		return new CycleFactory() {
			public Cycle getCycle() {
				return new Tricycle();
			}
		};
	}
}

public class Cycles1 {
	
	private static void takeCycle(CycleFactory fct) {
		Cycle cycle = fct.getCycle();
		cycle.run();
	}

	public static void main(String[] args) {
		takeCycle(Unicycle.factory());
		takeCycle(Bicycle.factory());
		takeCycle(Tricycle.factory());
	}
}
