INSERT INTO users(username, password, enabled)
  VALUES('admin', 'admin', true);

INSERT INTO authorities(username, authority)
  VALUES('admin', 'ROLE_USER');
