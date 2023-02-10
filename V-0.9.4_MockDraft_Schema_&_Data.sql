-- VERSION 0.9.4

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
  'SAINTS', 'GIANTS', 'JETS', 'EAGLES', 'STEELERS', 'FORTY_NINERS', 'SEAHAWKS', 'BUCCANEERS', 'TITANS', 'COMMANDERS') NOT NULL UNIQUE, 
  PRIMARY KEY (team_pk),
  UNIQUE KEY (team_pk, name)
);

CREATE TABLE needs (
  needs_pk int unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  position ENUM('QB', 'RB', 'WR', 'TE', 'T', 'G', 'C', 'CB', 'S', 'DI', 'EDGE', 'LB', 'K', 'P') NOT NULL UNIQUE,
  PRIMARY KEY (needs_pk),
  UNIQUE KEY (needs_pk, position)
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
  'TWENTYSIX', 'TWENTYSEVEN', 'TWENTYEIGHT', 'TWENTYNINE', 'THIRTY', 'THIRTYONE', 'THIRTYTWO','THIRTYTHREE', 'THIRTYFOUR', 'THIRTYFIVE', 
  'THIRTYSIX', 'THIRTYSEVEN', 'THIRTYEIGHT', 'THIRTYNINE', 'FORTY', 'FORTYONE', 'FORTYTWO', 'FORTYTHREE') NOT NULL,
  PRIMARY KEY (draft_pk)
);

CREATE TABLE player (
  player_pk int unsigned NOT NULL AUTO_INCREMENT UNIQUE,
  player_name varchar(50) NOT NULL,
  position ENUM('QB', 'RB', 'WR', 'TE', 'T', 'G', 'C', 'CB', 'S', 'DI', 'EDGE', 'LB', 'K', 'P') NOT NULL,
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
INSERT INTO team (name) VALUES('FORTY_NINERS'); -- 24

INSERT INTO team (name) VALUES('PANTHERS'); -- 25
INSERT INTO team (name) VALUES('SAINTS'); -- 26
INSERT INTO team (name) VALUES('BUCCANEERS'); -- 27
INSERT INTO team (name) VALUES('FALCONS'); -- 28

INSERT INTO team (name) VALUES('GIANTS'); -- 29
INSERT INTO team (name) VALUES('COWBOYS'); -- 30
INSERT INTO team (name) VALUES('COMMANDERS'); -- 31
INSERT INTO team (name) VALUES('EAGLES'); -- 32


-- Needs !!DONE!!
INSERT INTO needs (position) VALUES('QB'); -- 1
INSERT INTO needs (position) VALUES('RB'); -- 2
INSERT INTO needs (position) VALUES('WR'); -- 3
INSERT INTO needs (position) VALUES('TE'); -- 4
INSERT INTO needs (position) VALUES('T'); -- 5
INSERT INTO needs (position) VALUES('G'); -- 6
INSERT INTO needs (position) VALUES('C'); -- 7
INSERT INTO needs (position) VALUES('CB'); -- 8
INSERT INTO needs (position) VALUES('S'); -- 9
INSERT INTO needs (position) VALUES('DI'); -- 10
INSERT INTO needs (position) VALUES('EDGE'); -- 11
INSERT INTO needs (position) VALUES('LB'); -- 12
INSERT INTO needs (position) VALUES('K'); -- 13
INSERT INTO needs (position) VALUES('P'); -- 14



-- Team Needs !!DONE!!
--
-- Texans
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(1, 10);
--
-- BEARS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 4);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 12);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 8);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(17, 9);
--
-- CARDINALS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(21, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(21, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(21, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(21, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(21, 8);
--
-- COLTS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(4, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(4, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(4, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(4, 7);
--
-- SEAHAWKS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(23, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(23, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(23, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(23, 7);
--
-- LIONS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(20, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(20, 12);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(20, 8);
--
-- RAIDERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(14, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(14, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(14, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(14, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(14, 8);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(14, 9);
--
-- FALCONS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(28, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(28, 4);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(28, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(28, 12);
--
-- PANTHERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(25, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(25, 2);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(25, 4);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(25, 11);
--
-- EAGLES
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(32, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(32, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(32, 7);
--
-- TITANS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(3, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(3, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(3, 11);
--
-- JETS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(9, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(9, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(9, 12);
--
-- PATRIOTS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(11, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(11, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(11, 11);
--
-- PACKERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(19, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(19, 4);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(19, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(19, 12);
--
-- COMMANDERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(31, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(31, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(31, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(31, 12);
--
-- STEELERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(5, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(5, 12);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(5, 8);
--
-- BUCCANEERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(27, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(27, 4);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(27, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(27, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(27, 10);
--
-- DOLPHINS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(10, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(10, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(10, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(10, 8);
--
-- CHARGERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(16, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(16, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(16, 8);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(16, 12);
--
-- RAVENS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(6, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(6, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(6, 8);
--
-- VIKINGS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(18, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(18, 12);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(18, 8);
--
-- JAGUARS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(2, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(2, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(2, 8);
--
-- GIANTS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(29, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(29, 4);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(29, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(29, 12);
--
-- COWBOYS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(30, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(30, 12);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(30, 3);
--
-- BILLS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(12, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(12, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(12, 8);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(12, 9);
--
-- BENGALS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(8, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(8, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(8, 8);
--
-- SAINTS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(26, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(26, 1);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(26, 8);
--
-- CHIEFS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(13, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(13, 11);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(13, 3);
--
-- BRONCOS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(15, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(15, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(15, 12);
--
-- RAMS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(22, 5);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(22, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(22, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(22, 9);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(22, 11);
--
-- BROWNS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(7, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(7, 3);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(7, 9);
--
-- FORTY_NINERS
--
INSERT INTO team_needs (team_pk, needs_pk) VALUES(24, 10);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(24, 6);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(24, 7);
INSERT INTO team_needs (team_pk, needs_pk) VALUES(24, 8);

-- Player !!UNDER_CONSTRUCTION!!
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Bryce Young', 'QB', 'Alabama', 1);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Jalen Carter', 'DI', 'Georgia', 2);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Will Levis', 'QB', 'Kentucky', 3);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Will Anderson Jr.', 'EDGE', 'Alabama', 4);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('C.J. Stroud', 'QB', 'Ohio State', 5);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Myles Murphy', 'EDGE', 'Clemson', 6);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Tyree Wilson', 'EDGE', 'Texas Tech', 7);
INSERT INTO player (player_name, position, college, ovr_rank) VALUES('Bryan Bresee', 'DI', 'Clemson', 8);

-- Draft !!DONE!!
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
-- 2ND RD !!DONE!!
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
INSERT INTO draft (round, pick) VALUES('SECOND', 'THIRTYTWO'); -- 63
--
-- 3RD RD !!DONE!!
--
INSERT INTO draft (round, pick) VALUES('THIRD', 'ONE'); -- 64
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWO');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THREE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'FOUR'); 
INSERT INTO draft (round, pick) VALUES('THIRD', 'FIVE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'SIX');
INSERT INTO draft (round, pick) VALUES('THIRD', 'SEVEN');  -- 70
INSERT INTO draft (round, pick) VALUES('THIRD', 'EIGHT');
INSERT INTO draft (round, pick) VALUES('THIRD', 'NINE'); 
INSERT INTO draft (round, pick) VALUES('THIRD', 'TEN');
INSERT INTO draft (round, pick) VALUES('THIRD', 'ELEVEN');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWELVE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTEEN');
INSERT INTO draft (round, pick) VALUES('THIRD', 'FOURTEEN'); 
INSERT INTO draft (round, pick) VALUES('THIRD', 'FIFTEEN');
INSERT INTO draft (round, pick) VALUES('THIRD', 'SIXTEEN');
INSERT INTO draft (round, pick) VALUES('THIRD', 'SEVENTEEN'); -- 80
INSERT INTO draft (round, pick) VALUES('THIRD', 'EIGHTEEN');
INSERT INTO draft (round, pick) VALUES('THIRD', 'NINETEEN'); 
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTY');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYONE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYTWO');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYTHREE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYFOUR'); 
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYFIVE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYSIX');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYSEVEN'); -- 90
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYEIGHT');
INSERT INTO draft (round, pick) VALUES('THIRD', 'TWENTYNINE'); 
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTY');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYONE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYTWO');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYTHREE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYFOUR'); 
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYFIVE');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYSIX');
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYSEVEN'); -- 100
INSERT INTO draft (round, pick) VALUES('THIRD', 'THIRTYEIGHT'); -- 101
--
-- 4TH RD !!DONE!!
--
INSERT INTO draft (round, pick) VALUES('FOURTH', 'ONE'); -- 102
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWO');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'THREE');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'FOUR'); 
INSERT INTO draft (round, pick) VALUES('FOURTH', 'FIVE');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'SIX');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'SEVEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'EIGHT');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'NINE'); -- 110
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'ELEVEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWELVE');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'THIRTEEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'FOURTEEN'); 
INSERT INTO draft (round, pick) VALUES('FOURTH', 'FIFTEEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'SIXTEEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'SEVENTEEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'EIGHTEEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'NINETEEN'); -- 120
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTY');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYONE');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYTWO');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYTHREE');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYFOUR'); 
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYFIVE');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYSIX');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYSEVEN');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYEIGHT');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'TWENTYNINE'); -- 130
INSERT INTO draft (round, pick) VALUES('FOURTH', 'THIRTY');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'THIRTYONE');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'THIRTYTWO');
INSERT INTO draft (round, pick) VALUES('FOURTH', 'THIRTYTHREE'); -- 134
--
-- 5TH RD !!DONE!!
--
INSERT INTO draft (round, pick) VALUES('FIFTH', 'ONE'); -- 135
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWO');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THREE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'FOUR'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'FIVE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'SIX'); -- 140
INSERT INTO draft (round, pick) VALUES('FIFTH', 'SEVEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'EIGHT');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'NINE'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'ELEVEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWELVE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTEEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'FOURTEEN'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'FIFTEEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'SIXTEEN'); -- 150
INSERT INTO draft (round, pick) VALUES('FIFTH', 'SEVENTEEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'EIGHTEEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'NINETEEN'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTY');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYONE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYTWO');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYTHREE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYFOUR'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYFIVE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYSIX'); -- 160
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYSEVEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYEIGHT');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'TWENTYNINE'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTY');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYONE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYTWO');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYTHREE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYFOUR'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYFIVE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYSIX'); -- 170
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYSEVEN');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYEIGHT');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'THIRTYNINE'); 
INSERT INTO draft (round, pick) VALUES('FIFTH', 'FORTY');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'FORTYONE');
INSERT INTO draft (round, pick) VALUES('FIFTH', 'FORTYTWO'); -- 176
--
-- 6TH RD !!DONE!!
--
INSERT INTO draft (round, pick) VALUES('SIXTH', 'ONE'); -- 177
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWO');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THREE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FOUR'); -- 180
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FIVE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'SIX');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'SEVEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'EIGHT');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'NINE'); 
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'ELEVEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWELVE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTEEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FOURTEEN'); -- 190
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FIFTEEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'SIXTEEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'SEVENTEEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'EIGHTEEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'NINETEEN'); 
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTY');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYONE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYTWO');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYTHREE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYFOUR'); -- 200
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYFIVE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYSIX');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYSEVEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYEIGHT');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'TWENTYNINE'); 
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTY');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYONE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYTWO');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYTHREE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYFOUR'); -- 210
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYFIVE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYSIX');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYSEVEN');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYEIGHT');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'THIRTYNINE'); 
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FORTY');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FORTYONE');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FORTYTWO');
INSERT INTO draft (round, pick) VALUES('SIXTH', 'FORTYTHREE'); -- 219
--
-- 7TH RD !!DONE!!
--
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'ONE'); -- 220
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWO'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THREE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'FOUR'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'FIVE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'SIX');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'SEVEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'EIGHT');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'NINE'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'ELEVEN'); -- 230
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWELVE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTEEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'FOURTEEN'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'FIFTEEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'SIXTEEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'SEVENTEEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'EIGHTEEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'NINETEEN'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTY');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYONE'); -- 240
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYTWO');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYTHREE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYFOUR'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYFIVE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYSIX');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYSEVEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYEIGHT');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'TWENTYNINE'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTY');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYONE'); -- 250
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYTWO');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYTHREE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYFOUR'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYFIVE');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYSIX');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYSEVEN');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYEIGHT');
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'THIRTYNINE'); 
INSERT INTO draft (round, pick) VALUES('SEVENTH', 'FORTY'); -- 259

-- Mock Draft !!UNDER_CONSTRUCTION!!
INSERT INTO mock_draft (team_pk, draft_pk, player_pk) VALUES(17, 1, 2);
INSERT INTO mock_draft (team_pk, draft_pk, player_pk) VALUES(1, 2, 1);
INSERT INTO mock_draft (team_pk, draft_pk, player_pk) VALUES(21, 3, 4);
