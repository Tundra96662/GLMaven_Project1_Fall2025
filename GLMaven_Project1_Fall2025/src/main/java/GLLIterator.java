import java.util.Iterator;

public class GLLIterator<E> implements Iterator<E> {
	
	GenericList<E>.Node<E> curr;

	public GLLIterator(GenericList<E>.Node<E> head){
		curr = head;
	}
	
	public boolean hasNext(){
       		return (curr.next != null)? true : false ;
      	}

      	public E next(){
	        E CURRENTDATA = curr.data;
		curr = curr.next;
		return CURRENTDATA;
      	}





	//The code below is pointless I believe, I just need to copy and paste from general list I think.
	/*
	GenericList<E>.Node<E> curNode;
	@Override
	public boolean hasNext(){
		return false;
	}

	@Override
	public E next(){

		return null;
	}
	*/

}
