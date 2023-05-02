
package com.quickstart.app;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

public class WordCountData {

    public static final String[] WORDS =
            new String[] {
                    "TLet us stroll in spring's forest where we will reap " +
                            "The joy of Earth awakening its children from sleep, " +
                            "And hear life's chorus and watch its offspring grow, " +
                            "As waking trees renew their canopy over all below; " +
                            "Come share with me the forest's spirit at rebirth, " +
                            "So we too are reborn within this temple of Earth."
            };

    public static DataSet<String> getDefaultTextLineDataSet(ExecutionEnvironment env) {
        return env.fromElements(WORDS);
    }
}
