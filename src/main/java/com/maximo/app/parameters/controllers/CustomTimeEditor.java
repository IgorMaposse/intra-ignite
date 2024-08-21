package com.maximo.app.parameters.controllers;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomTimeEditor  extends PropertyEditorSupport {
	
	private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long ms = timeFormat.parse(text).getTime();
            setValue(new Time(ms));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse Time: " + text, e);
        }
    }
}
