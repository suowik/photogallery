create or replace 
PACKAGE BODY PHOTO_MANAGEMENT AS

  Procedure Add (
  user_mail VARCHAR2,
  album_name VARCHAR2,
  p_title VARCHAR2,
  p_description VARCHAR2,
  p_filename VARCHAR2,
  p_place VARCHAR2
) AS
    albumId NUMBER;
  BEGIN
    SELECT album_id INTO albumId FROM ALBUMS WHERE ALBUMS.USER_MAIL = user_mail AND ALBUMS.NAME = album_name;
    INSERT INTO PHOTOS(photo_id, album_id, title, filename, description,aud_create,place) VALUES(PHOTO_ID_SEQ.nextval, albumId, p_title, p_description, p_filename, sysdate, p_place);
  END Add;

  Procedure Remove(
	p_name VARCHAR2
) AS
  BEGIN
    /* TODO implementation required */
    NULL;
  END Remove;

END PHOTO_MANAGEMENT;