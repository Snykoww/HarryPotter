package com.example.demo;

import java.io.IOException;
import java.io.OutputStream;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class CustomOutputStream extends OutputStream {
    private TextArea textArea;

    public CustomOutputStream(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        
        Platform.runLater(() -> textArea.appendText(String.valueOf((char)b)));
    }
}
