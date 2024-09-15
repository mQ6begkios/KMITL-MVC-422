package main;

import controller.CowController;
import model.CowModel;
import view.CowView;

public class Main {
    public static void main(String[] args) {
        CowView cowView = new CowView();
        CowModel cowModel = new CowModel();
        CowController cowController = new CowController(cowView, cowModel);

        cowView.setVisible(true);
    }
}