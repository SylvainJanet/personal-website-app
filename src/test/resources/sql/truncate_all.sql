TRUNCATE TABLE messages_text_map;

TRUNCATE TABLE messages_selectors;

TRUNCATE TABLE messages_localized_string;

UPDATE hibernate_sequence
SET
    next_val = '1'
WHERE
    1;