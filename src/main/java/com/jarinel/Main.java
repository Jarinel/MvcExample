package com.jarinel;

import com.jarinel.basewindow.BaseWindowController;
import com.jarinel.basewindow.BaseWindowView;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();

        BaseWindowView view = new BaseWindowView();
        application.add(view);

        Model model = new Model();
        BaseWindowController controller = new BaseWindowController(view, model);
        controller.setRootPanel(application);

        controller.init();
    }
}
