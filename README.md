# store-service

Napisana aplikacja jest prostym system do obsługi zamówień w sklepie.
Napisana jest w całości w Javie. 
Dane dodawane w formularzu trafiają do bazy danych, gdzie w poźniejszym etapie zostają poprzez odpowiednie zapytania wyświetlanie na ekranie.
Możliwości aplikacji:
- Dodanie zamówienia
- Wyświetlanie wszystkich zamówień 
- Wyświetlanie szczegółów zamówienia
- Edycja zamówienia
- Usuwanie zamówienia

Dodawanie zamówienia:
  -Aby utworzyć zamówienie potrzebne jest dodanie imienia, nazwiska, produktu.
  -Brak któregoś z pola lub zostawienie go pustego skutuje wyświetleniem komunikatu o błędnym dodaniu.

Wyświetlanie wszystkich zamówień:
  - Dane wyświetlane są w tabeli w formacie ID i nazwa produktu
 
Wyświetlanie szczegółów zamówienia:
  - Aby wyświetlić szczegóły zamówienia potrzebne jest podanie ID, które można podglądnąć w kategorii  ,,Wszystkich zamówieniach".
  - Wpisanie przypadkowego ID lub pozostawienie pustego pola skutuje wystąpieniem kontrolowanego błędu.
  
Edycja zamówienia:
  - Aby edytować zamówienie wymagane jest podanie ID, następnie podajemy nowe dane : imię, nazwisko i nowy produkt.
  - Gdy pole ID pozostanie puste lub ID edytowane nie istnieje w bazie zostaje wyświetlony kontrolowany błąd.
  - Wszystkie dane muszą być wpisane aby edytować zamówienie.
  
 Usuwanie zamówienia:
  - Aby usunąć zamówienie potrzebne jest podanie jego ID.
  - Pozostawienie pustego pola lub wpisanie nieprawidłowego ID skutuje wystąpieniem kontrolowanego błędu.
  
