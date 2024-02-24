package org.poglebiarka.admin;

import kotlin.annotation.AnnotationRetention.SOURCE
import kotlin.annotation.AnnotationTarget.FUNCTION


/**
 * Marker only for showing which metod will be used for generate client call from frontend
 */
@Retention(SOURCE)
@Target(FUNCTION)
annotation class PublicEndpoint
