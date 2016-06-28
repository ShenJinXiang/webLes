public class OneObj {
	private static OneObj _obj = new OneObj();
	private OneObj() {}
	public static OneObj getObj() {
		return _obj;
	}
	public void doSomeThing() {
		System.out.println("hello~~");
	}

	public static void main(String[] args) {
		OneObj o1 = OneObj.getObj();
		OneObj o2 = OneObj.getObj();
		o1.doSomeThing();
		o2.doSomeThing();
		System.out.println(o1 == o2);
	}
}
