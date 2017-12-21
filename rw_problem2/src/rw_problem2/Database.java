package rw_problem2;

public class Database {
	private int writers; // number of active writers
	public Database(){ // initialize database
		this.writers = 0;
    }
    /**
	   	Read from this database.
	 	@param number Number of the writer
    */
	public void write(int number){
	  	synchronized(this){
	  		this.writers++;
    		System.out.println("Writer " + number + " starts writing.");
    	}
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep((int) (Math.random() * DELAY));
    	}
    	catch (InterruptedException e) {}
	 
    	synchronized(this){
    		System.out.println("Writer " + number + " stops writing.");
    		this.writers--;
    		if (this.writers == 0){
	   			this.notifyAll();
	   		}
	   	}
	}
	 
	/**
	 	Writes to this database
	   	@param number Number of the reader
    */
	public synchronized void read(int number){
	   	while (this.writers != 0){
    		try{
    			this.wait();
    		}
    		catch (InterruptedException e) {}
    	}
    	System.out.println("Reader " + number + " starts reading.");
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep((int) (Math.random() * DELAY));
    	}
    	catch (InterruptedException e) {}
	 
    	System.out.println("Reader " + number + " stops reading.");
    	this.notifyAll();
    }
}
