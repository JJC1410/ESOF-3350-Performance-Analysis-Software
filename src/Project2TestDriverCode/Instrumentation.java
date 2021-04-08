package Project2TestDriverCode;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.*;

public class Instrumentation 
{
	private long starttime;
	private String starttimecomment;
	private long stoptime;
	private String stoptimecomment;
	private String comment;
	private boolean active;
	
	// Start time method
	public String startTiming(String comment)
	{
		if (this.active == true)
		{
			this.starttime = System.nanoTime();
			this.starttimecomment = comment;
			return ("Start Timing: " + comment);
		}
		else
		{
			return "Not active";
		}
	}
	
	// Stop time method
	public String stopTiming(String comment)
	{
		if (this.active == true)
		{
			this.stoptime = System.nanoTime() - this.starttime;
			this.stoptimecomment = comment;
			return ("Stop Timing: " + comment + ": " + this.stoptime);
		}
		else
		{
			return "Not active";
		}
		
	}
	
	// additional comments on the output file
	public void comment(String comment)
	{
		if (this.active == true)
		{
			this.comment = comment;
		}
	}
	
	// write start timing and stop timing into log
	public void dump(String filename)
	{
		if (this.active == true) // active on true
		{
			// create the log
			try
			{
				if (filename == null)
				{
					File myObj = new File("instrumentation.log");
					filename = "instrumentation.log";
					
					boolean result = myObj.createNewFile();
					
					if (result)
					{
						System.out.println("Log Created: " + myObj.getCanonicalPath());
					}
					else
					{
						System.out.println("File already exist at location: " + myObj.getCanonicalPath());
					}
				}
				else
				{
					File myObj = new File(filename);
					boolean result = myObj.createNewFile();
					
					if (result)
					{
						System.out.println("Log Created: " + myObj.getCanonicalPath());
					}
					else
					{
						System.out.println("File already exist at location: " + myObj.getCanonicalPath());
					}
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
			// handle the logger
			Logger logger = Logger.getLogger(filename);
			FileHandler fh = null;
			
			// write info into logger
			try
			{
				fh = new FileHandler(filename);
				logger.addHandler(fh);
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter(formatter);
				
				logger.info(this.startTiming(starttimecomment));
				logger.info(this.stopTiming(stoptimecomment));
				
				if (this.comment != null)
				{
					logger.info(this.comment);
				}
			}
			catch (Exception e)
			{
	            e.printStackTrace();
			}
		}
	}
	
	public void active(boolean on_off)
	{
		this.active = on_off;
	}

}
