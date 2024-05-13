package org.phonewordconverter.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node {
    private Set<String> words;
    private Map<Character, Node> children;

    public Set<String> getWords() {
        if (words == null){
            words = new HashSet<>();
        }
        return words;
    }

    public Map<Character, Node> getChildren() {
        if (children == null){
            children = new HashMap<>();
        }
        return children;
    }

    public Node initChild(Character character) {
        Node child = getChildren().get(character);
        if (child == null){
            child = new Node();
            getChildren().put(character, child);
        }
        return child;
    }
}
