
CREATE TABLE `monster_element_type` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `uuid` varchar(100) NOT NULL,
                          `name` varchar(100) NOT NULL,
                          `tag`  varchar(3)   NOT NULL,
                          `created_at` datetime NOT NULL,
                          `updated_at` datetime NOT NULL,
                          `version` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE `monster_race` (
                                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                        `uuid` varchar(100) NOT NULL,
                                        `name` varchar(100) NOT NULL,
                                        `monster_element_type` bigint(20) NOT NULL,
                                        `created_at` datetime NOT NULL,
                                        `updated_at` datetime NOT NULL,
                                        `version` int(11) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        KEY `FK_monster_element_type_monster_race_monster_element_type_id` (`monster_element_type`),
                                        CONSTRAINT `FK_monster_element_type_monster_race_monster_element_type_id` FOREIGN KEY (`monster_element_type`) REFERENCES `monster_element_type` (`id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE `team` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `uuid` varchar(100) NOT NULL,
                        `created_at` datetime NOT NULL,
                        `updated_at` datetime NOT NULL,
                        `version` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE `monster` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `uuid` varchar(100) NOT NULL,
                                `name` varchar(100) NOT NULL,
                                `monster_race` bigint(20) NOT NULL,
                                `team` bigint(20) NOT NULL,
                                `str` int(11) NOT NULL,
                                `agi` int(11) NOT NULL,
                                `con` int(11) NOT NULL,
                                `int` int(11) NOT NULL,
                                `dex` int(11) NOT NULL,
                                `luk` int(11) NOT NULL,
                                `created_at` datetime NOT NULL,
                                `updated_at` datetime NOT NULL,
                                `version` int(11) DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FK_monster_race_monster_monster_race_id` (`monster_race`),
                                CONSTRAINT `FK_monster_race_monster_monster_race_id` FOREIGN KEY (`monster_race`) REFERENCES `monster_race` (`id`),
                                KEY `FK_team_monster_team_id` (`team`),
                                CONSTRAINT `FK_team_monster_team_id` FOREIGN KEY (`team`) REFERENCES `team` (`id`)
) DEFAULT CHARSET=utf8;



CREATE TABLE `player` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `uuid` varchar(100) NOT NULL,
                                    `name` varchar(100) NOT NULL,
                                    `team` bigint(20) NOT NULL,
                                    `created_at` datetime NOT NULL,
                                    `updated_at` datetime NOT NULL,
                                    `version` int(11) DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    KEY `FK_team_player_team_id` (`team`),
                                    CONSTRAINT `FK_team_player_team_id` FOREIGN KEY (`team`) REFERENCES `team` (`id`)
) DEFAULT CHARSET=utf8;
