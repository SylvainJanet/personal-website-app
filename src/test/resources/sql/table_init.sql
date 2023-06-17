CREATE TABLE "hibernate_sequence" (
 "next_val" bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci


CREATE TABLE "messages_localized_string" (
 "id" bigint NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci


CREATE TABLE "messages_selectors" (
 "messages_localized_string_id" bigint NOT NULL,
 "selector" varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
 UNIQUE KEY "UK_mi93k9sji8mulpmjfoerxn5f7" ("selector"),
 KEY "FKbqs5x6uxk5akrqevnxtvbn2lp" ("messages_localized_string_id")
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci


CREATE TABLE "messages_text_map" (
 "messages_localized_string_id" bigint NOT NULL,
 "text" varchar(10000) COLLATE utf8mb4_unicode_520_ci NOT NULL,
 "language" varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
 PRIMARY KEY ("messages_localized_string_id","language")
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci