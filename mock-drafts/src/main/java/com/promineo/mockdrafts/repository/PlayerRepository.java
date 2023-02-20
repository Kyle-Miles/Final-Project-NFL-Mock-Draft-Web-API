package com.promineo.mockdrafts.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.mockdrafts.entity.Player;
import com.promineo.mockdrafts.utils.Position;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {


List <Player> findByPosition(Position position);


List<Player> findByOrderByOvrRankAsc();

}
