create database db_ffn_TEST;

create user 'ADMIN_FFN'@'%' identified by 'password123';

grant all on db_ffn_TEST.* to 'ADMIN_FFN'@'%';