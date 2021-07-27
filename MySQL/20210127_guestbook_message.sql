create table project.guestbook_message(
	messageid int not null auto_increment primary key,
    guestname varchar(20) not null,
    password varchar(20) not null,
    message text not null,
    regdate timestamp default current_timestamp
);

-- select
-- 최근 게시된 순서대로
select * from project.guestbook_message order by ragdate desc;
-- limit index, count / index부터 count개씩 (페이징 처리)
select * from project.guestbook_message limit 0, 3;


