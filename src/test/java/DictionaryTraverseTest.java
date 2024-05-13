import org.junit.jupiter.api.Test;
import org.phonewordconverter.traverse.DictionaryTraverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class DictionaryTraverseTest {

    @Test
    public void emptyDictionaryTest(){
        Map<String, Set<String>> result =  new DictionaryTraverse(
                new ArrayList<>()).getValues(Arrays.asList("1", "5", "77"));
        validateNumberResult(result, 2, "1", "5");
        validateInvariants(result, "1", 1, "1");
        validateInvariants(result, "5", 1, "5");

    }

    @Test
    public void emptyPhonesNumberTest(){
        Map<String, Set<String>> result =  new DictionaryTraverse(
                Arrays.asList("please", "hire", "me")).getValues(new ArrayList<>());
        validateNumberResult(result, 0);
    }

    @Test
    public void mixedWordTest(){
        String number = "a5b6c2d";
        Map<String, Set<String>> result =  new DictionaryTraverse(
                Arrays.asList("job")).getValues(Arrays.asList(number));
        validateNumberResult(result, 1, number);
        validateInvariants(result, number, 1, "JOB");
    }

    @Test
    public void multipleWordsInOneNodeTest(){
        Map<String, Set<String>> result =  new DictionaryTraverse(
                Arrays.asList("beg", "aei", "cdg")).getValues(Arrays.asList("234"));

        validateNumberResult(result, 1, "234");
        validateInvariants(result, "234", 3, "BEG", "AEI", "CDG");
    }


    private void validateNumberResult(Map<String, Set<String>> result, int size, String... keys){
        assertNotNull(result);
        assertEquals(result.size(), size);
    }

    private void validateInvariants(Map<String, Set<String>> result, String key, int size, String... values){
        Set<String> gotValues = result.get(key);
        assertNotNull(gotValues);
        assertEquals(gotValues.size(), size);

       // assertThat(gotValues, containsInAnyOrder(values));
    }
}
