package org.phonewordconverter;

import org.phonewordconverter.executor.BaseExecutor;
import org.phonewordconverter.executor.FileFromCommandLineExecutor;
import org.phonewordconverter.executor.StdinExecutor;

public class Main {
    public final static String NUMBER_FILE_PATH_PROPERTY = "numberfile";
    public static void main(String[] args) {
        String numberFilePath = System.getProperty(NUMBER_FILE_PATH_PROPERTY);
        BaseExecutor exec = numberFilePath == null || numberFilePath.isEmpty() ?
                new StdinExecutor() : new FileFromCommandLineExecutor(numberFilePath);
        exec.execute();

    }
}