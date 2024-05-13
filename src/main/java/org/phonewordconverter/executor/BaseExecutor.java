package org.phonewordconverter.executor;

import org.phonewordconverter.dictionary.DictionaryBuilder;
import org.phonewordconverter.dictionary.DictionaryFactory;
import org.phonewordconverter.traverse.DictionaryTraverse;

import java.util.Map;
import java.util.Set;

public abstract class BaseExecutor {
    final protected DictionaryTraverse traversal = new DictionaryTraverse(
            DictionaryBuilder.build(DictionaryFactory.getProvider().provide())
    );

    public abstract void execute();

    protected void displayValues(Map<String, Set<String>> values) {
        values.forEach((key, value) -> {
            System.out.printf("%s: %n", key);
            value.forEach(System.out::print);
            System.out.println();
        });
    }
}
