package org.poglebiarka.app;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Marker only for showing which metod will be used for generate client call from frontend
 */
@Retention(SOURCE)
@Target(METHOD)
public @interface PublicEndpoint {
}
