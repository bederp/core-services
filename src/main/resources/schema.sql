create table request
(
   client_id varchar(6) not null,
   request_id bigint not null,
   name varchar(255) not null,
   quantity integer not null,
   price double not null,
);
