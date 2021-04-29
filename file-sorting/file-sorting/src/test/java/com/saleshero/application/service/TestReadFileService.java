package com.saleshero.application.service;

import com.saleshero.service.ReadFileService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestReadFileService {

    @Mock
    private ReadFileService readFileService;
    
    String fileName = "files/Input.txt";

    @Mock
    private File file;
    
    @Rule
    public ExpectedException exception = ExpectedException.none(); 
    
    @Test
    public void testReadingAFile() throws FileNotFoundException
    {
    	file = new File(fileName);
    	List<Integer> expList = Arrays.asList(12, 2324, 23432, 1, 353454, -12321, 0);
        Mockito.when(readFileService.readFileValues(fileName)).thenReturn(expList);
        List<Integer> values = readFileService.readFileValues(fileName);
        assertTrue(expList.size() == values.size() && expList.containsAll(values) && values.containsAll(expList));
    }
    
    @Test(expected = FileNotFoundException.class) 
    public void testExceptionThrownForReadingFile() throws FileNotFoundException { 
    	readFileService.readFileValues("C:\\Users\\609307401\\Desktop\\sort123.txt");
    }
    
   @Test
    public void testNumberCountWhileRead() throws FileNotFoundException
    {	
    	file = new File(fileName);
    	List<Integer> expList = Arrays.asList(12, 2324, 23432, 1, 353454, -12321, 0);
        Mockito.when(readFileService.readFileValues(fileName)).thenReturn(expList);
        List<Integer> values = readFileService.readFileValues(fileName);
        assertTrue(expList.size() == values.size());
    }
}
