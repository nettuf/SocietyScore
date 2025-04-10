package com.societyscore.authservice.Util.Messages;

public final class EmailMessages{

    public static final String SUBJECT_CONFIRMATION = "Confirme seu cadastro";
    public static final String EMAIL_LINK_CONFIRMATION = "http://localhost:8080/confirm?token=";

    private EmailMessages() {}

    public static String textConfirmation(String link) {
        return "Clique no link para confirmar: " + link;
    }
}

