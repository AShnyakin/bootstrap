DROP TABLE IF EXISTS TBL_USERS;
DROP TABLE IF EXISTS TBL_REVIEWS;

CREATE TABLE TBL_USERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE TBL_REVIEWS (
  user_id INT,
  comment varchar(250) NOT NULL,
  PRIMARY KEY (user_id),
  FOREIGN KEY (user_id) REFERENCES TBL_USERS (id) ON DELETE CASCADE
);
