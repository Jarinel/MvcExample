package com.jarinel.basewindow.dialog;

import com.jarinel.Model;
import com.jarinel.basewindow.DialogCallbacks;

import java.awt.event.ActionEvent;

public class EditController implements Controller {
    private View view;
    private Model model;

    private DialogCallbacks dialogCallbacks;

    public EditController() {
    }

    public EditController(View view, Model model, DialogCallbacks dialogCallbacks) {
        setView(view);
        setModel(model);
        setDialogCallbacks(dialogCallbacks);
    }

    public void setView(View view) {
        this.view = view;
        view.setController(this);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setDialogCallbacks(DialogCallbacks dialogCallbacks) {
        this.dialogCallbacks = dialogCallbacks;
    }

    public void init() {
        view.setDialogTitle("Редактирование записи");
        view.setButtonText("Сохранить");
        view.setInputText(model.getCurrentData());
        view.show();
    }

    @Override
    public void handleConfirmButtonClick(ActionEvent event) {
        model.save(view.getInputText());
        dialogCallbacks.handleSuccessfulEdit();
        view.closeWindow();
    }

    @Override
    public void handleCancelButtonClick(ActionEvent event) {
        view.closeWindow();
    }
}
