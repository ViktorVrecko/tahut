
CREATE TABLE groups (
  id BIGSERIAL PRIMARY KEY,
  groupname VARCHAR(50) NOT NULL,
  groupowner BIGINT REFERENCES users (id)
);

CREATE TABLE groups_users (
  groupid BIGINT REFERENCES groups (id),
  userid BIGINT REFERENCES users (id)
);