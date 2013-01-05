create or replace 
PACKAGE BODY USER_MANAGEMENT AS

  PROCEDURE register (
  name VARCHAR2,
	surname VARCHAR2,
	email VARCHAR2,
	password VARCHAR2
) AS
  BEGIN
    INSERT INTO users values(email, name, surname, password);
  END register;

  PROCEDURE remove(
	p_email VARCHAR2
) AS
  Begin
    DELETE FROM USERS where p_email=email;
  END remove;

  Procedure Login(
	P_Login In Varchar2 ,
	P_Password In Varchar2 ,
  O_Name Out Varchar2 ,
  o_Surname Out Varchar2 
) As
  Name Varchar2(255);
  Surname Varchar2(255);
  Invalid_Credentials Exception;
  Begin
    Select Name, Surname Into O_Name, O_Surname From Users Where Email=P_Login And P_Password=Password;
    EXCEPTION
       When No_Data_Found  Then
       Raise Invalid_Credentials;

  END login;

  FUNCTION findAlbums(
	email VARCHAR2
) Return Sys_Refcursor As
  BEGIN
    /* TODO implementation required */
    RETURN NULL;
  END findAlbums;

END USER_MANAGEMENT;