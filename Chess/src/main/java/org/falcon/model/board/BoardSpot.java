package org.falcon.model.board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.falcon.exception.PieceOutOfBoundsException;
import org.falcon.model.Identifiable;
import org.falcon.model.piece.PieceOrientation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = "board_spots")
public class BoardSpot extends Identifiable {
    // One indexed based.

    @Column(name = "row")
    private int row;
    @Column(name = "column")
    private int col;

    public BoardSpot() {
        this.row = 1;
        this.col = 1;
    }

    public BoardSpot(int row, int col) {
        this.row = row;
        this.col = col;
        this.throwsOutOfBounds();
    }
    public void throwsOutOfBounds() {
        if (this.row < 1 || this.row > 8 || this.col < 1 || this.col > 8) {
            throw new PieceOutOfBoundsException();
        }
    }
    public static boolean hasMoved(BoardSpot start, BoardSpot end) {
        return start.getRow() != end.getRow() || start.getCol() != end.getCol();
    }
    public List<BoardSpot> getDiagonalSpot() {
        List<BoardSpot> pieceList = new ArrayList<>();
        Optional<BoardSpot> topLeftSpot = this.getTopLeftDiagonal();
        Optional<BoardSpot> topRightSpot = this.getTopRightDiagonal();
        Optional<BoardSpot> bottomLeftSpot = this.getBottomLeftDiagonal();
        Optional<BoardSpot> bottomRightSpot = this.getBottomRightDiagonal();

        if(topLeftSpot.isPresent()) {
            pieceList.add(topLeftSpot.get());
        }
        if(bottomLeftSpot.isPresent()) {
            pieceList.add(bottomLeftSpot.get());
        }
        if(topRightSpot.isPresent()) {
            pieceList.add(topRightSpot.get());
        }
        if(bottomRightSpot.isPresent()) {
            pieceList.add(bottomRightSpot.get());
        }
        return pieceList;
    }

    public Optional<BoardSpot> getTopLeftDiagonal() {
        int newRow = this.getRow() - 1;
        int newColumn = this.getCol() - 1;
        if (newRow < 0 || newRow > 7) {
            return Optional.empty();
        }
        if (newColumn < 0 || newColumn > 7) {
            return Optional.empty();
        }
        return Optional.of(new BoardSpot(newRow, newColumn));
    }
    public Optional<BoardSpot> getTopRightDiagonal() {
        int newRow = this.getRow() - 1;
        int newColumn = this.getCol() + 1;
        if (newRow < 0 || newRow > 7) {
            return Optional.empty();
        }
        if (newColumn < 0 || newColumn > 7) {
            return Optional.empty();
        }
        return Optional.of(new BoardSpot(newRow, newColumn));
    }
    public Optional<BoardSpot> getBottomLeftDiagonal() {
        int newRow = this.getRow() + 1;
        int newColumn = this.getCol() - 1;
        if (newRow < 0 || newRow > 7) {
            return Optional.empty();
        }
        if (newColumn < 0 || newColumn > 7) {
            return Optional.empty();
        }
        return Optional.of(new BoardSpot(newRow, newColumn));
    }
    public Optional<BoardSpot> getBottomRightDiagonal() {
        int newRow = this.getRow() + 1;
        int newColumn = this.getCol() + 1;
        if (newRow < 0 || newRow > 7) {
            return Optional.empty();
        }
        if (newColumn < 0 || newColumn > 7) {
            return Optional.empty();
        }
        return Optional.of(new BoardSpot(newRow, newColumn));
    }
}
