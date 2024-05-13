package org.phonewordconverter.dictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class DefaultFileDictionary implements IDictionary {
    @Override
    public List<String> provide() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/dictionary.txt")))
            );
            return reader.lines().collect(toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
