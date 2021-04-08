package Project2TestDriverCode.sort;

import Project2TestDriverCode.Instrumentation;

/**
 * Bubble sort.
 * 
 * @param a
 *            an array of Comparable items.
 */
public class BubbleSort implements Sort {
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sort(Comparable[] a) 
	{
		Instrumentation ins = new Instrumentation();
		ins.active(true);
		
		ins.startTiming("BubbleSort");
		
		boolean sorted = false;
		
		for (int last = a.length - 1; (last >= 1) && (!sorted); last--) 
		{
			sorted = true;
			for (int i = 0; i < last; i++)
			{
				
				if (a[i].compareTo(a[i + 1]) > 0) 
				{
					Comparable tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					sorted = false;
								
				}
			}
		}
		ins.stopTiming("BubbleSort");
		ins.dump("BubbleSort");
	}

	
}