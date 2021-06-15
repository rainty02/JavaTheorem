-- 20210615 DDL 생성

create table phoneInfo_basic(
    idx number(6) constraint phoneInfo_basic_idx_pk primary key,
    f_name varchar2(20) constraint phoneInfo_basic_f_name_nn not null,
    f_tel varchar2(20) constraint phoneInfo_basic_f_tel_nn not null,
    f_email varchar2(20),
    f_address varchar2(20),
    f_redate date default sysdate
);

create table phoneInfo_univ(
    idx number(6) constraint phoneInfo_univ_idx_pk primary key,
    u_major varchar2(20) default 'N'
                         constraint phoneInfo_univ__u_major_mnn not null,
    u_year number(1) default '1' 
                     constraint phoneInfo_univ_u_year_ck check (u_year > 0 and u_year <5)
                     constraint phoneInfo_univ_u_year_ynn not null,
    f_ref number(6) constraint phoneInfo_univ_f_ref_rnn not null
                    constraint phoneInfo_univ_f_ref_fk references phoneInfo_basic(idx)
);

create table phoneInfo_com(
    idx number(6),
    c_company varchar(20) default 'N' constraint phoneInfo_com_c_company_nn not null,
    f_ref number(6) constraint phoneInfo_com_f_ref_nn not null,
    constraint phoneInfo_com_idx_pk primary key(idx),
    constraint phoneInfo_com_c_company foreign key(f_ref) references phoneInfo_basic(idx)
);

desc phoneInfo_basic;
desc phoneInfo_univ;
desc phoneInfo_com;
