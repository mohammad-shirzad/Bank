create or replace procedure
    find_customers(p_customerNo in varchar2,
                   p_identityNo in nvarchar2,
                   p_customerTypeValue in char,
                   p_identityTypeValue in char,
                   p_cursor out sys_refcursor)
as
begin
    open p_cursor for select *
    from BNK_CUSTOMER c
    where (p_customerNo is null or c.CUSTNO = p_customerNo)
      and (p_customerTypeValue is null or c.CUSTTYPE = p_customerTypeValue)
      and (p_identityNo is null or c.IDNTNO = p_identityNo)
      and (p_identityTypeValue is null or c.IDNTYP = p_identityTypeValue);
end;
