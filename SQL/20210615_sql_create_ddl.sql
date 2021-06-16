-- 20210615 DDL 생성

create table phoneInfo_basic(
    idx number(6) constraint PI_B_idx_pk primary key,
    fr_name varchar2(20) not null,
    fr_tel varchar2(20) not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_redate date default sysdate
);

create table phoneInfo_univ(
    idx number(6) constraint PI_U_idx_pk primary key,
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default '1' not null
                        constraint PI_U_fr_u_year_ck check (fr_u_year between 1 and 4),
    fr_ref number(6) not null
                     constraint PI_U_fr_ref_fk references phoneInfo_basic(idx)
);

create table phoneInfo_com(
    idx number(6),
    fr_c_company varchar(20) default 'N' not null,
    fr_ref number(6) not null,
    constraint PI_C_idx_pk primary key(idx),
    constraint PI_C_fr_c_company foreign key(fr_ref) references phoneInfo_basic(idx)
);
drop table phoneInfo_basic;

desc phoneInfo_basic;
desc phoneInfo_univ;
desc phoneInfo_com;








