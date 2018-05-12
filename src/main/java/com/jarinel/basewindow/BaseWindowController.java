package com.jarinel.basewindow;

import com.jarinel.Model;
import com.jarinel.basewindow.dialog.AddController;
import com.jarinel.basewindow.dialog.DialogView;
import com.jarinel.basewindow.dialog.EditController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BaseWindowController implements Controller, DialogCallbacks {
    private View view;
    private Model model;

    private JFrame rootPanel;

    public BaseWindowController() {
    }

    public BaseWindowController(View view, Model model) {
        setModel(model);
        setView(view);
    }

    public void setView(View view) {
        this.view = view;
        view.setController(this);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setRootPanel(JFrame rootPanel) {
        this.rootPanel = rootPanel;
    }

    public void init() {
        view.setTextToDisplay(model.getCurrentData());
    }

    @Override
    public void handlePrevButtonClick(ActionEvent event) {
        model.prev();
        view.setTextToDisplay(model.getCurrentData());
    }

    @Override
    public void handleNextButtonClick(ActionEvent event) {
        model.next();
        view.setTextToDisplay(model.getCurrentData());
    }

    @Override
    public void handleEditButtonClick(ActionEvent event) {
        DialogView view = new DialogView(rootPanel);
        EditController controller = new EditController(view, model, this);
        controller.init();
    }

    @Override
    public void handleAddButtonClick(ActionEvent event) {
        DialogView view = new DialogView(rootPanel);
        AddController controller = new AddController(view, model, this);
        controller.init();
    }

    @Override
    public void handleSuccessfulEdit() {
        view.setTextToDisplay(model.getCurrentData());
    }

    @Override
    public void handleSuccessfulAdd() {
        model.last();
        view.setTextToDisplay(model.getCurrentData());
    }
}
