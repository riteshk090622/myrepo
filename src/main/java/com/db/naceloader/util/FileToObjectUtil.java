package com.db.naceloader.util;

import com.db.naceloader.model.Nace;
import com.db.naceloader.repository.NaceRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileToObjectUtil {

    private FileToObjectUtil() {
    }

    public static ArrayList<Nace> fileToNaceList(MultipartFile file) {
        BufferedReader bufferedReader = null;
        ArrayList<Nace> naceArrayList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"));

        final CSVFormat csvFormat = CSVFormat.Builder.create(CSVFormat.DEFAULT).setHeader().setSkipHeaderRecord(false).setIgnoreEmptyLines(true).build();
        CSVParser csvParser = new CSVParser(bufferedReader,csvFormat);

//            CSVFormat.DEFAULT.withFirstRecordAsHeader()
        final List<CSVRecord> records = csvParser.getRecords();
        for(CSVRecord record : records){
            Nace nace = new Nace(
                    Integer.valueOf(record.get("Order")),
                    Integer.valueOf(record.get("Level")),
                    record.get("Code")
            );
            naceArrayList.add(nace);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return naceArrayList;
    }

}
