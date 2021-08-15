insert into membert (idx, memberid, password, memberphoto) values (1, cool, 1111, 1234);

select * from membert;

update membert set idx='1' where password=1111;

commit;

select * from membert;

insert into membert (memberid, membername, password) values ('cozy', '최안락', '1111');

delete from membert where idx=1 and idx=2;

drop table project.membert;

CREATE TABLE `membert` (
  `idx` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `memberid` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `membername` varchar(20) NOT NULL,
  `memberphoto` varchar(30) DEFAULT NULL,
  `regdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP
);

alter table membert alter memberphoto set DEFAULT 'photo.jpg';