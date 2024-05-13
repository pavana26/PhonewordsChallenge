package org.phonewordconverter.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileFromCommandLineExecutor extends BaseExecutor {

    private String inputFilePath;

    public FileFromCommandLineExecutor(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public void execute() {
        displayValues(traversal.getValues(getDataFromFile()));
    }

    private List<String> getDataFromFile(){
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFilePath))) {
           List<String> list =  br.lines().collect(toList());
            return list;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
