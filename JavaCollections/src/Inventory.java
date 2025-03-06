import java.util.Iterator;
class Inventory implements Iterable<Bicycle> {
	
	private Bicycle[] arr;
	
	Inventory(Bicycle[] arr){
	this.arr = arr;
	}
	
	public Iterator<Bicycle> iterator() {
		Iterator<Bicycle> it = new Iterator<Bicycle>() {
				private int currIndex = 0;
				public boolean hasNext() {
						return currIndex < arr.length && arr[currIndex] != null;
				}
				public Bicycle next() {
					return arr[currIndex++];
				}
				public void remove() {
					throw new UnsupportedOperationException();
				}
		};
		return it;
	}
}