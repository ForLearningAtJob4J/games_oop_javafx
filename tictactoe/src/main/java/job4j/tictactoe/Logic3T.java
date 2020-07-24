package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    private boolean testTable(Predicate<Figure3T> predicate) {
        int [] rows = new int [table.length];
        int [] cols = new int [table[0].length];

        boolean mainDiagonal = true;
        boolean secDiagonal = true;
        boolean line = false;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (predicate.test(table[i][j])) {
                    cols[j]++;
                    rows[i]++;
                } else {
                    if (i == j) {
                        mainDiagonal = false;
                    }
                    if (i == table[0].length - j - 1){
                        secDiagonal = false;
                    }
                }
            }
        }

        for (int row: rows) {
            if (row == 3) {
                line = true;
                break;
            }
        }

        for (int col: cols) {
            if (col == 3) {
                line = true;
                break;
            }
        }

        return mainDiagonal || secDiagonal || line;
    }

    public boolean isWinnerX() {
        return testTable(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return testTable(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(figure3T -> !(figure3T.hasMarkO() || figure3T.hasMarkX()));
    }
}