package com.jarinel.basewindow;

public interface View {
    // Technically this is not part of the view
    void setController(Controller controller);

    void setTextToDisplay(String text);
}
