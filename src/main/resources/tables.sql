create table BANK.cntc
(
    id        INT           NOT NULL AUTO_INCREMENT primary key,
    idntno    nvarchar(100) unique,
    idnttyp   nvarchar(1)   not null,
    custno    nvarchar(100) unique,
    custtyp   nvarchar(1)   not null,
    dob       date          not null,
    frstnam   nvarchar(100) not null,
    lstnam    nvarchar(100) not null,
    addressid int,
    constraint fk_address foreign key (addressid) references address (id)
);

create table BANK.address
(
    id      INT           NOT NULL AUTO_INCREMENT primary key,
    cntry   nvarchar(100) not null,
    prvnc   nvarchar(100) not null,
    cty     nvarchar(100) not null,
    strt    nvarchar(100) not null,
    alley   nvarchar(100) not null,
    no      int(3)        not null,
    postcod nvarchar(100) not null
);

create table BANK.card
(
    cardno     nvarchar(16) primary key,
    pmntappno  nvarchar(100) not null,
    pmntapptyp int(1)        not null,
    isudt      date          not null,
    expdt      date          not null,
    cvv        nvarchar(100) not null,
    pin1       nvarchar(100) not null,
    pin2       nvarchar(100),
    hldrid     nvarchar(10),
    custno     nvarchar(100) not null,
    foreign key (hldrid) references BANK.cntc (id)
);