

public class GenericQueue<T> extends GenericList<T>{
	private Node<T> tail;

	public GenericQueue(T newData){
		//First node - y
        Node<T> firstNode = new Node<>();
        firstNode.data = newData;
        firstNode.next = null;

        //head and tail point to first node
        setHead(firstNode);
        tail = firstNode;
        setLength(1);

	}

    @Override
	public void add(T data){
	    Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.next = null;

        if (getHead() == null) {
            setHead(newNode);
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength() + 1);
	}

    public void add(T data, int code) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.code = code;
        newNode.next = null;

        if (getHead() == null) {
            setHead(newNode);
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength() + 1);

    }

    @Override
	public T delete(){
        if (getHead() == null) {
            return null;
        }
        //Remove current head node
        T deletedData = getHead().data;
        setHead(getHead().next);
        setLength(getLength() -1);

        if (getHead() == null) {
            tail = null;
        }
		return deletedData;
	}


	public void enqueue(T data) {
            add(data);
	}

    public T dequeue(){
       return delete();
    }

}
