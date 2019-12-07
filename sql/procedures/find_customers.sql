delimiter //

create procedure BANK.find_customers(in customerNo        nvarchar(255),
                                     in identityNo        nvarchar(255),
                                     in customerTypeValue char(1),
                                     in identityTypeValue char(1))
  begin
    select *
    from BNK_CUSTOMER c
    where (c.CUSTNO = customerNo or customerNo is null)
          and (c.CUSTTYPE = customerTypeValue or customerTypeValue is null)
          and (c.IDNTNO = identityNo or identityNo is null)
          and (c.IDNTTYTYP = identityTypeValue or identityTypeValue is null);
  end  //

delimiter ;
