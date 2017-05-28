import java.util.*;

/*
 * Tester class comparing LinkedListBasedList and ArrayBasedList
 * @author Sebastian Kleinerman
 */

public class ListComparison {

	public static void main(String[] args) {

		ArrayBasedList<String> array = new ArrayBasedList<String>();
		LinkedListBasedList<String> list = new LinkedListBasedList<String>();

		Date start = new Date();

		// code that you are timing
		fillList(list, array, 1000000);


		Date end = new Date();
		long elapsedTime = end.getTime() - start.getTime();
	}

	@SuppressWarnings("unchecked")
	public static void fillList(@SuppressWarnings("rawtypes") LinkedListBasedList list, @SuppressWarnings("rawtypes") ArrayBasedList array, int count) {
		for (int i = 0; i < count; i++) {
			array.add("");
			list.add("");
		}
	}
}
