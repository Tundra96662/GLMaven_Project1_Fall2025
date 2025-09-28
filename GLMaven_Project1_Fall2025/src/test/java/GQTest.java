import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.ArrayList;

class GenericQueueTests {

	GenericQueue<Integer> queue = new GenericQueue<>(1);
	
	//Extension
	@Test
	void constructorTests(){
		//Does param constructor set the values correctly.
		assertEquals(1, queue.getHead().data);
		
		assertEquals(1, queue.getLength());
	}
	
	@Test
	void addTests(){
		//
		//ADD(T data)
		//

		queue.add(2);
		
		assertEquals(2, queue.getLength());
		
		// 1 - 2
		//ADDING DOESNT AFFECT HEAD
		assertEquals(1, queue.getHead().data);
		
		//Testing add(T data, int code)
		queue.add(3, 25);
		queue.add(4, 50);

		// 1 - 2 - 3 - 4
		assertEquals(4, queue.getLength());
	

		//Temp test w/ an empty queue (Uses delete)
		GenericQueue<Integer> temp = new GenericQueue<>(0);
		temp.delete();

		//Test that the queue is empty
		assertEquals(0, temp.getLength());
		assertEquals(null, temp.getHead());

		temp.add(100);

		assertEquals(1, temp.getLength());
		assertEquals(100, temp.getHead().data);

	}
	
	@Test
	void deleteTests(){

		queue.add(2);
		queue.add(3);
		// 1 - 2 - 3
	
		assertEquals(1, queue.delete());
		// 2 - 3

		assertEquals(2, queue.getLength());
		assertEquals(2, queue.getHead().data);

		assertEquals(2, queue.delete());
		// 3

		assertEquals(1, queue.getLength());
		assertEquals(3, queue.getHead().data);

		assertEquals(3, queue.delete());
		// EMPTY

		assertEquals(0, queue.getLength());
		assertEquals(null, queue.getHead());
	}
	
	@Test
	void enqueueTests(){ //Equivalent to add

		queue.add(2);
		
		assertEquals(2, queue.getLength());
		
		// 1 - 2
		//ADDING DOESNT AFFECT HEAD
		assertEquals(1, queue.getHead().data);
		
		//Testing add(T data, int code)
		queue.add(3, 25);
		queue.add(4, 50);

		// 1 - 2 - 3 - 4
		assertEquals(4, queue.getLength());
	

		//Temp test w/ an empty queue (Uses delete)
		GenericQueue<Integer> temp = new GenericQueue<>(0);
		temp.delete();

		//Test that the queue is empty
		assertEquals(0, temp.getLength());
		assertEquals(null, temp.getHead());

		temp.add(100);

		assertEquals(1, temp.getLength());
		assertEquals(100, temp.getHead().data);
	}

	@Test
	void dequeueTests(){ //Equivalent to remove

		queue.add(2);
		queue.add(3);
		// 1 - 2 - 3
	
		assertEquals(1, queue.delete());
		// 2 - 3

		assertEquals(2, queue.getLength());
		assertEquals(2, queue.getHead().data);

		assertEquals(2, queue.delete());
		// 3

		assertEquals(1, queue.getLength());
		assertEquals(3, queue.getHead().data);

		assertEquals(3, queue.delete());
		// EMPTY

		assertEquals(0, queue.getLength());
		assertEquals(null, queue.getHead());
	}

	@Test
	void forEachITests(){
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		
		int i = 0;
		for(Integer num : queue){
			System.out.println(num);
			assertEquals(num, queue.get(i));

			i++;
		}
	}

	@Test
	void iteratorTests(){

		queue.add(2);
		queue.add(3);
		//1 - 2 - 3

		Iterator<Integer> iterator = queue.iterator();

		assertEquals(true, iterator.hasNext());
		assertEquals(1, iterator.next());
		assertEquals(2, iterator.next());
		
		assertEquals(false, iterator.hasNext());
		assertEquals(3, iterator.next());

		assertEquals(null, iterator.next());
		assertEquals(false, iterator.hasNext());
	}

	@Test
	void descendingIteratorTests(){
		queue.add(2);
		queue.add(3);
		//1 - 2 - 3

		Iterator<Integer> iterator = queue.descendingIterator();

		assertEquals(true, iterator.hasNext());
		assertEquals(3, iterator.next());
		assertEquals(2, iterator.next());
		
		assertEquals(false, iterator.hasNext());
		assertEquals(1, iterator.next());
		
		assertEquals(null, iterator.next());
		assertEquals(false, iterator.hasNext());
	}

	//BASE FUNCTION
	@Test
	void dumpListTests(){
		queue.add(2);
		queue.add(3);

		ArrayList<Integer> compare = new ArrayList<Integer>();
		compare.add(1);
		compare.add(2);
		compare.add(3);

		assertEquals(compare, queue.dumpList());
	}

	@Test
	void getTests(){
		queue.add(2);
		queue.add(3);

		assertEquals(2, queue.get(1));
		
		//Remove head and check get again

		queue.delete();

		assertEquals(3, queue.get(1));

	}
	@Test
	void setTests(){
		queue.add(12);
		queue.add(13);
		
		assertEquals(12, queue.set(1,2));
		assertEquals(13, queue.set(2,3));
	}
	
	@Test
	void getLengthTests(){
		assertEquals(1, queue.getLength());

		queue.add(2);
		assertEquals(2, queue.getLength());

		queue.delete();
		assertEquals(1, queue.getLength());
	}
	
	@Test
	void setLengthTests(){
		queue.setLength(100);
		assertEquals(100, queue.getLength());

		queue.add(2);
		assertEquals(101, queue.getLength());
	}
	
	@Test
	void getHeadTests(){
		assertEquals(1, queue.getHead().data);

		queue.add(2);
		queue.add(3);
		queue.delete();

		assertEquals(2, queue.getHead().data);

		queue.delete();

		assertEquals(3, queue.getHead().data);

		queue.delete();
		
		assertEquals(null, queue.getHead());
	
	}
	
	@Test
	void setHeadTests(){
	
		queue.add(2);
		queue.add(3);
		GenericList<Integer>.Node<Integer> head = queue.getHead();

		head = head.next;

		queue.setHead(head);
		assertEquals(2, queue.getHead().data);
	}
	
}
