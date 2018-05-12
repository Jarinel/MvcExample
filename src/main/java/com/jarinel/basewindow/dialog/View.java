package com.jarinel.basewindow.dialog;

public interface View {
    void setController(Controller controller);

    void setDialogTitle(String title);

    void setInputText(String text);

    String getInputText();

    void setButtonText(String text);

    void closeWindow();

    void show();
}
