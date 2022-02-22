
CREATE TABLE stickers (
  id BIGSERIAL PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  author VARCHAR(50) NOT NULL,
  event_date TIMESTAMP NOT NULL,
  duration INT,
  usersid BIGINT REFERENCES users (id)
);
