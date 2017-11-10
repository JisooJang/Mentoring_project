DROP TABLE D_MEMBER;

create table d_member 
( member_id varchar2(10) primary key,
  m_name varchar2(10),
  age number(2),
  passwd varchar2(20),
  m_job varchar2(10),
  address varchar2(50),
  email varchar2(30),
  birth varchar2(10),
  phone varchar2(15),
  m_field varchar2(80),
  region varchar2(10),
  gender varchar2(1),
  admin_id varchar2(10) 
  );
