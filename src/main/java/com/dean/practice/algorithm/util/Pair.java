package com.dean.practice.algorithm.util;

public class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <F, S> Pair<F, S> of(F f, S s) {
        return new Pair<>(f, s);
    }
}
