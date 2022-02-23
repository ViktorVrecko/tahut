
CREATE TABLE stickers (
  id BIGSERIAL PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  fk_author VARCHAR(50) NOT NULL REFERENCES users (username),
  event_date TIMESTAMP(0) NOT NULL,
  duration INT
);
