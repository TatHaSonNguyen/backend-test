package com.example.employeesmanagement.common;

import com.example.employeesmanagement.services.dto.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.List;

/**
 * Support to implement business logic
 */
public class Utility {


    public static final String FILE_PATH = "src/main/resources/employees.csv";

    public static final File file = new File(FILE_PATH);

    /**
     * @param employeesData
     * @return boolean for write data successful or unsuccessful
     */
    public static boolean writeDataToFile(List<EmployeeDTO> employeesData) {
        try {

            CsvMapper csvMapper = new CsvMapper();
            csvMapper.enable(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS);
            CsvSchema csvSchema = csvMapper.schemaFor(EmployeeDTO.class).withUseHeader(true);
            ObjectWriter myObjectWriter = csvMapper.writer(csvSchema);
            File tempFile = new File(FILE_PATH);
            FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
            OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
            myObjectWriter.writeValue(writerOutputStream, employeesData);
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
