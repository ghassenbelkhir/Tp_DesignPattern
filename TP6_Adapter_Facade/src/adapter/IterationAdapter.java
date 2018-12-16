package adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IterationAdapter<T> implements Enumeration<T> {

	Iterator<T> myiterator;
	public IterationAdapter(Iterator<T> myiterator) {
		
		this.myiterator=myiterator;
		
	}
	
	
	@Override
	public boolean hasMoreElements() {
		// TODO Auto-generated method stub
		return myiterator.hasNext();
	}

	@Override
	public T nextElement() {
		// TODO Auto-generated method stub
		return myiterator.next();
	}

}
