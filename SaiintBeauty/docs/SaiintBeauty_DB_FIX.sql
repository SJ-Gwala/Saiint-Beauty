-- Saiint Beauty Derby DB repair script
-- Run only the DROP statements for tables you need to rebuild.
-- Warning: DROP TABLE deletes existing data.

-- Availability: every day is open by default; this table stores CLOSED dates only.
DROP TABLE AVAILABILITY;
CREATE TABLE AVAILABILITY (
    AVAILABILITYID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    UNAVAILABLEDATE VARCHAR(50),
    UNAVAILABLE BOOLEAN
);

-- PunchCard: ID must auto-generate.
-- Drop this only if PUNCHID errors happen or table was created without identity.
DROP TABLE PUNCHCARD;
CREATE TABLE PUNCHCARD (
    PUNCHID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    PUNCHES INT,
    CLIENT_CLIENTID INT,
    SERVICE_SERVICEID INT,
    FOREIGN KEY (CLIENT_CLIENTID) REFERENCES CLIENT(CLIENTID),
    FOREIGN KEY (SERVICE_SERVICEID) REFERENCES SERVICE(SERVICEID)
);

-- Admin account seed. Use after ADMIN table exists correctly.
-- If admin already exists, do not insert again.
INSERT INTO ADMIN (USERNAME, PASSWORD) VALUES ('admin', 'admin123');
