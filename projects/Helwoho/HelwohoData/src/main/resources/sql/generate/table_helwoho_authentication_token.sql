CREATE TABLE IF NOT EXISTS `helwoho`.`authentication_token` (
  `authentication_token_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `token` varchar(256) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expired` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`authentication_token_id`),
  UNIQUE KEY `authentication_token_id_UNIQUE` (`authentication_token_id`),
  UNIQUE KEY `token_UNIQUE` (`token`)
)
