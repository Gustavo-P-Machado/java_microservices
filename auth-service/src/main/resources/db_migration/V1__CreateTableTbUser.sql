create table tb_user (
        id serial not null,
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        --type smallint check (type between 0 and 1),
        type varchar(50) check ( type in ('Admin', 'Vendor', 'Common')),
        primary key (id)
    )