package rw_problem;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Simulator{
	/**
	  Creates the specified number of readers and writers and starts them.
	  @param args[0] The number of readers.
	  @param args[1] The number of writers.
	*/
	public static void main(String[] args){
	  	if (args.length < 2){
	        System.out.println("Usage: java Simulator <number of readers> <number of writers>");
	   	}
	   	else{

	   		final int READERS = Integer.parseInt(args[0]);
	   		final int WRITERS = Integer.parseInt(args[1]);
	   		Database database = new Database();
	   		for (int i = 0; i < READERS; i++){
	   			new Reader(database).start();
	   		}
	   		for (int i = 0; i < WRITERS; i++){
	   			new Writer(database).start();
	   		}
	   	}
    }
}