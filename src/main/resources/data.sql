DROP TABLE IF EXISTS TEST_TABLE_1;

CREATE TABLE TEST_TABLE_1 (
	Id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	Store_Number INT NOT NULL,
	Delivery_Stream_Number INT NOT NULL,
	Supplying_DC DECIMAL(2,1) NOT NULL,
	Start_Date DATE NOT NULL,
	End_Date DATE,
	Reason_Exclusion VARCHAR(255),
	Last_Update_By VARCHAR(255),
	Last_Update_Time TIMESTAMP
);


INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (1, 1, 5, 0, to_timestamp('18-JUL-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('25-OCT-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 1', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (2, 2, 1, 0.3, to_timestamp('01-MAY-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('16-SEP-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 2', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (3, 3, 5, 1, to_timestamp('01-AUG-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('10-SEP-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 3', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (4, 4, 2, 0.2, to_timestamp('05-JUN-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('31-AUG-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 4', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (5, 5, 8, 0.5, to_timestamp('13-JUN-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('15-SEP-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 5', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (6, 6, 2, 0.1, to_timestamp('23-JUN-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('21-SEP-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 6', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (7, 7, 3, 1, to_timestamp('15-JUL-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('22-SEP-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 7', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (8, 8, 4, 0.2, to_timestamp('24-JUL-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('30-SEP-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 8', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (9, 9, 3, 0.4, to_timestamp('05-AUG-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('10-OCT-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 9', null, null);
INSERT INTO TEST_TABLE_1(Id, Store_Number, Delivery_Stream_Number, Supplying_DC, Start_Date, End_Date, Reason_Exclusion, Last_Update_By, Last_Update_Time) VALUES (10, 10, 6, 0.4, to_timestamp('10-AUG-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), to_timestamp('15-OCT-2021 11.21.50.180000000 AM','DD-MON-RRRR HH.MI.SS.FF AM'), 'Dummy Text 10', null, null);