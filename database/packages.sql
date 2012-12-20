CREATE OR REPLACE PACKAGE user_management
IS
PROCEDURE register (
  name VARCHAR2,
	surname VARCHAR2,
	address VARCHAR2,
	email VARCHAR2,
	password VARCHAR2
);

PROCEDURE remove(
	email VARCHAR2
);

FUNCTION login(
	login VARCHAR2,
	password VARCHAR2
) RETURN USERS%rowtype;

FUNCTION findAlbums(
	email VARCHAR2,
	count NUMBER,
	offset NUMBER
) RETURN SYS_REFCURSOR;
END;


CREATE OR REPLACE PACKAGE album_management
IS
PROCEDURE add (
	name VARCHAR2,
);

PROCEDURE remove(
	name VARCHAR2
);

FUNCTION findPhotos(
	name VARCHAR2,
	count NUMBER,
	offset NUMBER
) RETURN SYS_REFCURSOR;
END;

CREATE OR REPLACE PACKAGE photo_management
IS
PROCEDURE add (
	name VARCHAR2,
);

PROCEDURE remove(
	name VARCHAR2
);
END;
