create or replace 
PACKAGE user_management
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

Procedure Login(
	P_Login In Varchar2 ,
	P_Password In Varchar2 ,
  O_Name Out Varchar2 ,
  o_surname OUT varchar2 
);

PROCEDURE findAlbums(
	email IN VARCHAR2,
	albums OUT SYS_REFCURSOR 
);
End;