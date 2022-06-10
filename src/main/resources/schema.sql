drop table if exists NACE;
create table NACE as
    select * from CSVRead('.\src\main\resources\data.csv');