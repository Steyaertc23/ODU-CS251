import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static <T extends Comparable<T>> int doSomething(T[] arr, T elem) {
		int count = 0;
		for (T t : arr) {
			if (t.compareTo(elem) <= 0)
				++count;
		}
		return count;
	}
	
	public static BigDecimal sum(List<? extends Number> list) {
		double sum = 0.0;
		
		for (Number n : list) {
			sum += n.doubleValue();
		}
		
		return new BigDecimal(sum);
	}
	
	public static BigDecimal product(List<? extends Number> list) {
		double product = 1;
		
		for (Number n : list) {
			product *= n.doubleValue();
		}
		
		return new BigDecimal(product);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"hello", "world", "this", "is", "a", "test"};
		System.out.println(doSomething(test, "hi"));
		
		List<Integer> intArr = Collections.nCopies(2, 100);
		
		System.out.println("Sum of integers: " + sum(intArr));
		
		System.out.println("Product of integers: " + product(intArr));
		
		List<Double> doubleArr = new ArrayList<>();
		
		for (int i = 1; i <= 100; i++)
			doubleArr.add(Double.valueOf(i));
		
		System.out.println("Sum of doubles: " + sum(doubleArr));
		
		System.out.println("Product of doubles: " + product(doubleArr));
	}

}
