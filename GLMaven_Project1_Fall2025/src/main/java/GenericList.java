import java.util.ArrayList;

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
			if (i == index) return currNode.data;
			i++;
			currNode = currNode.next;
		}

		return null;
	}


	public T set(int index, T element){ //I mightve fucked this one up
				
		Node<T> currNode = head;
		int i = 0;
		while (currNode != null){
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

	public int getLength();
	public void setLength();

	public Node<T> getHead();
	public void setHead();

	public Iterator<T> descendingIterator();



}
