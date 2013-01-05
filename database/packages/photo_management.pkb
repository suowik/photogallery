create or replace 
PACKAGE BODY ALBUM_MANAGEMENT AS

  Procedure AddAlbum (
  p_user_mail IN VARCHAR2,
	P_Name IN Varchar2,
  p_description IN VARCHAR2
) AS
  Begin
    INSERT INTO ALBUMS values (ALBUM_ID_SEQ.nextval, p_user_mail, p_name, sysdate, p_description);
  END AddAlbum;

Procedure Remove(
	p_id NUMBER
) AS
  Begin
    DELETE FROM ALBUMS WHERE ALBUM_ID = p_id;
  END Remove;

PROCEDURE Findphotos(
	email VARCHAR2,
  album_name VARCHAR2,
  photos OUT SYS_REFCURSOR
) AS
  Begin
    OPEN photos FOR SELECT * FROM PHOTOS WHERE album_id = (SELECT album_id FROM ALBUMS WHERE ALBUMS.name = album_name AND ALBUMS.user_mail = email);
  END Findphotos;

END ALBUM_MANAGEMENT;