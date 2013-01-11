create or replace 
PACKAGE album_management
IS
Procedure AddAlbum (
  p_user_mail IN VARCHAR2,
  P_Name IN Varchar2,
  p_description IN VARCHAR2
);

Procedure Remove(
	p_id NUMBER
);

PROCEDURE Findphotos(
  email VARCHAR2,
  album_name VARCHAR2,
  photos OUT SYS_REFCURSOR
);
END;