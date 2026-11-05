CREATE TABLE  Pracownik (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imie VARCHAR(255),
    nazwisko VARCHAR(255)
);

CREATE TABLE  GrupaStudencka (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazwa VARCHAR(255)
);

CREATE TABLE  Przedmiot (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazwa VARCHAR(255)
);

CREATE TABLE  Przydzial (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pracownik_id BIGINT,
    grupa_studencka_id BIGINT,
    przedmiot_id BIGINT,
    FOREIGN KEY (pracownik_id) REFERENCES Pracownik(id),
    FOREIGN KEY (grupa_studencka_id) REFERENCES GrupaStudencka(id),
    FOREIGN KEY (przedmiot_id) REFERENCES Przedmiot(id)
    z_bledami BOOLEAN DEFAULT FALSE,
    komunikaty_bledow VARCHAR(1000),

    CREATE TABLE Przedmiot (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazwa VARCHAR(255),
    wersja BIGINT DEFAULT 0

);
