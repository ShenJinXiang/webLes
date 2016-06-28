public class Outer {
	class Inner{
		private int id = 1;
		public Inner(int val) {
			this.id = val;
		}
		public int getVal() {
			return this.id;
		}
	}

	public Inner getInner(int val) {
		return new Inner(val);
	}

	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.getInner(123);
		System.out.println("inner: " + in.getVal());
	}
}
