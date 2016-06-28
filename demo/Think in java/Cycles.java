interface Cycle{
	void run();
}

class Unicycle implements Cycle {
	public void run() {
		System.out.println("unicycle running~~~");
	}
}

class Bicycle implements Cycle {
	public void run() {
		System.out.println("bicycle running~~~");
	}
}

class Tricycle implements Cycle {
	public void run() {
		System.out.println("tricycle running~~~");
	}
}

interface CycleFactory {
	Cycle getCycle();
}

class UnicycleFactory implements CycleFactory {
	public Cycle getCycle() {
		return new Unicycle();
	}
}

class BicycleFactory implements CycleFactory {
	public Cycle getCycle() {
		return new Bicycle();
	}
}

class TricycleFacotry implements CycleFactory {
	public Cycle getCycle() {
		return new Tricycle();
	}
}

public class Cycles {

	private static void takeCycle(CycleFactory fct) {
		Cycle cycle = fct.getCycle();
		cycle.run();
	}

	public static void main(String[] args) {
		takeCycle(new UnicycleFactory());
		takeCycle(new BicycleFactory());
		takeCycle(new TricycleFacotry());
	}
}
