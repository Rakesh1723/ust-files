create table trainee_db (
        trainee_id integer not null,
        joined_date date,
        location varchar(100),
        trainee_name varchar(50),
        project VARCHAR(255),
        primary key (trainee_id)
    );


insert
    into
        trainee_db
        (joined_date, location, trainee_name, trainee_id,project)
    values
        ('2022-10-10','Bangalore','Javed',1,null);

insert
    into
        trainee_db
        (joined_date, location, trainee_name, trainee_id,project)
    values
        ('2023-02-10','Delhi','Karan',2,null);

insert
    into
        trainee_db
        (joined_date, location, trainee_name, trainee_id,project)
    values
        ('2022-04-15','Kolkata','Mahesh',3,null)
