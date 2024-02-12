package org.poglebiarka.app.api;

public record UserDetails(
        String email,
        String name,
        String profilePictureUrl
) {}
