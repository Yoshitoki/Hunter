package logic;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import utils.UniqueButton;

/**
 *
 * @author lestarn
 */
public class AI extends Logic {
    
    @Override
    public int pressButton(String title, JButton button, final int i, final int j) {
        boolean steppedAway = genericStep(button, i, j);
        if (steppedAway) {
            switchButtons(false);
            List<UniqueButton> validButtons = new ArrayList<>();
            for (int k = -1; k < 1; ++k) {
                for (int l = -1; l < 1; ++l) {
                    int x = Prey.i + l;
                    int y = Prey.j + k;
                    if (isValid(x, y)
                            && isNextTo(x, y, Prey)) {
                        boolean empty 
                                = gameTable[x][y].getText().isEmpty();
                        if (empty)
                            validButtons.add(
                                    new UniqueButton(x, y, gameTable[x][y]));
                    }
                }
            }
            
            double minDistance = 0;
            UniqueButton placeToStep = null;
            if (validButtons.size() >= 1)
                placeToStep = validButtons.get(0);
            
            for (UniqueButton newPlace : validButtons) {
                double distance = 0;
                for (UniqueButton Hunter : Hunters) {
                    distance += newPlace.distanceFrom(Hunter);
                }
                if (distance < minDistance) {
                    minDistance = distance;
                    placeToStep = newPlace;
                }
            }
            
            if (null != placeToStep) {
                Prey.place.setText("");
                Prey = placeToStep;
                placeToStep.place.setText(PREY);
                switchButtons(true);
            } else {
                // game over
            }
        }
        return -1;
    }
    
}
