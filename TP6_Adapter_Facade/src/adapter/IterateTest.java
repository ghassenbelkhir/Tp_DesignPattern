package adapter;
import java.util.*;

public class IterateTest
{
	public static void main(String[] args) {

		OldStyleList<String> v = new OldStyleList<String>();
		v.add("one");		
		v.add("two");		
		v.add("three");		
		v.add("four");		

		// the recommended technique ....		
		
		Iterator i = new EnumerationAdapter<>(v);

		System.out.println("Iteration ..... the \"new-style\" way");
		while (i.hasNext())
			System.out.println(i.next());
		
		List<String> vv = new ArrayList<String>();
		vv.add("one");		
		vv.add("two");		
		vv.add("three");		
		vv.add("four");
		Enumeration e = new IterationAdapter<>(vv.iterator());
		while (e.hasMoreElements())
			System.out.println(e.nextElement());
		
	}
}
