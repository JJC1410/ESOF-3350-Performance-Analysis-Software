package Project2TestDriverCode.sort;

import Project2TestDriverCode.Instrumentation;

;

/**
 * Simple insertion sort.
 * 
 * @param a
 *            an array of Comparable items.
 */
public class InsertionSort implements Sort {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void sort(Comparable[] a) 
		{
			
			Instrumentation ins = new Instrumentation();
			ins.active(true);
			
			ins.startTiming("InsertionSort");
			
			for (int p = 0; p < a.length; p++) 
			{
				int i = p;
				boolean sorted = false;
				while ((i > 0) && (!sorted)) {
					if (a[i].compareTo(a[i - 1]) < 0) {
						Comparable tmp = a[i];
						a[i] = a[i - 1];
						a[i - 1] = tmp;
						i--;
						
					} else
						sorted = true;
				}
			}
			
			ins.stopTiming("InsertionSort");
			ins.dump("InsertionSort");
	}


}
