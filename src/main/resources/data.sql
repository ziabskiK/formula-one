Drop table Driver;
Drop table Race;
Drop table Scores;
create table Driver (id IDENTITY primary key , first_name VARCHAR , last_name VARCHAR , country varchar );
create table Race (id identity primary key, race_year varchar , grand_prix varchar );
create Table Scores (driver_id integer , points integer , race_id integer );