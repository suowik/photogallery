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

  Function Login(
	p_login Varchar2,
	p_password VARCHAR2
) RETURN USERS%rowtype AS
  result USERS%rowtype;
  Begin
    SELECT * INTO result FROM USERS WHERE email=p_login and p_password=password;
    RETURN result;
  END login;

  FUNCTION findAlbums(
	email VARCHAR2
) RETURN SYS_REFCURSOR AS
  BEGIN
    /* TODO implementation required */
    RETURN NULL;
  END findAlbums;

END USER_MANAGEMENT;