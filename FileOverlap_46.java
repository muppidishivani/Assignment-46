package com.web.java;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;


public class FileOverlap_46 {
	
	
	    public static void main(String[] args)
	    {
	 
	       
	        try {
	 
	           
	            File file = new File("C:\\Users\\ramya\\OneDrive\\Desktopt\\test.txt");
	 
	           
	            FileChannel channel
	                = new RandomAccessFile(file, "rw")
	                      .getChannel();
	 
	       
	            FileLock lock
	                = channel.lock(0, Long.MAX_VALUE, true);
	 
	           
	            try {
	 
	                lock = channel.tryLock(0, Long.MAX_VALUE,
	                                       true);
	            }
	            catch (OverlappingFileLockException e) {
	              
	                System.out.println(
	                    "Overlapping File Lock Error: "
	                    + e.getMessage());
	            }
	 
	           
	            boolean isShared = lock.isShared();
	 
	           
	            lock.release();
	 
	           
	            channel.close();
	        }
	 
	       
	        catch (IOException e) {
	 
	            
	            System.out.println("I/O Error: "
	                               + e.getMessage());
	        }
	    }
	}

	
	   