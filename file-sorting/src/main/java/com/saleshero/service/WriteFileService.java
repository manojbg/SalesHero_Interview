package com.saleshero.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class WriteFileService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WriteFileService.class);

    public List<Integer> writeRecordsToFile(List<Integer> values)
    {
        String filePath = "files/output.txt";
        File file = new File(filePath);
        //Sorting numbers
        Collections.sort(values);
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            
            LOGGER.info("Writing data to file path : " + filePath);
            if(values != null && values.size() > 0)
            {
                for(Integer eachValue : values)
                {
                    if(eachValue != null)
                    {
                        writer.write(String.valueOf(eachValue));
                        writer.newLine();
                    }
                }
            }
            writer.close();
        }
        catch (IOException ex)
        {
            LOGGER.error("Error while writing sorted values to file ");
            ex.printStackTrace();
        }

        LOGGER.info("Sorted values are written to the file!");
        return values;
    }
    
}
