CREATE TABLE board (
    board_idx INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    contents TEXT NOT NULL,
    created_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_datetime DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    creator_id VARCHAR(50),
    updater_id VARCHAR(50),
    hit_cnt INT DEFAULT 0,
    deleted_yn CHAR(1) DEFAULT 'N'
);