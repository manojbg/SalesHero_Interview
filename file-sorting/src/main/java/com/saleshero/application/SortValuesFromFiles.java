package com.saleshero.application;

import java.io.*;
import java.util.Collections;
import java.util.List;

import com.saleshero.service.ReadFileService;
import com.saleshero.service.WriteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortValuesFromFiles
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SortValuesFromFiles.class);

    public static void main(String[] args) 
    {
        LOGGER.info("Starting *SortValuesFromFiles* application....");

        String fileName = "files/Input.txt";
        try{
        	//Read values from files
            List<Integer> numbers = new ReadFileService().readFileValues(fileName);            
            //Write sorted values to file
            new WriteFileService().writeRecordsToFile(numbers);
        }catch(FileNotFoundException e){
        	LOGGER.error("file not found exception" + e.getMessage());
        }
        
    }
}
