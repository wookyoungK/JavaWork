create table tbl_board(
  bno int not null auto_increment,
  title varchar(50) not null,
  content text not null,
  writer varchar(30) not null,
  regDate timestamp not null default sysdate,
  viewCnt int default 0,
  primary key(bno)
);

commit;

select * from tbl_board;