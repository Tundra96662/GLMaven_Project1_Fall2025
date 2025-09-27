import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyHashMap <T> implements Iterable<T>{
    private ArrayList<GenericQueue<T>> map;
    private int size;

    public MyHashMap(String key, T value){
        map = new ArrayList<>(10);
        //Arraylist with 10 items being null
        for (int i = 0; i < 10; i++) {
            map.add(null);
        }
        put(key, value);
    }

    public void put(String key, T value){
        int hashCode = key.hashCode();
        int hashValue = hashCode & 9;

        GenericQueue<T> queue = map.get(hashValue);

        if (queue == null) {
            queue = new GenericQueue<>(value);
            //First node
            queue.getHead().code = hashCode;
            map.set(hashValue, queue);
            size++;
        } else {//Exists
            queue.add(value, hashCode);
            size++;
        }

    }

    //If key in hash map
    public boolean contains(String key) {
        int hashCode = key.hashCode();
        int hashValue = hashCode & 9;

        GenericQueue<T> queue = map.get(hashValue);
        if (queue == null) {
            return false;
        }

        GenericList<T>.Node<T> curr = queue.getHead();
        while (curr != null) {
            if (curr.code == hashCode) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    //Get value by key
    public T get(String key) {
        int  hashCode = key.hashCode();
        int hashValue = hashCode & 9;

        GenericQueue<T> queue = map.get(hashValue);
        if (queue == null) {
            return null;
        }

        //Finding matching hash code
        GenericList<T>.Node<T> curr = queue.getHead();
        while (curr != null) {
            if (curr.code == hashCode) {
                return  curr.data;
            }
            curr = curr.next;
        }
        return null;
    }


    public int size() {
        return size;
    }

    //is map empty
    public boolean isEmpty() {
        return size == 0;
    }

    //Replace a val for a key
    public T replace(String key, T value){
        int hashCode = key.hashCode();
        int hashValue = hashCode & 9;

        GenericQueue<T> queue = map.get(hashValue);
        if (queue == null) {
            return null;
        }
        //Look for matching hash code
        GenericList<T>.Node<T> curr = queue.getHead();
        while (curr != null) {
            if (curr.code == hashCode) {
                T oldValue = curr.data;
                curr.data = value;

                return oldValue;
            }
            curr = curr.next;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currBucket = 0;
            private GenericList<T>.Node<T> currNode = null;
            {
                findNextNode();
            }
            private void findNextNode() {
                if (currNode != null) {
                    currNode = currNode.next;
                }
                while (currNode == null && currBucket < 10) {
                    if (map.get(currBucket) != null) {
                        currNode = map.get(currBucket).getHead();
                    }
                    currBucket++;
                }
            }
            @Override
            public boolean hasNext() {
                return currNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = currNode.data;
                findNextNode();
                return data;
            }
        };
    }

}











