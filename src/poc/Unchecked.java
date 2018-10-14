package poc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Unchecked {

	public static List<Object[]> getList() {

		// return castList(getNotSafeList()); // -> safe, no problem
		return getNotSafeList(); // -> unchecked conversion, it will crash at runtime
	}

	private static List<Object[]> castList(Collection<?> c) {

		List<Object[]> l = new ArrayList<>();

		if (c == null || c.isEmpty())
			return l;

		for (Object o : c) {

			if (isArray(o)) {
				l.add((Object[]) o);
			} else {
				l.add(new Object[] { o });
			}
		}

		return l;
	}

	private static boolean isArray(Object obj) {
		return obj != null && obj.getClass().isArray();
	}

	private static List getNotSafeList() {

		List a = new ArrayList();
		a.add(new BigInteger("1024"));
		a.add(new BigInteger("256"));
		a.add(new String[] { "4098", "256", null });
		return a;
	}
}
