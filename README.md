# UniProject
[KRYSTIAN] Moduł Bazy Danych i Encji (db & persistence)
[ ] src/main/resources/schema.sql (Skrypt tworzący tabele i relacje SQL)
[ ] src/main/resources/data.sql (Przykładowe dane do testów)
[ ] src/main/resources/application.properties (Konfiguracja połączenia z bazą danych)
[ ] src/main/java/com/uczelnia/plan/model/Employee.java (Model encji Pracownik)
[ ] src/main/java/com/uczelnia/plan/model/StudentGroup.java (Model encji Grupa studencka)
[ ] src/main/java/com/uczelnia/plan/model/Course.java (Model encji Przedmiot)
[ ] src/main/java/com/uczelnia/plan/model/Assignment.java (Model encji Przydział / Obsada)
[ ] src/main/java/com/uczelnia/plan/repository/EmployeeRepository.java (Repozytorium pracownika)
[ ] src/main/java/com/uczelnia/plan/repository/CourseRepository.java (Repozytorium przedmiotu)
[ ] src/main/java/com/uczelnia/plan/repository/AssignmentRepository.java (Repozytorium przydziałów)

[KLAUDIA] Silnik Obliczeń i Walidacji (core & engine)
[ ] src/main/java/com/uczelnia/plan/service/WorkloadCalculator.java (Przeliczanie roboczogodzin przedmiotu i sum pracownika)
[ ] src/main/java/com/uczelnia/plan/validation/ValidationResult.java (Obiekt zawierający stan walidacji i listę błędów)
[ ] src/main/java/com/uczelnia/plan/validation/ValidationError.java (Pojedynczy komunikat o błędzie z typem i informacją o kolorze)
[ ] src/main/java/com/uczelnia/plan/validation/CourseValidator.java (Walidacja sumy godzin przedmiotu oraz limitu 5 pracowników)
[ ] src/main/java/com/uczelnia/plan/validation/EmployeeValidator.java (Walidacja pensum pracownika: min pensum, max 3x pensum)
[ ] src/main/java/com/uczelnia/plan/validation/ScheduleConflictValidator.java (Sprawdzanie nakładania się zajęć pracownika)

[NORBERT] Raporty i Podsumowania (reports & summary)
[ ] src/main/java/com/uczelnia/plan/dto/WorkloadCardDTO.java (Struktura danych dla karty obciążenia)
[ ] src/main/java/com/uczelnia/plan/service/ReportService.java (Pobieranie i przygotowywanie danych do tabeli obciążeń)
[ ] src/main/java/com/uczelnia/plan/gui/WorkloadCardController.java (Kontroler/Widok karty obciążeń pracownika – rozbicie W/C/L/P)
[ ] src/main/java/com/uczelnia/plan/gui/SummaryOverviewController.java (Kontroler/Widok zbiórczego podsumowania wszystkich pracowników)
[ ] src/main/java/com/uczelnia/plan/gui/component/StatusCellRenderer.java (Mechanizm kolorowania wierszy/komórek w tabeli)

[DOMINIKA] Formularze, Aplikacja i Wielodostęp (ui & app core)
[ ] src/main/java/com/uczelnia/plan/Application.java (Główna klasa uruchomieniowa programu)
[ ] src/main/java/com/uczelnia/plan/gui/MainLayoutController.java (Główny okno aplikacji i menu nawigacyjne)
[ ] src/main/java/com/uczelnia/plan/gui/EmployeeFormController.java (Formularz dodawania i edycji pracownika)
[ ] src/main/java/com/uczelnia/plan/gui/CourseFormController.java (Formularz edycji przedmiotu i przydzielania prowadzących)
[ ] src/main/java/com/uczelnia/plan/service/PlanAccessService.java (Zarządzanie uprawnieniami koordynatora oraz spójnością zapisu w trybie multi-user)

Harmonogram Realizacji Projektu (np. 4 Tygodnie)

🔷 FAZA 1: Architektura, Baza Danych i Podstawy (Tydzień 1)
Cel fazy: Postawienie bazy danych, zdefiniowanie modeli w Javie i szkieletu aplikacji.
[KRYSTIAN] Baza Danych i Rejestr Modelu
[ ] Stworzyć skrypt SQL struktury bazy (src/main/resources/schema.sql) z tabelami: Pracownik, GrupaStudencka, Przedmiot, Przydzial.
[ ] Utworzyć skrypt z danymi testowymi (src/main/resources/data.sql).
[ ] Stworzyć klasy encji w Javie: Employee.java, StudentGroup.java, Course.java, Assignment.java.
[ ] Skonfigurować połączenie z bazą (application.properties).
[KLAUDIA] Interfejsy Walidatora i DTO
[ ] Stworzyć klasę wyniku walidacji ValidationResult.java oraz ValidationError.java (z kodem błędu, opisem i poziomem: BŁĄD/OSTRZEŻENIE).
[ ] Przygotować interfejsy dla klas walidujących (CourseValidator.java, EmployeeValidator.java).
[NORBERT] Makiety i DTO Raportów
[ ] Zdefiniować klasę DTO dla karty obciążenia (WorkloadCardDTO.java).
[ ] Przygotować makiety/szablony interfejsu widoku karty obciążeń i podsumowania.
[DOMINIKA] Szkielet Aplikacji i Główne Okno
[ ] Skonfigurować projekt i klasę startową (Application.java).
[ ] Stworzyć główne okno aplikacji z menu nawigacyjnym (MainLayoutController.java).

🔷 FAZA 2: Logika Biznesowa, Walidacja i CRUD (Tydzień 2)
Cel fazy: Wyliczanie roboczogodzin, weryfikacja reguł oraz formularze wprowadzania danych.
[KRYSTIAN] Repozytoria i Zapis z Błędami
[ ] Stworzyć interfejsy repozytoriów (EmployeeRepository.java, CourseRepository.java, AssignmentRepository.java).
[ ] Zapewnić mechanizm zapisu przydziału do bazy nawet wtedy, gdy walidacja zwraca błędy.
[KLAUDIA] Silnik Obliczeń i Walidacji (Core Engine)
[ ] Zaimplementować wyliczanie roboczogodzin w WorkloadCalculator.java (grupy×tygodnie×h/tyg×prowadzący).
[ ] Napisać regułę sprawdzającą zbieżność roboczogodzin przedmiotu z sumą godzin pracowników w CourseValidator.java.
[ ] Napisać regułę weryfikującą limity pensum (Pensum≤Suma≤3×Pensum) w EmployeeValidator.java.
[ ] Dodaj weryfikację limitu max 5 pracowników na przedmiot.
[NORBERT] Serwis Raportowy i Formatowanie
[ ] Zaimplementować przeliczanie godzin na semestry (zimowy/letni) i tryby (stacjonarne/niestacjonarne) w ReportService.java.
[ ] Stworzyć mechanizm kolorowania komórek/wierszy na podstawie stanu walidacji (StatusCellRenderer.java).
[DOMINIKA] Formularze Zarządzania (CRUD)
[ ] Zbudować formularze dodawania/edycji pracowników (EmployeeFormController.java).
[ ] Zbudować formularz edycji przedmiotu i przydzielania prowadzących z wprowadzaniem godzin (CourseFormController.java).

🔷 FAZA 3: Integracja, Karty Obciążeń i Podsumowania (Tydzień 3)
Cel fazy: Połączenie silnika walidacji z widokami oraz obsługa wielodostępu.
[KRYSTIAN] Obsługa Współbieżności i Trwałość
[ ] Dodać obsługę blokowania optymistycznego/transakcyjności przy edycji przedmiotów.
[ ] Przeprowadzić testy zapisu i odczytu bazy przy symulowanej pracy wielu użytkowników.
[KLAUDIA] Konflikty Harmonogramu i Testy Jednostkowe
[ ] Zaimplementować wykrywanie kolizji („zajęcia sam ze sobą”) w ScheduleConflictValidator.java.
[ ] Napisać testy jednostkowe (JUnit) dla silnika walidacji i przeliczania pensum.
[NORBERT] Widok Obciążenia Pracownika i Podsumowania Ogólnego
[ ] Dokończyć widok widoku karty obciążenia pracownika – widok tabelaryczny z rozbiciem na formy zajęć (W/C/L/P) (WorkloadCardController.java).
[ ] Zbudować zbiorczy widok podsumowania wszystkich pracowników z sygnalizacją nadmiaru/niedomiaru kolorami (SummaryOverviewController.java).
[DOMINIKA] Uprawnienia Koordynatora i Połączenie GUI z Walidacją
[ ] Zaimplementować logikę uprawnień Koordynatora (edycja tylko przypisanych przedmiotów) w PlanAccessService.java.
[ ] Połączyć formularze przydzielania z wyświetlaniem komunikatów walidatora „na żywo” (czerwony/zielony tekst pod formularzem).

🔷 FAZA 4: Testy Końcowe, Szlify i Przygotowanie do Oddania (Tydzień 4)
Cel fazy: Weryfikacja ze scenariuszem z treści zadania oraz wspólna demonstracja.
[Wszyscy – Integracja]
[ ] Przetestować scenariusz przykładowy z treści zadania:
[ ] Przedmiot Łączność w systemach radiokomunikacyjnych (497): 2h/tydz., 15 tyg., 1 grupa, 2 prowadzących = 60 roboczogodzin.
[ ] Sprawdzić wariant przydziału: Pracownik1 (30h), Pracownik2 (30h).
[ ] Sprawdzić wariant przydziału: Pracownik1 (30h), Pracownik2 (10h / 5 tyg.), Pracownik3 (20h / 10 tyg.).
[ ] Upewnić się, że błędne dane pozwalają na zapis do bazy, ale sygnalizują błąd wizualnie.
[ ] Przetestować generowanie karty obciążenia dla trybu stacjonarnego i niestacjonarnego.
[ ] Oczyścić kod, przygotować dokumentację uruchomieniową i skrypty startowe.