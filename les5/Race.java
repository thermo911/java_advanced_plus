package les5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Race {
    private ArrayList<Stage> stages;
    private AtomicBoolean victory = new AtomicBoolean();

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        victory.set(true);
    }

    public AtomicBoolean getVictory() {
        return victory;
    }


}