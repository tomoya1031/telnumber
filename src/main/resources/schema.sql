CREATE TABLE IF NOT EXISTS tel_data(
  id INT(10) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(25),
  tel_no VARCHAR(25),
  mail_addr VARCHAR(25),
  group_id INT(10)
);
ALTER TABLE tel_data ADD CONSTRAINT tel_data_pk PRIMARY KEY(id);

CREATE TABLE IF NOT EXISTS tel_group(
  group_id INT(10) NOT NULL AUTO_INCREMENT,
  group_name VARCHAR(25)
);
ALTER TABLE tel_group ADD CONSTRAINT tel_group_pk PRIMARY KEY(group_id);
