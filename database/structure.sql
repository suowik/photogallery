CREATE SEQUENCE  "PHOTOGALLERY"."ALBUM_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 200 NOORDER  NOCYCLE ;
CREATE SEQUENCE  "PHOTOGALLERY"."PHOTO_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


CREATE TABLE "PHOTOGALLERY"."USERS" 
   (	"EMAIL" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"NAME" VARCHAR2(40 BYTE) NOT NULL ENABLE, 
	"SURNAME" VARCHAR2(60 BYTE) NOT NULL ENABLE, 
	"PASSWORD" VARCHAR2(40 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "USERS_PK" PRIMARY KEY ("EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
--albumy  
  
  CREATE TABLE "PHOTOGALLERY"."ALBUMS" 
   (	"ALBUM_ID" NUMBER NOT NULL ENABLE, 
	"USER_MAIL" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"NAME" VARCHAR2(250 BYTE) NOT NULL ENABLE, 
	"AUD_CREATE" DATE NOT NULL ENABLE, 
	"DESCRIPTION" VARCHAR2(800 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "ALBUMS_PK" PRIMARY KEY ("ALBUM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "ALBUMS_USERS_FK" FOREIGN KEY ("USER_MAIL")
	  REFERENCES "PHOTOGALLERY"."USERS" ("EMAIL") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

  CREATE OR REPLACE TRIGGER "PHOTOGALLERY"."ALBUM_ID_TRIGGER" 
BEFORE INSERT ON ALBUMS 
REFERENCING OLD AS old NEW AS new 
FOR EACH ROW 
BEGIN
  IF :new.album_id is NULL THEN
    SELECT ALBUM_ID_SEQ.nextval INTO :new.album_id FROM dual;
  END IF;
END;
/
ALTER TRIGGER "PHOTOGALLERY"."ALBUM_ID_TRIGGER" ENABLE;

--fotki

CREATE TABLE "PHOTOGALLERY"."PHOTOS" 
   (	"PHOTO_ID" NUMBER NOT NULL ENABLE, 
	"ALBUM_ID" NUMBER NOT NULL ENABLE, 
	"FILENAME" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"DESCRIPTION" VARCHAR2(250 BYTE), 
	"AUD_CREATE" DATE NOT NULL ENABLE, 
	"PLACE" VARCHAR2(200 BYTE), 
	 CONSTRAINT "PHOTOS_PK" PRIMARY KEY ("PHOTO_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "PHOTOS_ALBUMS_ID" FOREIGN KEY ("ALBUM_ID")
	  REFERENCES "PHOTOGALLERY"."ALBUMS" ("ALBUM_ID") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

  CREATE OR REPLACE TRIGGER "PHOTOGALLERY"."PHOTO_ID_TRIGGER" BEFORE INSERT ON PHOTOS 
REFERENCING OLD AS old NEW AS new 
FOR EACH ROW 
BEGIN
   IF :new.photo_id is NULL THEN
    SELECT PHOTO_ID_SEQ.nextval INTO :new.photo_id FROM dual;
  END IF;
END;
/
ALTER TRIGGER "PHOTOGALLERY"."PHOTO_ID_TRIGGER" ENABLE;







