insert into membert (idx, memberid, password, memberphoto) values (1, cool, 1111, 1234);

select * from membert;

update membert set idx='1' where password=1111;

commit;

select * from membert;

insert into membert (idx, memberid, membername, password) values (2, 'hot', '김더움', '1111');

delete from membert where idx=1 and idx=2;

drop table project.membert;

CREATE TABLE `membert` (
  `idx` int DEFAULT NULL,
  `memberid` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `membername` varchar(45) NOT NULL,
  `memberphoto` varchar(45) DEFAULT NULL,
  `regdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP
);