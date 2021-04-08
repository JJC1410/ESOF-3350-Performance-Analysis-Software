package Project2TestDriverCode.sort;

import Project2TestDriverCode.Instrumentation;

/**
 * selection sort.
 * 
 * @param a
 *            an array of Comparable items.
 */
public class SelectionSort implements Sort {
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		
		Instrumentation ins = new Instrumentation();
		ins.active(true);
		
		ins.startTiming("SelectionSort");
		for (int last = a.length - 1; last >= 1; last--)
		{
			int max = 0;
			for (int i = 1; i <= last; i++) {
				if (a[i].compareTo(a[max]) > 0)
					max = i;

				
			}
			Comparable tmp = a[max];
			a[max] = a[last];
			a[last] = tmp;

		}
		
		ins.stopTiming("SelectionSort");
		ins.dump("SelectionSort");
	}


}