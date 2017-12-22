package rw_problem;
import java.util.Random;

public class Database {
	private int readers; // number of active readers
	public Database(){ // initialize database
		this.readers = 0;
    }
	/* get poisson distribution random variable*/
	private static int getPoissonRandom(double mean) { 
	    Random r = new Random();
	    double L = Math.exp(-mean);
	    int k = 0;
	    double p = 1.0;
	    do {
	        p = p * r.nextDouble();
	        k++;
	    } while (p > L);
	    return k - 1;
	}
    /**
	   	Read from this database.
	 	@param number Number of the reader
    */
	public void read(int number){
	  	synchronized(this){
	  		this.readers++;
    		System.out.println("Reader " + number + " starts reading.");
    	}
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep( getPoissonRandom(Math.random()) * DELAY );
    	}
    	catch (InterruptedException e) {}
	 
    	synchronized(this){
    		System.out.println("Reader " + number + " stops reading.");
    		this.readers--;
    		if (this.readers == 0){
	   			this.notifyAll();
	   		}
	   	}
	}
	 
	/**
	 	Writes to this database
	   	@param number Number of the writer
    */
	public synchronized void write(int number){
	   	while (this.readers != 0){
    		try{
    			this.wait();
    		}
    		catch (InterruptedException e) {}
    	}
    	System.out.println("Writer " + number + " starts writing.");
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep( getPoissonRandom(Math.random()) * DELAY);
    	}
    	catch (InterruptedException e) {}
	 
    	System.out.println("Writer " + number + " stops writing.");
    	this.notifyAll();
    }
}
