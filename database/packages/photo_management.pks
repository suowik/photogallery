create or replace 
PACKAGE photo_management
IS
Procedure Add (
  user_mail VARCHAR2,
  album_name VARCHAR2,
  p_title VARCHAR2,
  p_description VARCHAR2,
  p_filename VARCHAR2,
  p_place VARCHAR2
);

Procedure Remove(
	p_name VARCHAR2
);
END;