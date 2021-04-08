package Project2TestDriverCode;

//import java.lang.instrument.Instrumentation;
import Project2TestDriverCode.sort.*;

public class TestDriver 
{
    static final int INSERTION = 0, SELECTION = 1, BUBBLE = 2, QUICK = 3;
    

    static Sort[] sorts = {
		new InsertionSort(),
		new SelectionSort(),
		new BubbleSort(),
		new QuickSort()
    };
	
    static String[] names = {
		"insertion",
		"selection",
		"bubble",
		"quick"
    };

    static int[] sizes = {
		100, 200, 400, 800, 1600
    };

    /** Makes random data to test sorting algorithms against. 
     * 
     * This method creates an array of a specified 'length',
     * populated with random values 
     * 
     * @param sizes a list containing the desired length for each data set in result
     * @return a list of lists, one for each value in 'sizes'
     */
    @SuppressWarnings({ "rawtypes", "deprecation" })
	static Comparable[] makeData(int length) {
		Comparable[] data = new Integer[length];
		
		// Seed PRNG with known constant
		java.util.Random r = new java.util.Random(0);

		for( int i = 0; i < length; i++ ) {		
			data[i] = new Integer(r.nextInt(length));
		}
		return data;
    }
	
    @SuppressWarnings("rawtypes")
	public static void main (String[] args) {
    	
    	Instrumentation ins = new Instrumentation();
    	ins.active(true);
    	
    	ins.startTiming("Main");
    	
    	for (int sort = 0; sort < sorts.length; sort++)
    	{
            for (int size = 0; size < sizes.length-1; size++) 
            {
            	// What is currently being sorted?
            	System.out.println("Testing " + names[sort] + " sort, N = " + sizes[size]);
            	
            	// Make random data to sort
            	Comparable[] data = makeData(sizes[size]);
            	// Run the sort
            	sorts[sort].sort( data );	
		    }
		}
    	
    	ins.stopTiming("Main");
    	ins.dump("Main");
    }
}
