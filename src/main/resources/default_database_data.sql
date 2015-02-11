DROP TABLE IF EXISTS Vozidlo;

CREATE TABLE Vozidlo (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    spz VARCHAR(7) NOT NULL,
    znacka VARCHAR(50) NOT NULL,
    typ VARCHAR(50),
    farba VARCHAR(50),
    kategoria VARCHAR(10),
    UNIQUE (spz)
);

INSERT INTO Vozidlo (spz, znacka, typ, farba, kategoria)
VALUES 
('PO000AA', 'Škoda', 'Fabia', 'zelená', 'B'),
('PO123BC', 'Toyota', 'Auris', 'čierna', 'B'),
('PO734DE', 'Java', 'Babetta', 'červená', 'A'),
('PO898FA', 'Zetor', 'Proxima', 'červená', 'T'),
('PO235CX', 'Renault', 'Thalia', 'strieborná', 'B');

SELECT * FROM Vozidlo;

DROP TABLE IF EXISTS Instruktor;

CREATE TABLE Instruktor (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    meno VARCHAR(50),
    priezvisko VARCHAR(50) NOT NULL,
    kontakt VARCHAR(50)
);

INSERT INTO Instruktor (meno, priezvisko, kontakt)
VALUES 
('Anton', 'Šofér', '0918121321'),
('František', 'Traktorista', NULL),
('Jozef', 'Krajňák', '0908152345'),
('Miroslav', 'Slovák', '0915904678'),
('Martina', 'Balážová', '0902458324');

SELECT * FROM Instruktor;

DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    meno VARCHAR(50),
    priezvisko VARCHAR(50) NOT NULL,
    datumNarodenia DATE,
    bydlisko VARCHAR(127),
    kontakt VARCHAR(50),
    prvaPomoc BOOLEAN,
    pocetPokusov INT,
    pocetBodov INT,
    cvicisko BOOLEAN,
    jazda BOOLEAN
);

INSERT INTO Student (meno, priezvisko, datumNarodenia, bydlisko, kontakt, prvaPomoc, pocetPokusov, pocetBodov, cvicisko, jazda)
VALUES
('Jozef', 'Múdry', '19940303', 'Námestie Kráľovnej Pokoja 2, Prešov', '0905321123', 1, 0, 0, 0, 0),
('Šimon', 'Krátky', '19900412', 'Záhradná 51, Kapušany', '0908357567', 0, 0, 0, 0, 0),
('Tomáš', 'Novotný', '19921127', 'Dubová 4, Prešov', '0915245331', 1, 1, 55, 1, 1),
('Jakub', 'Bednár', '19950228', 'Sibírska 31, Prešov', '0918903486', 1, 1, 53, 1, 0),
('Ján', 'Novák', '19940119', 'Hlavná 129, Prešov', '0948110239', 1, 2, 53, 1, 1);

SELECT * FROM Student;

DROP TABLE IF EXISTS Skuska;

CREATE TABLE Skuska (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    datum DATE,
    cas TIME,     
    instruktorId BIGINT NOT NULL REFERENCES Instruktor(id),
    komisar BIGINT NOT NULL REFERENCES Komisari(id)
);

INSERT INTO Skuska (datum, cas, instruktorId, komisar)
VALUES
('20140212', '070000', 2, 1),
('20140212', '080000', 3, 2),
('20140212', '090000', 2, 1),
('20140212', '100000', 1, 3),
('20141128', '073000', 4, 1);

SELECT * FROM Skuska;

DROP TABLE IF EXISTS Komisari;

CREATE TABLE Komisari (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    meno VARCHAR(50),
    priezvisko VARCHAR(50) NOT NULL,
    hodnost VARCHAR(10)
);

INSERT INTO Komisari (meno, priezvisko, hodnost)
VALUES 
('Igor', 'Roth', 'mjr.'),
('Jarmila', 'Miháľová', 'pplk.'),
('Richard', 'Oľha', 'kpt.');

DROP TABLE IF EXISTS Jazda;

CREATE TABLE Jazda (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    studentId BIGINT NOT NULL REFERENCES Student(id),
    instruktorId BIGINT NOT NULL REFERENCES Instruktor(id),
    vozidloId BIGINT NOT NULL REFERENCES Vozidlo(id),
    datum DATE,
    cas TIME, 
    km INT,
    vPremavke BOOLEAN,
    naCvicisku BOOLEAN,
    sVozikom BOOLEAN
);

INSERT INTO Jazda (studentId, instruktorId, vozidloId, datum, cas, km, vPremavke, naCvicisku, sVozikom)
VALUES
(1, 3, 1, '20141125', '093000', 31, 1, 0, 0),
(1, 3, 1, '20141123', '110000', 20, 1, 0, 1),
(2, 3, 2, '20141122', '123000', 33, 1, 0, 0),
(4, 1, 1, '20141120', '150000', 18, 1, 1, 0),
(3, 2, 5, '20141019', '101500', 15, 1, 1, 0);

SELECT * FROM Jazda;

DROP TABLE IF EXISTS SkuskaStudent;

CREATE TABLE SkuskaStudent (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    skuskaId BIGINT NOT NULL REFERENCES Skuska(id),
    studentId BIGINT NOT NULL REFERENCES Student(id)
);

INSERT INTO SkuskaStudent (skuskaId, studentId)
VALUES
(1, 2),
(1, 3),
(2, 4),
(4, 1),
(5, 3);

SELECT * FROM SkuskaStudent;