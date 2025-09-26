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


	public T set(int index, T element){ //I mightve messed this up
				
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
                return new Iterator<T>(){
                        Node<T> curr = head;

                        @Ovverride
                        public boolean hasNext(){
                                return (curr.next != null)? true : false ;
                        }

                        @Override
                        public Node<T> next(){
                                curr = curr.next;
                                return curr.data;
                        }

                }
        }

        public Iterator<T> descendingIterator(){
                ArrayList<T> list = dumpList();
                return new Iterator<T>(){
                                int i = list.size() - 1;

                                @Override
                                public boolean hasNext(){
                                        return (i-1 >= 0)? true : false;
                                }

                                @Override
                                public T next(){
                                        i--;
                                        if (i >= 0)
                                                return get(i);

                                        return null;

                                }
                }
        }
}
