create or replace 
PACKAGE BODY ALBUM_MANAGEMENT AS

  Procedure AddAlbum (
  p_user_mail VARCHAR2,
	P_Name Varchar2,
  p_description VARCHAR2
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

  Function Findphotos(
	p_id NUMBER
) Return Sys_Refcursor As
  p_recordset SYS_REFCURSOR;
  Begin
    Open P_Recordset For
    select * from Photos where Album_Id = p_id;
    RETURN p_recordset;
  END Findphotos;

END ALBUM_MANAGEMENT;