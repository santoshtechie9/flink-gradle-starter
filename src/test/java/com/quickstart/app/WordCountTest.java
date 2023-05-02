package com.quickstart.app;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCountTest {

    private static class SimpleCollector<T> implements Collector<T> {
        private final List<T> records = new ArrayList<>();

        @Override
        public void collect(T record) {
            records.add(record);
        }

        @Override
        public void close() {}

        private List<T> getRecords() {
            return records;
        }

        private void reset() {
            records.clear();
        }
    }

    @Test
    public void testWordCountTokenizer() {

        SimpleCollector<Tuple2<String, Integer>> collector = new SimpleCollector<>();
        WordCount.Tokenizer tokenizer = new WordCount.Tokenizer();

        tokenizer.flatMap("hello world hello you", collector);
        System.out.println(collector.getRecords());

        List expectedResult = Arrays.asList(
                Tuple2.of("hello", 1),
                Tuple2.of("world", 1),
                Tuple2.of("hello", 1),
                Tuple2.of("you", 1)
        );
        assertEquals(expectedResult, collector.getRecords());
    }
}