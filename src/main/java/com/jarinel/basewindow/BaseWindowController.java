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

    private int index = 0;

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
        view.setTextToDisplay(model.getData(index));
    }

    @Override
    public void handlePrevButtonClick(ActionEvent event) {
        index = index - 1 < 0 ? model.getDataSize() - 1 : index - 1;
        view.setTextToDisplay(model.getData(index));
    }

    @Override
    public void handleNextButtonClick(ActionEvent event) {
        index = index + 1 >= model.getDataSize() ? 0 : index + 1;
        view.setTextToDisplay(model.getData(index));
    }

    @Override
    public void handleEditButtonClick(ActionEvent event) {
        DialogView view = new DialogView(rootPanel);
        EditController controller = new EditController(view, model, this);
        controller.setIndex(index);
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
        view.setTextToDisplay(model.getData(index));
    }

    @Override
    public void handleSuccessfulAdd() {
        index = model.getDataSize() - 1;
        view.setTextToDisplay(model.getData(index));
    }
}
