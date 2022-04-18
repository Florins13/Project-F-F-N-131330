
create database db_ffn_test;

create user 'ADMIN_FFN'@'%' identified by 'password123';

grant all on db_ffn_test.* to 'ADMIN_FFN'@'%';