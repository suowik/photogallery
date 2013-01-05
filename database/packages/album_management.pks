create or replace 
PACKAGE album_management
IS
Procedure AddAlbum (
  p_user_mail VARCHAR2,
	P_Name Varchar2,
  p_description VARCHAR2
);

Procedure Remove(
	p_id NUMBER
);

Function Findphotos(
	p_id NUMBER
) Return Sys_Refcursor;
END;