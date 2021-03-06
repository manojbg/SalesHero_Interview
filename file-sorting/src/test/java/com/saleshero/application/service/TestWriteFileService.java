package com.saleshero.application.service;

import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.saleshero.service.WriteFileService;

public class TestWriteFileService {
	
    WriteFileService writeFileService = null;
    
    @Before
    public void setUp(){
    	this.writeFileService = new WriteFileService();
    }
    
    @Test
    public void testWritingAFile() throws FileNotFoundException
    {
    	List<Integer> inputvalues = Arrays.asList(12, 2324, 23432, 1, 353454, -12321, 0);
    	List<Integer> expectedvalues = inputvalues;
    	Collections.sort(expectedvalues);
        List<Integer> response = writeFileService.writeRecordsToFile(inputvalues);
        assertTrue(response.size() == expectedvalues.size() && response == expectedvalues);
    }
    
   @Test
    public void testNumberCountWhileWrite() throws FileNotFoundException
    {
	   List<Integer> inputvalues = Arrays.asList(12, 2324, 23432, 1, 353454, -12321, 0);
   		List<Integer> expectedvalues = inputvalues;
   		Collections.sort(expectedvalues);
   		List<Integer> response = writeFileService.writeRecordsToFile(inputvalues);
        assertTrue(response.size() == expectedvalues.size());
    }
}
