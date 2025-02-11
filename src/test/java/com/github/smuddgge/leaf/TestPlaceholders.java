package com.github.smuddgge.leaf;

import com.github.smuddgge.leaf.datatype.MessageQuery;
import com.github.smuddgge.leaf.placeholders.PlaceholderManager;
import com.github.smuddgge.leaf.placeholders.standard.VersionPlaceholder;
import org.junit.jupiter.api.Test;

public class TestPlaceholders {

    @Test
    public void test() {
        PlaceholderManager.register(new VersionPlaceholder());

        System.out.println(PlaceholderManager.parse("Plugin version : <version>"));
    }
}
