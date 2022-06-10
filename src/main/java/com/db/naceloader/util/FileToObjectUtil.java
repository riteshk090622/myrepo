package com.db.naceloader.util;

import com.db.naceloader.model.Nace;
import com.db.naceloader.model.NaceBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
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
            bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));

            final CSVFormat csvFormat = CSVFormat.Builder.create(CSVFormat.DEFAULT).setHeader().setSkipHeaderRecord(false).setIgnoreEmptyLines(true).build();
            CSVParser csvParser = new CSVParser(bufferedReader, csvFormat);

            final List<CSVRecord> records = csvParser.getRecords();
            for (CSVRecord record : records) {
                final Nace nace = new NaceBuilder()
                        .setOrderId(Integer.valueOf(record.get("Order")))
                        .setLevel(Integer.valueOf(record.get("Level")))
                        .setCode(record.get("Code"))
                        .setParent(record.get("Parent"))
                        .setDescription(record.get("Description"))
                        .setIncludes(record.get("This item includes"))
                        .setAlsoIncludes(record.get("This item also includes"))
                        .setRulings(record.get("Rulings"))
                        .setExcludes(record.get("This item excludes"))
                        .setRulings(record.get("Rulings"))
                        .setReference(record.get("Reference to ISIC Rev. 4"))
                        .createNace();
                naceArrayList.add(nace);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return naceArrayList;
    }

}
