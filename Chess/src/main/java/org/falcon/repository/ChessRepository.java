package org.falcon.repository;

import org.falcon.model.chess.Chess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessRepository extends JpaRepository<Chess, Long> {
}
