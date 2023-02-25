package com.promineo.mockdrafts.mockdraft;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineo.mockdrafts.player.Position;
import com.promineo.mockdrafts.team.TeamName;

@Repository
public interface MockDraftRepository extends JpaRepository<MockDraft, Integer>{

	List<MockDraft> findByTeamTeamName(TeamName name);

	List<MockDraft> findByPlayerPosition(Position position);

	List<MockDraft> findByPublished(LocalDateTime position);

}
