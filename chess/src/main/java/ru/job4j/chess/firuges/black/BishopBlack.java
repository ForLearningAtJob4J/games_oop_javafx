package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = size / (dest.x - source.x);
        int deltaY = size / (dest.y - source.y);
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x + (index + 1) * deltaX, source.y + (index + 1) * deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (abs(dest.x - source.x) == abs(dest.y - source.y));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
