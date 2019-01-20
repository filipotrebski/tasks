package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Mail {
    @NonNull
    private String mailTo;
    @NonNull
    private String subject;
    @NonNull
    private final String message;
    private String toCc;
}
