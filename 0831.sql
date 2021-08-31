select * from all_tables;

create table member(
	id varchar(20) primary key,
	pw varchar(20) not null
);

insert into member values ('q','1029');

create table message(
	num int primary key,
	id varchar(20) not null,
	-- foreign key (id) references member(id) on delete cascade,
	title varchar(50),
	content varchar(1000),
	wdate date default sysdate
);
insert into message values (0,'q','hey','Nice to see you',sysdate);




select * from member;
select * from message;

drop table member;
drop table message;