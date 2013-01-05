create or replace 
PACKAGE photo_management
IS
Procedure Add (
	p_name VARCHAR2
);

Procedure Remove(
	p_name VARCHAR2
);
END;