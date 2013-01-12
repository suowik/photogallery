CREATE OR REPLACE
PACKAGE BODY EVENTS_MANAGEMENT AS

  PROCEDURE findAll(events OUT SYS_REFCURSOR) AS
  Begin
    OPEN events FOR SELECT user_id,event_key, aud_create FROM EVENTS, Event_Types where Event_Types.Event_Type_Id= events.event_type_ID ;
  END findAll;

END EVENTS_MANAGEMENT;