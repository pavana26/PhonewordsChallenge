import org.junit.jupiter.api.Test;
import org.phonewordconverter.dictionary.Node;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NodeTest {

    @Test
    public void initNodeTest(){
        Node head = new Node();
        Map<Character, Node> children = head.getChildren();
        assertNotNull(children);
        assertEquals(children.size(), 0);

        head.initChild('A');
        assertEquals(children.size(), 1);
        assertNotNull(children.get('A'));
        assertNotNull(children.get('A').getChildren());
        assertEquals(children.get('A').getChildren().size(), 0);
    }
}
