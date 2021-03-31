create sequence BANK.seq_cntc
    start with 1
    increment by 1
    minvalue 1
    nomaxvalue;
create sequence BANK.seq_address
    start with 1
    increment by 1
    minvalue 1
    nomaxvalue;
create sequence BANK.seq_event
    start with 1
    increment by 1
    minvalue 1
    nomaxvalue;
create sequence BANK.seq_eventdata
    start with 1
    increment by 1
    minvalue 1
    nomaxvalue;

create table BANK.bnk_cntc
(
    id        number primary key,
    idntno    nvarchar2(100) unique,
    idnttyp   nvarchar2(1)   not null,
    custno    nvarchar2(100) unique,
    custtyp   nvarchar2(1)   not null,
    dob       date           not null,
    frstnam   nvarchar2(100) not null,
    lstnam    nvarchar2(100) not null,
    addressid number,
    constraint fk_address foreign key (addressid) references bnk_address (id)
);

create table BANK.bnk_address
(
    id      number primary key,
    cntry   nvarchar2(100) not null,
    prvnc   nvarchar2(100) not null,
    cty     nvarchar2(100) not null,
    strt    nvarchar2(100) not null,
    alley   nvarchar2(100) not null,
    no      number(3)      not null,
    postcod nvarchar2(100) not null
);

create table BANK.bnk_card
(
    pan        nvarchar2(16) primary key,
    pmntappno  nvarchar2(100) not null,
    pmntapptyp number(1)      not null,
    isudt      date           not null,
    expdt      date           not null,
    cvv        nvarchar2(100) not null,
    pin1       nvarchar2(100) not null,
    pin2       nvarchar2(100),
    hldrid     number,
    owncustno  nvarchar2(100) not null,
    foreign key (hldrid) references BANK.bnk_cntc (id),
    foreign key (owncustno) references BANK.bnk_cntc (custno)
);

create table BANK.bnk_event
(
    id        number primary key,
    userip    nvarchar2(100),
    oprtncode number,
    username  nvarchar2(100)
);

create table BANK.bnk_eventdata
(
    id       number primary key,
    entity   nvarchar2(50),
    action   nvarchar2(10),
    oldvals  nvarchar2(500),
    newvals  nvarchar2(500),
    eventdat date,
    eventid  number,
    foreign key (eventid) references BANK.bnk_event (id)
);