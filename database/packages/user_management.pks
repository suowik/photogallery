CREATE OR REPLACE PACKAGE user_management
IS
PROCEDURE register (
  name VARCHAR2,
	surname VARCHAR2,
	email VARCHAR2,
	password VARCHAR2
);

PROCEDURE remove(
	p_email VARCHAR2
);

Function Login(
	p_login VARCHAR2,
	p_password VARCHAR2
) RETURN USERS%rowtype;

FUNCTION findAlbums(
	email VARCHAR2
) RETURN SYS_REFCURSOR;
End;
