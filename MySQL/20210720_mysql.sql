INSERT INTO `project`.`test`
(`memo`)
VALUES
('TEST MEMO2');

UPDATE `project`.`test`
SET
`memo` = "EDIT MEMO"
WHERE `idx` = 2;

DELETE FROM project.test
WHERE idx = 2;


