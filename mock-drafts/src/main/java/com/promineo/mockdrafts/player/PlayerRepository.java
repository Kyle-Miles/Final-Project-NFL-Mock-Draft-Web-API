package com.promineo.mockdrafts.player;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {


List <Player> findByPosition(Position position);


List<Player> findByOrderByOvrRankAsc();

}
