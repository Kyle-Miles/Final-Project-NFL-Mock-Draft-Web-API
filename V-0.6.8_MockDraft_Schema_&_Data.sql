-- VERSION 0.6.8

USE nfldraft;

DROP TABLE IF EXISTS mock_draft;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS draft;
DROP TABLE IF EXISTS team_needs;
DROP TABLE IF EXISTS needs;
DROP TABLE IF EXISTS team;

DROP DATABASE nfldraft;
CREATE DATABASE nfldraft;
USE nfldraft;

CREATE TABLE team (
  team_pk int unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  name ENUM('CARDINALS', 'FALCONS', 'RAVENS', 'BILLS', 'PANTHERS', 'BEARS', 'BENGALS', 'BROWNS', 'COWBOYS', 'BRONCOS', 
  'LIONS', 'PACKERS', 'TEXANS', 'COLTS', 'JAGUARS', 'CHIEFS', 'RAIDERS', 'CHARGERS', 'RAMS', 'DOLPHINS', 'VIKINGS', 'PATRIOTS', 
  'SAINTS', 'GIANTS', 'JETS', 'EAGLES', 'STEELERS', 'NINERS', 'SEAHAWKS', 'BUCCANEERS', 'TITANS', 'COMMANDERS') NOT NULL UNIQUE, 
  PRIMARY KEY (team_pk),
  UNIQUE KEY (team_pk, name)
);

CREATE TABLE needs (
  needs_pk int unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  position_needs ENUM('QB', 'RB', 'WR', 'TE', 'T', 'G', 'C', 'CB', 'S', 'DI', 'EDGE', 'LB', 'K', 'P', 'RS', 'LS') NOT NULL UNIQUE,
  PRIMARY KEY (needs_pk),
  UNIQUE KEY (needs_pk, position_needs)
);

CREATE TABLE team_needs (
  team_pk int unsigned NOT NULL,
  needs_pk int unsigned NOT NULL,
  FOREIGN KEY (team_pk) REFERENCES team (team_pk) ON DELETE CASCADE,
  FOREIGN KEY (needs_pk) REFERENCES needs (needs_pk) ON DELETE CASCADE
);

CREATE TABLE draft (
  draft_pk int unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  round ENUM('FIRST', 'SECOND', 'THIRD', 'FOURTH', 'FIFTH', 'SIXTH', 'SEVENTH') NOT NULL,
  pick ENUM('ONE', 'TWO', 'THREE', 'FOUR', 'FIVE', 'SIX', 'SEVEN', 'EIGHT', 'NINE', 'TEN', 'ELEVEN', 'TWELVE', 'THIRTEEN', 'FOURTEEN', 
  'FIFTEEN', 'SIXTEEN', 'SEVENTEEN', 'EIGHTEEN', 'NINETEEN', 'TWENTY', 'TWENTYONE', 'TWENTYTWO', 'TWENTYTHREE', 'TWENTYFOUR', 'TWENTYFIVE', 
  'TWENTYSIX', 'TWENTYSEVEN', 'TWENTYEIGHT', 'TWENTYNINE', 'THIRTY', 'THIRTYONE', 'THIRTYTWO') NOT NULL,
  PRIMARY KEY (draft_pk),
  UNIQUE KEY (draft_pk)
);

CREATE TABLE player (
  player_pk int unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  player_name varchar(50) NOT NULL,
  position ENUM('QB', 'RB', 'WR', 'TE', 'T', 'G', 'C', 'CB', 'S', 'DI', 'EDGE', 'LB', 'K', 'P', 'RS', 'LS') NOT NULL,
  college varchar(50) NOT NULL,
  ovr_rank int NOT NULL UNIQUE,
  PRIMARY KEY (player_pk),
  UNIQUE KEY (player_pk, ovr_rank)
);

CREATE TABLE mock_draft (
  mock_draft_pk int unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  team_pk int unsigned NOT NULL,
  draft_pk int unsigned NOT NULL,
  player_pk int unsigned NOT NULL,
  PRIMARY KEY (mock_draft_pk),
  FOREIGN KEY (team_pk) REFERENCES team (team_pk) ON DELETE CASCADE,
  FOREIGN KEY (draft_pk) REFERENCES draft (draft_pk) ON DELETE CASCADE,
  FOREIGN KEY (player_pk) REFERENCES player (player_pk) ON DELETE CASCADE
);

USE nfldraft;

-- Team !!DONE!!
INSERT INTO team (name) VALUES('TEXANS'); -- 1
INSERT INTO team (name) VALUES('JAGUARS'); -- 2
INSERT INTO team (name) VALUES('TITANS'); -- 3
INSERT INTO team (name) VALUES('COLTS'); -- 4

INSERT INTO team (name) VALUES('STEELERS'); -- 5
INSERT INTO team (name) VALUES('RAVENS'); -- 6
INSERT INTO team (name) VALUES('BROWNS'); -- 7
INSERT INTO team (name) VALUES('BENGALS'); -- 8

INSERT INTO team (name) VALUES('JETS'); -- 9
INSERT INTO team (name) VALUES('DOLPHINS'); -- 10
INSERT INTO team (name) VALUES('PATRIOTS'); -- 11
INSERT INTO team (name) VALUES('BILLS'); -- 12

INSERT INTO team (name) VALUES('CHIEFS'); -- 13
INSERT INTO team (name) VALUES('RAIDERS'); -- 14
INSERT INTO team (name) VALUES('BRONCOS'); -- 15
INSERT INTO team (name) VALUES('CHARGERS'); -- 16

INSERT INTO team (name) VALUES('BEARS'); -- 17 
INSERT INTO team (name) VALUES('VIKINGS'); -- 18 
INSERT INTO team (name) VALUES('PACKERS'); -- 19 
INSERT INTO team (name) VALUES('LIONS'); -- 20 

INSERT INTO team (name) VALUES('CARDINALS'); -- 21 
INSERT INTO team (name) VALUES('RAMS'); -- 22 
INSERT INTO team (name) VALUES('SEAHAWKS'); -- 23  
INSERT INTO team (name) VALUES('NINERS'); -- 24

INSERT INTO team (name) VALUES('PANTHERS'); -- 25
INSERT INTO team (name) VALUES('SAINTS'); -- 26
INSERT INTO team (name) VALUES('BUCCANEERS'); -- 27
INSERT INTO team (name) VALUES('FALCONS'); -- 28

INSERT INTO team (name) VALUES('GIANTS'); -- 29
INSERT INTO team (name) VALUES('COWBOYS'); -- 30
INSERT INTO team (name) VALUES('COMMANDERS'); -- 31
INSERT INTO team (name) VALUES('EAGLES'); -- 32


-- Needs !!DONE!!
INSERT INTO needs (position_needs) VALUES('QB'); -- 1
INSERT INTO needs (position_needs) VALUES('RB'); -- 2
INSERT INTO needs (position_needs) VALUES('WR'); -- 3
INSERT INTO needs (position_needs) VALUES('TE'); -- 4
INSERT INTO needs (position_needs) VALUES('T'); -- 5
INSERT INTO needs (position_needs) VALUES('G'); -- 6
INSERT INTO needs (position_needs) VALUES('C'); -- 7
INSERT INTO needs (position_needs) VALUES('CB'); -- 8
INSERT INTO needs (position_needs) VALUES('S'); -- 9
INSERT INTO needs (position_needs) VALUES('DI'); -- 10
INSERT INTO needs (position_needs) VALUES('EDGE'); -- 11
INSERT INTO needs (position_needs) VALUES('LB'); -- 12
INSERT INTO needs (position_needs) VALUES('K'); -- 13
INSERT INTO needs (position_needs) VALUES('P'); -- 14
INSERT INTO needs (position_needs) VALUES('RS'); -- 15
INSERT INTO needs (position_needs) VALUES('LS'); -- 16



-- Team Needs !!UNDER_CONSTRUCTION!!
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(21, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(21, 11);


-- Player !!UNDER_CONSTRUCTION!!
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Bryce Young', 'QB', 'Alabama', 1);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Jalen Carter', 'DI', 'Georgia', 2);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Will Levis', 'QB', 'Kentucky', 3);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Will Anderson Jr.', 'EDGE', 'Alabama', 4);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('C.J. Stroud', 'QB', 'Ohio State', 5);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Myles Murphy', 'EDGE', 'Clemson', 6);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Tyree Wilson', 'EDGE', 'Texas Tech', 7);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Bryan Bresee', 'DI', 'Clemson', 8);

-- Draft !!UNDER_CONSTRUCTION!!
--
-- 1ST RD !!DONE!!
--
INSERT INTO draft (round, pick) VALUES('FIRST', 'ONE'); -- 1
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWO');
INSERT INTO draft (round, pick) VALUES('FIRST', 'THREE');
INSERT INTO draft (round, pick) VALUES('FIRST', 'FOUR'); 
INSERT INTO draft (round, pick) VALUES('FIRST', 'FIVE'); -- 5
INSERT INTO draft (round, pick) VALUES('FIRST', 'SIX');
INSERT INTO draft (round, pick) VALUES('FIRST', 'SEVEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'EIGHT'); 
INSERT INTO draft (round, pick) VALUES('FIRST', 'NINE');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TEN'); -- 10
INSERT INTO draft (round, pick) VALUES('FIRST', 'ELEVEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWELVE'); 
INSERT INTO draft (round, pick) VALUES('FIRST', 'THIRTEEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'FOURTEEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'FIFTEEN'); -- 15
INSERT INTO draft (round, pick) VALUES('FIRST', 'SIXTEEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'SEVENTEEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'EIGHTEEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'NINETEEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTY'); -- 20
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYONE');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYTWO');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYTHREE');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYFOUR');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYFIVE'); -- 25
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYSIX');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYSEVEN');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYEIGHT');
INSERT INTO draft (round, pick) VALUES('FIRST', 'TWENTYNINE');
INSERT INTO draft (round, pick) VALUES('FIRST', 'THIRTY'); -- 30
INSERT INTO draft (round, pick) VALUES('FIRST', 'THIRTYONE');
--
-- 2ND ROUND !!DONE!!
--
INSERT INTO draft (round, pick) VALUES('SECOND', 'ONE'); -- 32
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWO');
INSERT INTO draft (round, pick) VALUES('SECOND', 'THREE');
INSERT INTO draft (round, pick) VALUES('SECOND', 'FOUR'); -- 35
INSERT INTO draft (round, pick) VALUES('SECOND', 'FIVE');
INSERT INTO draft (round, pick) VALUES('SECOND', 'SIX');
INSERT INTO draft (round, pick) VALUES('SECOND', 'SEVEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'EIGHT');
INSERT INTO draft (round, pick) VALUES('SECOND', 'NINE'); -- 40
INSERT INTO draft (round, pick) VALUES('SECOND', 'TEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'ELEVEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWELVE');
INSERT INTO draft (round, pick) VALUES('SECOND', 'THIRTEEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'FOURTEEN'); -- 45
INSERT INTO draft (round, pick) VALUES('SECOND', 'FIFTEEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'SIXTEEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'SEVENTEEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'EIGHTEEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'NINETEEN'); -- 50
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTY');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYONE');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYTWO');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYTHREE');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYFOUR'); -- 55
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYFIVE');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYSIX');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYSEVEN');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYEIGHT');
INSERT INTO draft (round, pick) VALUES('SECOND', 'TWENTYNINE'); -- 60
INSERT INTO draft (round, pick) VALUES('SECOND', 'THIRTY');
INSERT INTO draft (round, pick) VALUES('SECOND', 'THIRTYONE');
INSERT INTO draft (round, pick) VALUES('SECOND', 'THIRTYTWO');
--
-- 3RD RD-TO-7TH RD !!UNDER_CONSTRUCTION!!
--
INSERT INTO draft (round, pick) VALUES('THIRD', 'ONE'); -- 64
INSERT INTO draft (round, pick) VALUES('FOURTH', 'ONE'); -- 65
INSERT INTO draft (round, pick) VALUES('FIFTH', 'ONE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'ONE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'ONE'); -- 68

-- Mock Draft !!UNDER_CONSTRUCTION!!
INSERT INTO mock_draft (team_pk, draft_pk, player_pk) VALUES(17, 1, 2);
INSERT INTO mock_draft (team_pk, draft_pk, player_pk) VALUES(1, 2, 1);
INSERT INTO mock_draft (team_pk, draft_pk, player_pk) VALUES(21, 3, 4);