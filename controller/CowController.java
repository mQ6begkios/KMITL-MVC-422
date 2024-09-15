package controller;

import model.Cow;
import model.CowModel;
import view.CowView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CowController {
    private CowView cowView;
    private CowModel cowModel;

    public CowController(CowView cowView, CowModel cowModel) {
        this.cowView = cowView;
        this.cowModel = cowModel;

        this.cowView.addSubmitListener(new SubmitListener());
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cowId = cowView.getCowId();
            if (cowId.matches("\\d{8}") && !cowId.startsWith("0")) {
                Cow cow = cowModel.findCowById(cowId);
                if (cow != null) {
                    handleCowLogic(cow);
                } else {
                    cowView.setResultText("Error: No cow or goat found with ID " + cowId);
                }
            } else {
                cowView.setResultText("Invalid ID");
            }
        }

        private void handleCowLogic(Cow cow) {
            Random random = new Random();
            String resultText = "";
            if (cow.getNumUdders() == 4) {
                // Cow can be milked
                resultText = "Cow found: " + cow + "\nMilking... " + cow.calculateMilk() + " liters of milk produced.";
                if (random.nextInt(100) < 5) {  
                    cowModel.updateCowUdders(cow.getId(), 3);
                    resultText += "\nWarning: one udder was lost";
                }
            } else if (cow.getNumUdders() == 3) {
                resultText = "Cow found: " + cow + "\n Cannot be milked";
                if (random.nextInt(100) < 20) {  
                    cowModel.updateCowUdders(cow.getId(), 4);
                    resultText += "\n Cow regained udder";
                }
            } else {
                resultText = "Goat detected go mountain";
            }

            cowView.setResultText(resultText);
        }
    }
}
