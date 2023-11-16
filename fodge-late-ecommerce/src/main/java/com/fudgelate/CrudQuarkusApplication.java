package com.fudgelate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CrudQuarkusApplication {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}