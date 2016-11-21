package ss.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SuppressWarnings("unused")
public class NaiveStrategy implements Strategy {

    private String name;

    public NaiveStrategy() {
        name = "Naive";
    }

    public String getName() {
        return name;
    }

    public int determineMove(Board board, Mark mark) {
        ArrayList<Integer> fields = new ArrayList<Integer>();
        for (int i = 0; i < Board.DIM * Board.DIM; i++) {
            if (board.isEmptyField(i)) {
                fields.add(i);
            }
        }
        return fields.get((int) Math.ceil(Math.random()*(fields.size()-1)));
    }
}