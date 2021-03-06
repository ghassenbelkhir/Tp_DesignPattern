package adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationAdapter<E> implements Iterator<E> {

	OldStyleList<E> myOldStyleList;
	Enumeration<E> elements;

	public EnumerationAdapter(OldStyleList<E> myOldStyleList) {
		this.myOldStyleList=myOldStyleList;
		elements=myOldStyleList.elements();
	}


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return elements.hasMoreElements();
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return  elements.nextElement();
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
