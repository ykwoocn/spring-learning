DROP ALL OBJECTS ;

create table acct_info(
	id bigint NOT NULL AUTO_INCREMENT,
	created_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updated_time datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	acct_no varchar(48) not null DEFAULT '' COMMENT '账户id',
	user_id varchar(48) not null DEFAULT '' COMMENT '用户id',
	type 	TINYINT	not null default 0 COMMENT '账户类型，0-余额',
	available_balance bigint not null default 0 COMMENT '可用余额',
	un_available_balance bigint not null default 0 COMMENT '不可用余额',
	acct_available TINYINT not null default 1 COMMENT '账户是否可用 1-可用',
	PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE acct_info ADD UNIQUE uidx_userid_type (user_id,type);


insert into acct_info ( user_id,updated_time, acct_no,`type`, acct_available,available_balance,un_available_balance) values
('526','2019-12-21 18:45:00','117483',0,1,100000,0),
('697','2019-12-21 18:45:00','505826',0,1,0,0),
('381','2019-12-21 18:45:00','994258',0,1,0,0),
('380','2019-12-21 18:45:00','387951',0,1,0,0),
('953','2019-12-21 18:45:00','934810',0,1,0,0),
('136','2019-12-21 18:45:00','307145',0,1,0,0),
('844','2019-12-21 18:45:00','108112',0,1,0,0),
('247','2019-12-21 18:45:00','354935',0,1,0,0),
('909','2019-12-21 18:45:00','330722',0,1,0,0),
('782','2019-12-21 18:45:00','777972',0,1,0,0)