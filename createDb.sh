
docker create -v /var/lib/mysql --name mysqldata mysql/mysql-server:latest


docker run -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=root --volumes-from mysqldata --name=mysqldb mysql/mysql-server:latest

docker exec -it mysqldb bash
 
mysql -uroot -p

root

create database db_ffn_TEST;

create user 'ADMIN_FFN'@'%' identified by 'password123';

grant all on db_ffn_TEST.* to 'ADMIN_FFN'@'%';
