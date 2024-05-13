package org.phonewordconverter.traverse;

import org.phonewordconverter.dictionary.DictionaryBuilder;
import org.phonewordconverter.dictionary.Node;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class DictionaryTraverse {

    protected Node dictionary;

    public DictionaryTraverse(Node dictionary) {
        this.dictionary = dictionary;
    }

    public DictionaryTraverse(List<String> dictionary) {
        this.dictionary = DictionaryBuilder.build(dictionary);
    }

    public Map<String, Set<String>> getValues(List<String> numbers) {
        /* Collect invariants grouped by number, exclude empty invariants lists */
        return numbers.stream().map(numb -> new AbstractMap.SimpleEntry<>(numb, getWords(numb)))
                .filter(entry -> !entry.getValue().isEmpty())
                .collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

    }

    private Set<String> getWords(String numb) {
        numb = regulateNumbers(numb);
        Set<String> values = new HashSet<>();
        List<List<String>> tokensList = new LinkedList<>();
        List<String> tokens = new LinkedList<>();
        tokensList.add(tokens);
        getWords(numb, dictionary, tokensList, values);
        return values;
    }


    private void getWords(String numb, Node head, List<List<String>> tokensList, Set<String> values) {
        if (numb.isEmpty()) {
            return;
        }
        getWords(numb, head, head.getChildren().get(numb.charAt(0)), new LinkedList<>(tokensList), values);
    }

    private void getWords(String numb, Node head, Node child, List<List<String>> tokensList, Set<String> values) {
        /*If there is a letter available for current digit in a dictionary tree path*/
        if (child == null) {
            /*Try to add a digit to tokens if previous one is not a digit*/
            final Node finalHead = head;
            tokensList = tokensList.stream()
                    .filter(tokens -> finalHead == dictionary && (tokens.isEmpty() || !isNumeric(tokens.get(tokens.size() - 1))))
                    .collect(toList());
            tokensList.forEach(tokens -> tokens.add(String.valueOf(numb.charAt(0))));
            head = dictionary;
        } else {
            /* Found a suitable letter - dictionary tree node is head now for current tree path */
            head = child;

            /*GetMore words if possible even if hit the target word -lloking for  longer one */
            getWords(numb.substring(1), head, new LinkedList<>(tokensList), values);

            /*If the word  found - add it to tokens and start traversal from the top of the tree */
            if (!child.getWords().isEmpty()) {
                tokensList = addValuesToTokens(tokensList, child.getWords());
                head = dictionary;
            }
        }
        /* Hit last character in number sequence */
        if (numb.length() == 1 && head == dictionary) {
            tokensList.forEach(tokens -> {
                values.add(String.join("-", tokens));
            });
            return;
        }
        getWords(numb.substring(1), head, tokensList, values);
    }

    private List<List<String>> addValuesToTokens(List<List<String>> tokensList, Set<String> words) {
        List<List<String>> result = new LinkedList<>();
        tokensList.forEach(tokens -> {
            words.forEach(word -> {
                List<String> newTokens = new LinkedList<>(tokens);
                newTokens.add(word);
                result.add(newTokens);
            });
        });
        return result;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String regulateNumbers(String str) {

        return str == null ? "" : str.toUpperCase().replaceAll("[^0-9]+", "");
    }

}
