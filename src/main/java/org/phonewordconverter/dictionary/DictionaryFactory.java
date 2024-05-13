package org.phonewordconverter.dictionary;

public class DictionaryFactory {

    public final static String DICTIONARY_PATH_PROPERTY = "dictionary";
    public static IDictionary getProvider(){
        String path = System.getProperty(DICTIONARY_PATH_PROPERTY);
        return path == null || path.isEmpty() ?
                new DefaultFileDictionary() : new FileFromUserDictionary(path);
    }
}
