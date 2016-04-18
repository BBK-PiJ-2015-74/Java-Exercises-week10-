
public class DoubleLinkedList {

	    private Object value;
	    private DoubleLinkedList nextList;
	    private DoubleLinkedList prevList;

	    public DoubleLinkedList(Object value) {
	        this.value = value;
	        this.nextList = null;
	        this.prevList = null;
	    }

	    public Object getValue() {
	        return value;
	    }

	    public DoubleLinkedList getNext() {
	        return nextList;
	    }

	    public DoubleLinkedList getPrev() {
	        return prevList;
	    }

	    public void setNext(DoubleLinkedList next) {
	        this.nextList = next;
	    }
	    
	    public void setPrev(DoubleLinkedList previous) {
	        this.prevList = previous;
	    }

	    //add another element(list) to the end of the list

	    public void add(DoubleLinkedList newList) {
	        if (this.nextList == null) { // if we are at end of list
	            this.nextList = newList;  // sets pointer at end of list to newList
	            newList.prevList = this;  // sets pointer prevList of listToBeAdded to be this list
	        } else {
	            this.nextList.add(newList);
	        }
	    }

	    //delete a node(list) from the list

	    public boolean delete(DoubleLinkedList node) {

	        if (this.nextList == null) {
	            //we are at end the end of the list, so nothing to remove
	            return false;
	        } else if (this.nextList.value.equals(node.value)) {
	            //we found it...it is the next one...
	            //now link this patient to the one after the next
	            this.nextList = nextList.nextList;
	            nextList.prevList = this;
	            return true;
	        } else {
	            return this.nextList.delete(node);
	        }

	    }
	}