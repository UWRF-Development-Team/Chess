package org.falcon.model.player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.Identifiable;
import org.falcon.model.board.BoardSpot;

@Getter
@Setter
@Entity
@Table(name = "moves")
public class Move extends Identifiable {
    @OneToOne
    @JoinColumn(name = "id_from_board_spot")
    private BoardSpot from;
    @OneToOne
    @JoinColumn(name = "id_to_board_spot")
    private BoardSpot to;
    public Move() {
        this.from = null;
        this.to = null;
    }
    public Move(BoardSpot from, BoardSpot to) {
        this.from = from;
        this.to = to;
    }
}
