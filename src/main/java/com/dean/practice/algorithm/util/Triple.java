package com.dean.practice.algorithm.util;

public class Triple<F, S, T> {
    F first;
    S second;
    T third;

    Triple(F f, S s, T t) {
        this.first = f;
        this.second = s;
        this.third = t;
    }

    public static <F, S, T> Triple<F, S, T> of(F f, S s, T t) {
        return new Triple<>(f, s, t);
    }
}
