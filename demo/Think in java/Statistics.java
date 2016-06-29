import java.util.*;

public class Statistics {

	public static void main(String[] args) {
		Random rand = new Random(47);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		final int num = 100000;
		for(int i = 0; i < num; i++) {
			int r = rand.nextInt(20);
			Integer freq = m.get(r);
			m.put(r, freq == null ? 1 : freq + 1);
		}
		System.out.println(m);
	}
}
