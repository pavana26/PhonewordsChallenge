package org.phonewordconverter.dictionary;

import java.util.HashMap;
import java.util.Map;

public class CharacterToNumberMap {

    private Map<Character, Character> cnMap = new HashMap<>();
    public CharacterToNumberMap() {
        cnMap.put('0', '0');
        cnMap.put('1', '1');
        cnMap.put('A', '2');
        cnMap.put('B', '2');
        cnMap.put('C', '2');
        cnMap.put('D', '3');
        cnMap.put('E', '3');
        cnMap.put('F', '3');
        cnMap.put('G', '4');
        cnMap.put('H', '4');
        cnMap.put('I', '4');
        cnMap.put('J', '5');
        cnMap.put('K', '5');
        cnMap.put('L', '5');
        cnMap.put('M', '6');
        cnMap.put('N', '6');
        cnMap.put('O', '6');
        cnMap.put('P', '7');
        cnMap.put('Q', '7');
        cnMap.put('R', '7');
        cnMap.put('S', '7');
        cnMap.put('T', '8');
        cnMap.put('U', '8');
        cnMap.put('V', '8');
        cnMap.put('W', '9');
        cnMap.put('X', '9');
        cnMap.put('Y', '9');
        cnMap.put('Z', '9');
    }

    public Map<Character, Character> getCnMap() {
        return cnMap;
    }
}
