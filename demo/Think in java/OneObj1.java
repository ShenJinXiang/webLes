public class OneObj1 {
	private static OneObj1 _obj;

	private OneObj1(){}

	public static OneObj1 getObj() {
		if(_obj == null) {
			_obj = new OneObj1();
		}
		return _obj;
	}

	public void doSomeThing() {
		System.out.println("HELLO~~~");
	}

	public static void main(String[] args) {
		OneObj1 o1 = OneObj1.getObj();
		OneObj1 o2 = OneObj1.getObj();
		o1.doSomeThing();
		o2.doSomeThing();
		System.out.println(o1 == o2);
	}
}
