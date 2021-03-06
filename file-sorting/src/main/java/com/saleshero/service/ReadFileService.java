package com.saleshero.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFileService.class);

    public List<Integer> readFileValues(String fileName) throws FileNotFoundException
    {
        List<Integer> valueList = new ArrayList<>();
        try
        {
            File tempFile = new File(fileName);
            if (tempFile.exists())
            {
                LOGGER.info("Reading values from file...  : " + fileName);
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                valueList = reader.lines().mapToInt(intValue -> Integer.parseInt(intValue.trim())).boxed().collect(Collectors.toList());
                reader.close();
            }else{
            	throw new FileNotFoundException();
            }

        }
        catch (IOException e)
        {
            LOGGER.error("IO Exception : " + e.getMessage());
            e.printStackTrace();
        }

        LOGGER.info("Row count from file  : " + valueList.size());
        return valueList;
    }
}
