package exam_questions;
/**
 * Q7 from the Java exam paper 2015
 * @author lucieburgess
 * @param <T> a generic type of which the list can be composed
 */

public class LinkedList<T> {
	
	private T value;
	private LinkedList<T> next;
	private int size;

	public LinkedList() {
		this.value = null;
		this.next = null;
		this.size = 0;
	}

	public void add(T item) {// adds an item to the end of the list
		if (item == null) {
			throw new IllegalArgumentException("this list does not accept null elements");
		}
	
		if (this.size == 0) { // list is empty, add here
			value = item;
			
		} else if (next == null) { // if we are at end of list
			LinkedList<T> newList  = new LinkedList<>();
			newList.add(item);
			next = newList;	
		} else {
			next.add(item);
		}
		size++;
	}
	
	public boolean contains(T element) {
		boolean result = false;
		for (LinkedList<T> list = this.next; list != null; list = list.next) {
			if(list.value == element) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	public LinkedList<T> deDup() {
		LinkedList<T> x = new LinkedList<>();
		for (LinkedList<T> ll = this.next; ll != null; ll = ll.next) { // iterates over the list until it reaches the null head node
			if (!x.contains(ll.value)) {
				x.add(ll.value);
			}
		}
		return x;
	}
		
}
