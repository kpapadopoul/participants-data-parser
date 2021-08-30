package com.sgdigital.feeds.participantsdataparser.repository;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

@Repository
public class CsvRepository {
    private static final Logger LOGGER = getLogger(CsvRepository.class);

    public <T> List<T> reaAll(String inputPath, Function<String, T> mapper) {
        LOGGER.info("Get files of the dir: {}", inputPath);

        return listFiles(inputPath)
                .stream()
                .map(file -> read(file, mapper))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public <T> List<T> read(String inputFilePath, Function<String, T> mapper) {
        LOGGER.info("Get entries of the file: {}", inputFilePath);

        List<T> inputList = new ArrayList<>();

        try{

            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapper).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        LOGGER.info("Read {} entries", inputList.size());
        return inputList;
    }

    List<String> listFiles(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());
    }

}
