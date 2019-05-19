Drop table Driver;
Drop table Race;
create table Driver (id IDENTITY primary key , first_name VARCHAR , last_name VARCHAR , country varchar );
create table Race (id identity primary key, race_year varchar , grand_prix varchar );