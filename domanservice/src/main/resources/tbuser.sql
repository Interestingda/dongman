CREATE TABLE `t_user` (
                          `userId` bigint(20)  AUTO_INCREMENT,
                          `userName` varchar(255) NOT NULL,
                          `userPassword` varchar(255) NOT NULL,
                          PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `t_videodt` (
                             `id` bigint NOT NULL,
                             `group_id` bigint DEFAULT NULL,
                             `type_id` bigint DEFAULT NULL,
                             `type_id_1` bigint DEFAULT NULL,
                             `type_name` varchar(255) DEFAULT NULL,
                             `vod_actor` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_area` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_author` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_behind` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_blurb` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_class` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_color` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_content` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_copyright` bigint DEFAULT NULL,
                             `vod_director` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_douban_id` bigint DEFAULT NULL,
                             `vod_douban_score` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
                             `vod_down` bigint DEFAULT NULL,
                             `vod_down_from` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_down_note` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_down_server` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_down_url` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_duration` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_en` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_hits` bigint DEFAULT NULL,
                             `vod_hits_day` bigint DEFAULT NULL,
                             `vod_hits_month` bigint DEFAULT NULL,
                             `vod_hits_week` bigint DEFAULT NULL,
                             `vod_id` bigint DEFAULT NULL,
                             `vod_isend` bigint DEFAULT NULL,
                             `vod_jumpurl` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_lang` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_letter` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_level` bigint DEFAULT NULL,
                             `vod_lock` bigint DEFAULT NULL,
                             `vod_name` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pic` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pic_screenshot` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pic_slide` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pic_thumb` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_play_from` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_play_note` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_play_server` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_play_url` longtext CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_plot` int DEFAULT NULL,
                             `vod_plot_detail` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_plot_name` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_points` bigint DEFAULT NULL,
                             `vod_points_down` bigint DEFAULT NULL,
                             `vod_points_play` bigint DEFAULT NULL,
                             `vod_pubdate` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pwd` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pwd_down` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pwd_down_url` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pwd_play` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pwd_play_url` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_pwd_url` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_rel_art` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_rel_vod` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_remarks` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_reurl` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
                             `vod_score` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_score_all` bigint DEFAULT NULL,
                             `vod_score_num` bigint DEFAULT NULL,
                             `vod_serial` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_state` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_status` bigint DEFAULT NULL,
                             `vod_sub` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_tag` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_time` datetime DEFAULT NULL,
                             `vod_time_add` bigint DEFAULT NULL,
                             `vod_time_hits` bigint DEFAULT NULL,
                             `vod_time_make` bigint DEFAULT NULL,
                             `vod_total` bigint DEFAULT NULL,
                             `vod_tpl` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_tpl_down` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_tpl_play` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_trysee` bigint DEFAULT NULL,
                             `vod_tv` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_up` bigint DEFAULT NULL,
                             `vod_version` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_weekday` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_writer` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             `vod_year` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

CREATE TABLE t_video(
                          `id` BIGINT(0) NOT NULL,
                          `type` BIGINT(0),
                          `type_name` VARCHAR(25),
                          vod_en MEDIUMTEXT,
                          vod_id BIGINT(0),
                          vod_name MEDIUMTEXT,
                          vod_play_from MEDIUMTEXT,
                          vod_remarks MEDIUMTEXT,
                          vod_time VARCHAR(30),
                          PRIMARY KEY(id)
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
