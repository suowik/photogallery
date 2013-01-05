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
  surname varchar2(255);
  Begin
    SELECT name, surname INTO o_name, o_surname FROM USERS WHERE email=p_login and p_password=password;
  END login;

  FUNCTION findAlbums(
	email VARCHAR2
) Return Sys_Refcursor As
  BEGIN
    /* TODO implementation required */
    RETURN NULL;
  END findAlbums;

END USER_MANAGEMENT;