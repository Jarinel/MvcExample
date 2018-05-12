package com.jarinel.basewindow;

import java.awt.event.ActionEvent;

public interface Controller {
    void handlePrevButtonClick(ActionEvent event);
    void handleNextButtonClick(ActionEvent event);
    void handleEditButtonClick(ActionEvent event);
    void handleAddButtonClick(ActionEvent event);
}
