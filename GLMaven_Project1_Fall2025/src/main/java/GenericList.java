import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> {
	
	private Node<T> head;
	private int length;

	public class Node<T>{
		T data;
		int code;
		Node<T> next;
	}

	public void print(){
		if (head == null){
			System.out.println("Empty List");
			return;
		}
		
		Node<T> curr = head;
		while(curr != null){

			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	public abstract void add(T data);

	public abstract T delete();

	public ArrayList<T> dumpList(){

		ArrayList<T> retList = new ArrayList<T>();

		if (head != null){

			Node<T> curr = head;
			while(curr != null){

				retList.add(curr.data);
				curr = curr.next;
			}

		}

		return retList;
	}

	public T get(int index){

		Node<T> currNode = head;
		int i = 0;
		while (currNode != null){
			//Just searches through the whole list, incrementing i till both i and index are the same number
			if (i == index) return currNode.data;
			i++;
			currNode = currNode.next;
		}

		return null;
	}


	public T set(int index, T element){ 				
		Node<T> currNode = head;
		int i = 0;
		while (currNode != null){ //Same code as get but it sets the data of that node.
			if (i == index) { 
				
				T returnData = currNode.data;
				currNode.data = element;

				return returnData;
			}
			i++;
			currNode = currNode.next;
		}

		return null;
	}

	public int getLength(){
		return length;
	}

	public void setLength(int newLength){
		length = newLength;
	}

	public Node<T> getHead(){
		return head;
	}

	public void setHead(Node<T> newHead){
		head = newHead;
	}

	public Iterator<T> iterator(){

		return new GLLIterator<>(head);
  	}

	public Iterator<T> descendingIterator(){

		return new ReverseGLLIterator<>(this);
	}
}
