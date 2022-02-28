
CREATE TABLE groups (
  id BIGSERIAL PRIMARY KEY,
  groupname VARCHAR(50) NOT NULL,
  groupowner BIGINT REFERENCES users (id)
);

CREATE TABLE groups_users (
  groups_id BIGINT REFERENCES groups (id),
  users_id BIGINT REFERENCES users (id)
);