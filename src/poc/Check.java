package poc;

import java.util.*;

public class Check {

	public static void main(String[] args) {

		List<Object[]> lo = Unchecked.getList();
		lo.stream().forEach(x -> System.out.println("-> " + x[0].toString()));
	}
}
