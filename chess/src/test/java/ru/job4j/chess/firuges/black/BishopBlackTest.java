package ru.job4j.chess.firuges.black;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        assertThat(new BishopBlack(Cell.D4).position(), is(Cell.D4));
    }

    @Test
    public void wayExist() {
        assertThat(new BishopBlack(Cell.C1).way(Cell.C1, Cell.G5),
                is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = IllegalStateException.class)
    public void wayNotExist() {
        assertThat(new BishopBlack(Cell.C1).way(Cell.C1, Cell.G4),
                is(new Cell[]{Cell.D2}));
    }

    @Test
    public void copy() {
        assertThat(new BishopBlack(Cell.D4).copy(Cell.F6).position(),
                is(Cell.F6));
    }

    @Test
    public void isDiagonal() {
        assertThat(new BishopBlack(Cell.D3).isDiagonal(Cell.B1, Cell.H7), is(true));
    }

    @Test
    public void isDiagonalFalse() {
        assertThat(new BishopBlack(Cell.D3).isDiagonal(Cell.B2, Cell.H7), is(false));
    }
}