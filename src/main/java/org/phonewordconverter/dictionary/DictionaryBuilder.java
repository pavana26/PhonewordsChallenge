package org.phonewordconverter.dictionary;

import java.util.List;

public class DictionaryBuilder {
    private final static CharacterToNumberMap cnMap = new CharacterToNumberMap();
    public static Node build(List<String> words){
        Node head = new Node();
        words.forEach(word -> addToTree(word, head));
        return head;
    }

    private static void addToTree(String word, Node head) {
        word = regulateWords(word);
        for (char character : word.toCharArray()){
            head = head.initChild(cnMap.getCnMap().get(character));
        }
        head.getWords().add(word);
    }
    public static String regulateWords(String str){
        return str == null ? "" : str.toUpperCase().replaceAll("[^a-zA-Z]+","");
    }

}
