package org.poglebiarka.app.api;

import dev.hilla.BrowserCallable;
import jakarta.annotation.security.PermitAll;

@BrowserCallable
public class HelloWorldService {

    @PermitAll
    public String sayHello(String name) {
        if (name.isEmpty()) {
            return "Hello stranger";
        } else {
            return "Hello " + name;
        }
    }
}
