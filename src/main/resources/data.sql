--insert into Alien(id, name, tech) values (1, 'Green Lantern', 'JAVA');
--insert into Alien(id, name, tech) values (2, 'Superman', 'Python');
--insert into Alien(id, name, tech) values (3, 'Batman', 'C#');
--insert into Alien(id, name, tech) values (4, 'Robin', 'C');
--insert into Alien(id, name, tech) values (5, 'Lufy', 'JAVA');

CREATE TABLE Claim (
    id int,
    name varchar(255),
    tech varchar(255)
);
CREATE TABLE Client (
    id int,
    name varchar(255),
    tech varchar(255)
);
CREATE TABLE InsurancePolicy (
    id int,
    name varchar(255),
    tech varchar(255)
);
insert into InsurancePolicy(id, name, tech) values (1, 'Green Lantern', 'JAVA');