INSERT INTO Pracownik (imie, nazwisko) VALUES ('Jan', 'Kowalski');
INSERT INTO Pracownik (imie, nazwisko) VALUES ('Anna', 'Nowak');

INSERT INTO GrupaStudencka (nazwa) VALUES ('Informatyka 1A');
INSERT INTO GrupaStudencka (nazwa) VALUES ('Informatyka 1B');

INSERT INTO Przedmiot (nazwa) VALUES ('Bazy Danych');
INSERT INTO Przedmiot (nazwa) VALUES ('Programowanie w Java');

INSERT INTO Przydzial (pracownik_id, grupa_studencka_id, przedmiot_id) VALUES (1, 1, 1);
INSERT INTO Przydzial (pracownik_id, grupa_studencka_id, przedmiot_id) VALUES (2, 2, 2);/* Przykładowe dane do testów
