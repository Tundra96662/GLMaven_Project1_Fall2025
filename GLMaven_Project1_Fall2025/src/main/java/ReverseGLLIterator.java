import java.util.Iterator;
import java.util.ArrayList;
public class ReverseGLLIterator<E> implements Iterator<E> {
	//Carbon copy to GLLIterator but reverse. A note for both
	//is that it calls for next to be I (This is only mentioned
//for GLLIterator), however the code doesnt compile if so as
	//I was never defined anywhere in the code, So im replacing it
	//with E.
	
	//I just realized that using the dumpedList was stupid as I could
	//just get the class instead. Good for when the linked list gets
	//altered in any way.
	
	GenericList<E> list;
	
	int i = -1;

	public ReverseGLLIterator(GenericList<E> genList) {
		list = genList;


		i = list.getLength() - 1; //Set to tail index
	}


	@Override
	public boolean hasNext() {	
		return ( (i - 1) >= 0 )? true : false;
	}

	@Override
	public E next() {
		E CURRENTDATA = list.get(i);
		i--;	
		return CURRENTDATA;
	}
}
