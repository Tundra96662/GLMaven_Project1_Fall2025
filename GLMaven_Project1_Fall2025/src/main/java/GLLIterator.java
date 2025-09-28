import java.util.Iterator;

public class GLLIterator<E> implements Iterator<E> {
	
	GenericList<E>.Node<E> curr;

	public GLLIterator(GenericList<E>.Node<E> head){
		curr = head;
	}
	
	public boolean hasNext(){
		return curr != null;
      	}

      	public E next(){
		if (curr == null)
			return null;

	        E CURRENTDATA = curr.data;
		curr = curr.next;
		return CURRENTDATA;
      	}
}
