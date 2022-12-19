import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static HashMap<String, ArrayList<String>> set = new HashMap<>();

    // ("czy zmiana dotycząca braku konieczności umieszczania numeru oddziału nfz na
    // receptach",{"entities": [(69,72, "orgName")]}),
    public static String getTrain(String text, ArrayList<String> list, String key) {
        String[] words = text.toLowerCase().replaceAll(",", "").replaceAll("  ", " ").split(" ");
        String output = "";
        for (String word : list) {
            if (Arrays.asList(words).contains(word)) {
                for (int i = 0; i < text.length() - word.length(); i++) {
                    if (text.substring(i, i + word.length() + 1).equals(word + " ")) {
                        output += (output.length() > 2 ? "," : "") + "(" + i + "," + (i + word.length()) + ", \"" + key
                                + "\")";
                    }
                }

                // String[] tmp = text.split(word);
                // int last = 0;
                // for (int i = 0; i < tmp.length-1; i++) {
                // output+=String.valueOf(last+tmp[i].length())+"
                // ,"+String.valueOf(last+tmp[i].length()+word.length())+", "+word+" ; ";
                // last+=tmp[i].length()+word.length()+1;
                // }
            }
        }
        return output;
    }

    public static String getName(String name) {

        switch (name) {
            case "prawo cywilne":

                return "civil_law";
            case "prawo medyczne":

                return "medical_law";
            case "prawo pracy":

                return "labor_law";
            case "prawo karne":

                return "criminal_law";
            case "prawo podatkowe":

                return "tax_law";
            case "prawo farmaceutyczne":

                return "pharmaceutical_law";
            case "prawo konstytucyjne":

                return "constitutional_law";
            case "prawo administracyjne":

                return "administrative_law";
            case "prawo miädzynarodowe":

                return "international_law";

        }
        return "unknown";

    }

    public static void main(String[] args) {
        set.put("civil_law",
                new ArrayList<>(Arrays.asList("uchwał", "obejmującą", "rozporządzać", "nakładów", "hipoteki",
                        "spadkobierca", "zarządcy", "byłej", "małżonków", "odpowiedzialnością", "szacowana",
                        "wynajmujący", "odziedziczyć", "komornika", "obciążonej", "obecnych", "wydziedziczenie",
                        "rozwodowej", "dziedziczył", "własność", "odczytu", "pomoc", "wspólnotę", "oszacuje",
                        "notarialnego", "remontowego", "sprawdzić", "wspólnikiem", "piwnicy", "dobrodziejstwem",
                        "absolutorium", "matki", "kolejne", "pomieszczenie", "darowizny", "remont", "gruntowej",
                        "testament", "zobowiązuje", "osobistej", "pełnomocnictwa", "ubocznego", "konto", "wspólnych",
                        "bratu", "zarządowi", "zgadza", "elektronicznego", "doprowadzić", "należącym", "balkonu",
                        "spadkiem", "ubezwłasnowolnienia", "wspólnej", "wady", "podwyżkę", "poniesione", "sądowych",
                        "większość", "podziału", "dokonała", "koniecznym", "umorzenie", "weksla", "zebranie", "opłata",
                        "balkonów", "paneli", "komornik", "indywidualnego", "płaci", "nabył", "procesowego",
                        "utrzymania", "długów", "wypełnić", "internet", "ubezpieczeń", "zajętych", "sporządzona",
                        "metra", "pojazdu", "działkę", "płatność", "małżonki", "dokonane", "wynajmował", "wymienić",
                        "proces", "odrzucić", "skutek", "współwłasności", "zasadzie", "jednoosobowego", "dojazdu",
                        "potrzebne", "małoletnich", "przekazania", "głosu", "mieszkań", "mama", "korzystanie",
                        "majątkowy", "instalacji", "siostrze", "sądowego", "email", "służebności", "ocieplenia",
                        "czynsz", "wezwaniu", "nabywców", "parkingowych", "właściciela", "dokonania", "właścicielami",
                        "instytucja", "centralne", "obligują", "notariusza", "partycypacji", "nazwiska", "zysków",
                        "rzeczoznawca", "użytkowego", "skrzynki", "dokumentu", "osiedla", "pełnomocnictwo",
                        "komandytowej", "odpowiadać", "duża", "zarządca", "teściowa", "płacenia", "zbierania",
                        "zebrania", "wartość", "wyszczególnione", "kwot", "potwierdzeń", "poniesionych", "ponoszenia",
                        "kamienicy", "konieczny", "podjęta", "darowanie", "sióstr", "pozostawionych", "rachunków",
                        "skutkować", "skład", "właścicielce", "siostra", "rozwód", "synowi", "wnioski", "długi",
                        "sprawa", "konsekwencjami", "zachowku", "partnerską", "rodzina", "przedwstępnej", "stosownej",
                        "spadkowego", "prawie", "najemcy", "zasadnym", "uzasadnić", "dotyczącą", "kolejności",
                        "podzielić", "koniec", "ewentualnego", "zmarłym", "wyrażenie", "nieobecność", "synowie",
                        "spadkowej", "prądu", "odziedziczone", "wchodzi", "deweloper", "osobie", "ugody", "dział",
                        "testamentowe", "zmianą", "ustanowienie", "alimenty", "uiszczenia", "małżeński", "prac",
                        "wyprowadzić", "czynszu", "eksploatacyjna", "lokali", "apelację", "zachowek", "rozwodzie",
                        "hali", "zawierają", "księgi", "pozwu", "spłaty", "energii", "zasiedzenie", "alimentów",
                        "zgromadzenia", "dokonanie", "podatkowych", "byłą", "najemca", "dachu", "zebraniu", "możliwy",
                        "córce", "zaliczka", "potrzebuje", "wjazdu", "współwłaścicielami", "krąg", "nowy", "założenie",
                        "ogrzewanie", "zarządcę", "polega", "grzejnik", "okazjonalnego", "rozwodu", "możliwym",
                        "składowe", "podjęcie", "zarejestrowania", "zarząd", "uwzględnić", "uchwałą", "stwierdzenie",
                        "zamki", "własnością", "podpisuje", "krs", "skan", "nieruchomością", "ewentualnych", "sądzie",
                        "liczników", "pozew", "zasadna", "napisać", "przychodów", "lokalach", "oddanych", "końca",
                        "internetu", "regulować", "ograniczoną", "przesyłu", "testamentowego", "całości", "uprawniona",
                        "wynajmującego", "wody", "spadek", "odziedziczy", "remontu", "wstecznym", "przedawniają",
                        "będącej", "spadkobiercą", "głosów", "kosztach", "interwenienta", "podejmowanie", "rzeczy",
                        "dzieje", "doręczone", "uprawnione", "woda", "księdze", "darowizn", "wpisu", "remontowym",
                        "dłużnika", "ruchomości", "widnieje", "gazu", "spadkodawcy", "odrzuci", "związek", "umowne",
                        "notarialnych", "wejść", "adresu", "majątek", "świadków", "podział", "pani", "znajdujące",
                        "dokument", "zażądać", "dotyczący", "uzyskiwanych", "skutkuje", "współwłaścicieli", "zużycie",
                        "cenę", "gruntu", "umorzeniu", "skarbu", "sporządzone", "kredyt", "negatywnymi",
                        "wierzytelności", "spadkobiercom", "zasiedzenia", "właścicielka", "krewnej", "spadkowe",
                        "stropu", "spadkobierców", "obligacje", "uchwały", "elektrycznej", "notariuszem",
                        "notariuszowi", "dostęp", "remontowobudowlane", "synowej", "uwagę", "udziałów", "otwarciu",
                        "zasadne", "przebiegało", "rozpatrzenie", "remontowobudowlanych", "wieczystej", "otrzymane",
                        "koniecznej", "dziedziczenia", "korzysta", "pobierać", "matkę", "przedawnieniu", "chcą",
                        "opłatach", "ustalić", "poszczególnych", "odziedziczeniem", "zniesienia", "większością",
                        "właścicielowi", "niezgodnych", "przedmiotową", "przebiega", "reprezentowany", "dziedziczenie",
                        "opodatkowanie", "spadkobiercy", "notarialnej", "wyrazi", "rozprawie", "określił", "sądowa",
                        "ubieganie", "gruntową", "raty", "spłacić", "poręczyciel", "formalne", "winien", "prośbą",
                        "hipoteką", "spadkową", "procesu", "listę", "partner", "naprawy", "powiększenie",
                        "egzekucyjnych", "drodze", "ustanowienia", "darowiznę", "samochody", "formularzu",
                        "przedmiotowych", "sumy", "długu", "inwentarza", "pozwany", "darowizną", "uchwałę", "skutkiem",
                        "współmałżonku", "wprowadzenie", "wspólnego", "mieszkaniową", "członkowie", "powołaniu",
                        "sądowej", "babci", "dalszego", "zaliczki", "dziedziczyć", "miasta", "parkingowe", "kupna",
                        "pozostałych", "złożony", "dzierżawy", "syn", "doręczenie", "różnica", "mieszkaniu", "powstałe",
                        "upominawczym", "podwyżki", "pozostałymi", "uiszczać", "pierwsze", "remontowy", "przekształcić",
                        "zakup", "ojcu", "garażowej", "dokonaniem", "państwa", "koszt", "komórki", "kar", "elementy",
                        "masy", "przelewu", "sądową", "eksmisji", "testamentu", "ogrzewania", "częściach",
                        "poprzedniej", "postanowienie", "własności", "celowy", "majątkiem", "odrzucenia", "ojczym",
                        "służebnością", "opodatkowaniu", "sądowe")));
        set.put("administrative_law",
                new ArrayList<>(Arrays.asList("obecna", "architekta", "dopłaty", "sporządzenia", "współpracuje",
                        "zabaw", "granicy", "swobodnego", "obecność", "otwierania", "wglądu", "udostępnianie",
                        "nazwisko", "cele", "użyć", "ośrodka", "pisemne", "kolejowej", "pozwolenie", "rolną",
                        "kierowcy", "recepcjonistka", "odpadów", "portalu", "mieszkańców", "robót", "budowlanego",
                        "sylwetki", "odstąpić", "portal", "polegać", "pojawią", "klientów", "sposobu", "rolnej",
                        "przepływu", "niepełnoletniej", "biura", "harmonogramu", "ogrodzenia", "przetwarzania",
                        "znajdują", "żąda", "europejskiego", "klientami", "salonie", "ograniczenia", "przetwarzanie",
                        "zarejestrować", "karetkę", "pojazd", "ochronie", "konserwatora", "bankowych", "wybudować",
                        "przeznaczoną", "rady", "imię", "proporcjonalną", "wysłanym", "inna", "fizycznych", "listy",
                        "kont", "słuszne", "działaniem", "usunięcia", "umowach", "budowlane", "przenoszenia",
                        "uchylenia", "parlamentu", "budowy", "inwalidy", "zapisem", "modelowanie", "przekształcenie",
                        "agencji", "typu", "niepełnosprawnych", "diagnostycznych", "zmianami", "celów", "panipana",
                        "rekompensaty", "zakupiony", "organ", "lot", "gminie", "zamierza", "kosmetycznego", "osobowe",
                        "niebędąca", "posiadał", "zewnętrznej", "przetwarzaniem", "projekt", "drogowego", "wskazuje",
                        "zamontować", "podlegają", "dopuszczalna", "zabytków", "banku", "budowlanych", "oczerniające",
                        "parkowania", "sieci", "przepisu", "działce", "planowaną", "budowę", "możliwością", "związkuz",
                        "głos", "znanylekarzpl", "mobilny", "komisji", "salon", "dóbr", "konsumentów", "wystarczająca",
                        "wpływają", "finansowe", "kierunek", "uniemożliwić", "kabinie", "budowlany", "posiadająca",
                        "domku", "zabudowy", "wywieszenie", "prowizji", "roboty", "monitoringu", "ziemi", "okna",
                        "gmina", "pozwolenia", "opinie", "domek", "postawić", "będzie", "kartę", "internecie", "obraz",
                        "pomieszczenia", "systemów", "dojazdowej", "projektu", "wideokonferencji", "zastrzec",
                        "gospodarstwo", "elewacji", "pozwoleniu", "udostępnienie", "bilet", "oczekujących", "nabywane",
                        "wiadomości", "oznaczyć", "ukończyła", "panipanu", "budynek", "placu", "osobistych",
                        "niezgodne", "utylizację", "inspektorat", "ustawowym", "sąsiedniej", "krajowej", "salonu",
                        "niepełnoletnia", "odstąpienia", "rodo", "dyrektywy", "anonimizowania", "odbiór", "ogólne",
                        "parkingowym", "administracyjny", "zachodzi")));
        set.put("pharmaceutical_law",
                new ArrayList<>(Arrays.asList("lecznicze", "otwarcia", "letni", "razu", "auctore", "przerzucona",
                        "wziąć", "uprawnień", "numerem", "zostać", "viregytk", "diagnostycznym", "zbiorczego", "metrów",
                        "recepcie", "pro", "sprzedawany", "kryteria", "wyroby", "odpowiadające", "wyznaczone",
                        "seniorów", "importu", "iwycofanie", "gramów", "technik", "terenie", "aptekarską", "suplementy",
                        "punkt", "drugim", "aptek", "aptekarskiej", "ogólnodostępna", "jakość", "umieszczać",
                        "tabletek", "autentyczności", "przeznaczenia", "opakowania", "reklamacje", "aptecznego",
                        "rozliczeniowego", "kliniczna", "zakończeniem", "przedmiotem", "farmacji", "dystrybucyjna",
                        "hurtownik", "papierowych", "fakturach", "refundacji", "odmowę", "kupować", "wystawionego",
                        "przepakować", "kategorii", "kodu", "specjalnego", "przesunięć", "zweryfikować", "budżetu",
                        "trzeba", "receptę", "felczer", "negatywnych", "szpitalnej", "sprowadzić", "otc", "dostępny",
                        "wysłaniem", "wystawionej", "pełny", "pełnym", "rewersie", "dystrybutor", "farmaceutyczny",
                        "prowadzącym", "inspektora", "nabycie", "dawkę", "obrotu", "paszportu", "wykonuje", "kodeiny",
                        "odpady", "liczyć", "laboratorium", "substancji", "erecepcie", "przeniesieniem", "składki",
                        "przerwę", "refundowanego", "odpowiedzialne", "sprzęt", "odpowiedzialną", "spożywcze",
                        "substancje", "psychotropowych", "technika", "nierefundowane", "wykonywaniu", "określać",
                        "higieniczne", "fosforanu", "farmaceutycznymi", "aptekę", "niepełnym", "wzoru",
                        "farmaceutyczne", "preparaty", "kontroli", "kody", "drukach", "posiadający", "docelowego",
                        "rozpuścić", "właścicielskiej", "mediach", "hurtownią", "familiae", "zapotrzebowania",
                        "społecznościowych", "całego", "odpowiadają", "zrealizować", "wojewódzkiego", "wskazywać",
                        "przepisać", "refundowane", "żywieniowego", "dostosować", "książkę", "funkcjonowały", "zbywać",
                        "prowadzonych", "zestawienia", "zniżką", "ogólnodostępnej", "zezwolenia", "pociąga", "testy",
                        "jakościowe", "receptach", "farmaceutycznego", "hurtowni", "podejmując", "dawkowania",
                        "strukturze", "hurtownie", "zaopatrywać", "refundowany", "nowa", "psychotropowe", "podwójnej",
                        "funkcję", "pozostawić", "sprawozdanie", "przeniesienie", "recepturowego", "przepakowania",
                        "wpisywać", "kierownikiem", "recepta", "miejscowości", "witaminowe", "wodę", "papierowe",
                        "wyznaczoną", "trymestrze", "zastępcy", "kosmetyków", "założenia", "zamknięta", "odurzające",
                        "farmaceutycznej", "odpłatnością", "dalszej", "apteczny", "szpitalny", "wstrzymanie",
                        "znajdować", "zapotrzebowanie", "refundacja", "zgłoszeniu", "handlowousługowym", "farmacja",
                        "zapis", "izbę", "odbyciu", "refundację", "ustawie", "mineralną", "jednostek", "dystrybutora",
                        "spożywczych", "farmaceuci", "punktu", "letniego", "określoną", "gifu", "jednoosobowej",
                        "internetową", "prowadzącej", "cytostatycznych", "nip", "nabywcę")));
        set.put("labor_law",
                new ArrayList<>(Arrays.asList("ponosił", "dostarczenia", "zarządu", "korekcyjnych", "wiążąca", "formę",
                        "mobbing", "samo", "członkiem", "udania", "wolnego", "odzieży", "czasami", "złożone",
                        "zawarcie", "wynikająca", "wymiaru", "zdalna", "utraconego", "poświadczonej", "płacy",
                        "skrócić", "skorzystania", "dodatkowy", "obecnego", "odprawy", "równoważnego", "bieżącego",
                        "zmieniającego", "zmniejszyć", "wypłaconej", "ekwiwalent", "opiniach", "opisanego",
                        "wypowiedziana", "wypoczynkowych", "przywrócona", "winy", "med", "regionu", "wypoczynkowym",
                        "minimalnego", "pracownicy", "ulegnie", "zawartą", "przestój", "dyskryminację", "praca",
                        "potrącić", "poinformowania", "zależności", "niewykorzystany", "bezrobotna", "traktowana",
                        "dotyczyć", "przyczyn", "planem", "bezrobotnych", "terminem", "opieką", "wezwać", "premii",
                        "wprowadzić", "ochronę", "przewidzianego", "otrzymywania", "przemieszcza", "limit", "zadaniowy",
                        "zachowaniem", "bhp", "regulamin", "nałożenia", "maja", "zmieniające", "kapitałowych",
                        "wycofać", "straci", "pracują", "listu", "torbę", "zachowaniu", "przedłużony",
                        "przysługującego", "podpisanie", "komisja", "dodatkowego", "skierowanych", "wymaganego",
                        "cywilnoprawnych", "zakazie", "harmonogram", "odpowiedniej", "zwolniony", "intencyjnego",
                        "piersią", "pracowała", "pary", "zapewnienie", "brakiem", "przysługiwało", "warunków", "raz",
                        "ważnych", "podpisze", "zawodowego", "spotkać", "przedstawienia", "zaprzestania", "organizacji",
                        "nova", "przebywając", "późniejszym", "emerytalna", "wysłać", "świadectwo", "wadę", "pełni",
                        "podobnych", "grudnia", "przedsiębiorstwie", "zajścia", "chcąc", "trzynastki", "zaległy",
                        "urlopów", "dostarczyć", "niepełnosprawności", "pracowniczych", "zastosowanie", "stanowiska",
                        "planów", "wypowiedzeniu", "firmie", "odmówi", "miejscach", "aktualnego", "bezpłatny", "zmianę",
                        "obniżenie", "rozpocząć", "zarobków", "powód", "miesięczny", "stosunek", "znajduje",
                        "zmniejszony", "udzieli", "zaległe", "będący", "leżących", "macierzyński", "osobistego",
                        "ustna", "przestoju", "wypoczynkowego", "narusza", "ryzykiem", "statusu", "wyczerpują",
                        "wypłacenie", "złożonego", "skrócenia", "okresowe", "uchylenie", "kontynuować", "kierownicze",
                        "maszynista", "wynosił", "nałożeniu", "zatrudnienie", "tableta", "porządkowej", "bezrobotnej",
                        "maszynistów", "zgodzić", "socjalnobytowa", "zmiana", "ochrona", "nagany", "niewykorzystanym",
                        "zmniejszenia", "ilość", "zamiarze", "podpisanego", "przysługiwałaby", "okresowych", "odbioru",
                        "wstępne", "traktowanie", "zmuszenia", "obniżyć", "członka", "stwierdzoną", "wychowawczym",
                        "socjalnych", "wskazanym", "czerwca", "mobbingu", "pieniężny", "maszynistą", "przełożonego",
                        "podstawą", "stopnia", "zakończyć", "wypłatą", "niedziele", "umiarkowanego", "wskazanego",
                        "przedstawiają", "ciążę", "obecnym", "wzroku", "przedemerytalną", "urzędzie", "nierówne",
                        "uznane", "walki", "karmienie", "porozumieniem", "rodzicielskim", "wynagrodzeniem",
                        "przewidzianym", "nieokreślony", "zmniejszenie", "przewidującego", "odprawa", "własną",
                        "określonym", "wysyłając", "zainteresowany", "płatny", "obniżeniem", "urlopem", "porozumienie",
                        "pracach", "pracownikowi", "września", "okularów", "równoważny", "ekwiwalentu", "zaległych",
                        "przedstawione", "równoważnym", "oblicza", "pracownicę", "urlopowym", "skuteczność",
                        "wynikającej", "konsekwencję", "ślub", "nadliczbowych", "rodzicielskiego", "zatrudnionym",
                        "prace", "planu", "inną", "przerw", "nowemu", "zdalnej", "zwolnieniem", "sierpnia",
                        "orzeczenie", "zakładowego", "urlopowe", "ustnej")));
        set.put("medical_law",
                new ArrayList<>(Arrays.asList("interwencji", "żądanej", "powrotem", "zakończenia", "prywatnych",
                        "urlop", "wykonane", "ministra", "stwierdzania", "uzyskaniem", "epidemiologiczną",
                        "bezpośredni", "zewnętrznych", "zapewni", "skierowanemu", "odpracować", "zakażeniem", "chorobą",
                        "podstawa", "dyżurować", "treść", "dyżurach", "nocnej", "wirusem", "odbywanie", "powodujących",
                        "wyglądają", "piśmie", "stomatologiczną", "związanym", "rodzaju", "farmaceutów",
                        "ubezwłasnowolnienie", "wiążą", "izolację", "pierwszej", "kontraktowej", "zawodach", "danym",
                        "publicznych", "kierunku", "wydruk", "decyzją", "przepracowane", "finansowane", "wizycie",
                        "kwalifikowania", "oddelegowanie", "traktować", "teleporady", "organizowane", "zasadniczego",
                        "stanowić", "zwalczaniem", "samozatrudnionych", "wezwana", "towarzyszące", "ubiegającego",
                        "obowiązkowych", "przedmiotowa", "nadzorem", "choroba", "telefonicznej", "stanu",
                        "dotychczasowych", "miesięcznego", "zgonów", "wystąpienia", "szczególnych", "egzaminu", "błędu",
                        "zrzeknie", "dentystę", "fizjoterapeuta", "wystosować", "specjalizacje", "tarczy", "uzależniać",
                        "określają", "podejrzenie", "przyznanie", "wykonujących", "odbycia", "szkolenie", "sumienia",
                        "dodatnim", "podawać", "listopada", "dziedziny", "administracyjnej", "oświadczeniu", "klauzulę",
                        "podyplomowego", "funduszem", "pisma", "zatrudniony", "ginekologii", "rachunek",
                        "kwalifikowaniu", "uprawnia", "zakaźny", "przyjmować", "spełnia", "świadomej", "polisy",
                        "domowych", "stażu", "stażysty", "uzasadnione", "samodzielnych", "zasady", "następnym",
                        "zatrudniać", "uda", "prawna", "ochronnych", "specjalisty", "odbywać", "pracującym", "drugą",
                        "studenci", "rezydentowi", "wyposażenia", "rozwiązanie", "różni", "odbywającego", "pacjentem",
                        "prezes", "przekazać", "podstawy", "służącej", "obowiązuje", "pracą", "zagwarantować", "etapie",
                        "programem", "poradni", "wystarczające", "zestawienie", "zlecenie", "zabezpieczenia", "służb",
                        "zabiegu", "ustawowego", "dofinansowania", "ukrainy", "niniejsze", "intensywnej", "głównego",
                        "szkolenia", "inspektoratu", "zawnioskować", "prywatnym", "specjalizacyjne", "godzinami",
                        "jednostką", "koronawirusa", "zakwalifikować", "związany", "rozwoju", "narodowy",
                        "stomatologiczny", "wojewoda", "kontrakcie", "higienistki", "tomografii", "dawek", "zabieg",
                        "przedłużyć", "ww", "trzeciej", "dotyczą", "wynosić", "poprzednich", "pracować", "podyplomowym",
                        "stomatologicznej", "podstawę", "pełnił", "tydzień", "kwalifikowanie", "szpitalem", "zejścia",
                        "konieczności", "maksymalny", "polskiego", "neurologicznym", "prowadząca", "powyższe",
                        "prowadzonego", "zewnętrznego", "powyższego", "poz", "zdrowie", "wypisu", "ubiegania",
                        "pracujący", "szczególności", "tytułu", "dyżur", "ankiet", "wskazane", "przepisach", "wirusa",
                        "pełnienia", "oddziałem", "małoletniego", "dane", "opłacania", "upływie", "wypełnienia",
                        "udostępnienia", "udzielaniu", "państwowego", "skierowaniu", "mieć", "indywidualnej",
                        "priorytetem", "uzależnień", "wydając", "przyczyny", "leczniczy", "kierować", "rezydenci",
                        "pacjentek", "objętych", "niedopełnienie", "zdrowotnego", "uznać", "musiałby", "wymagana",
                        "propozycja", "terytorium", "data", "wykonanie", "przyjmowania", "wyznaczyć", "skierować",
                        "rentgenowskie", "protetyczne", "obowiązują", "stawienia", "epidemią", "teleporadę",
                        "kontraktu", "zgonu", "szczepieniem", "wykonywanie", "wymagania", "szkoleniu", "izba", "kursy",
                        "zaistniałych", "wprowadzeniem", "programie", "szczepienie", "przepis", "zmian", "sądowi",
                        "konflikt", "psychologicznym", "covidowych", "stawkę", "badań", "zakwalifikowania", "członków",
                        "oczekuje", "ponosić", "kryzysowej", "pełnej", "działać", "cofnięcie", "okazało", "icd",
                        "starych", "dyżuru", "będąca", "oddziałach", "ukończył", "kwarantannie", "fantoma", "kontaktu",
                        "załączenia", "posiadaną", "dniu", "karty", "pacjentce", "wizyt", "oddelegowaniem", "ustalania",
                        "ldek", "aplikacji", "małżonka", "ograniczeń", "ratownik", "polski", "lat", "ratunkowego",
                        "przeprowadzeniu", "stażysta", "wymiarze", "powołać", "dowodu", "kontrast", "ankieta", "pełnić",
                        "końcowego", "prawnym", "zwalnia", "cywilnoprawnej", "objęty", "psychoterapeutą", "estetycznej",
                        "pisemnej", "asystentki", "przekształconym", "podmiotem", "stronie", "wyraził", "wyrażenia",
                        "północy", "wystąpić", "jednostki", "osobą", "wynik", "liczony", "zgodzie", "ankiety",
                        "rozliczenie", "antykryzysowej", "nocnych", "podmiocie", "programu", "temperatury",
                        "patriotyczny", "polisę", "przeciwdziałaniem", "przedstawić", "wydłuża", "prowadzącemu",
                        "używania", "wyniku", "epidemiologiczne", "udzielenia", "wojewody", "pełnego", "sanepidu",
                        "obecną", "praktyka", "nosić", "potrzeby", "wpisany", "uznana", "tajemnicą", "wizytę",
                        "neurologii", "systemu", "zobowiązanie", "przychodnia", "dodatkowe", "zmusić", "zainstalowania",
                        "przyjęcia", "dezynfekować", "potrącać", "zaleceniami", "szczękowotwarzowej", "nieletni",
                        "minimalną", "akcji", "sorze", "uzyskaniu", "masażu", "aneks", "wypłacił", "r", "odbywa",
                        "kwalifikacyjne", "odbycie", "wypłacane", "miesiąca", "szkoleniowy", "staży", "chodzi",
                        "roszczeniami", "pracowników", "składania", "wynikiem", "sanepid", "dziennych", "wyszedł",
                        "lekarzem", "psychiatrę", "zeznań", "czas", "pieczątki", "uprawniony", "centrum", "naruszenie",
                        "korony", "ponownego", "konkurencji", "ministerstwo", "społecznego", "przeprowadzenie",
                        "medyczna", "kontakt", "stycznia", "epidemiologicznej", "pielęgniarki", "jaką",
                        "dofinansowanie", "uregulowana", "asystent", "nowe", "dokumentacje", "epidemiologicznego",
                        "przekazana", "zgoda", "zejście", "postępuje", "kwalifikacyjnych", "nowych", "pojechać",
                        "certyfikat", "listopad", "szpitalnym", "przyjść", "uczestniczyć", "przekierowanie", "grudzień",
                        "zadań", "całą", "wypłacenia", "posługiwać", "zapisać", "potwierdzeniu", "sarscov",
                        "poniedziałki", "wyznaczonego", "chorych", "samodzielnego", "narazić", "partnerem", "zakaźną",
                        "pełniony", "odbywała", "sanitarnego", "zaświadczenia", "placówce", "pacjentką", "pielęgniarkę",
                        "samego", "wymaganych", "zacząć", "komputerowej", "rezydenturę", "informować", "powinno",
                        "wypłacić", "poniedziałek", "zleceniodawcę", "chorego", "kierownik", "bon", "zajęć", "nocneji",
                        "leczeniem", "rzecznik", "niefinansowanym", "wywołanych", "udzielenie", "przebywać", "oddziału",
                        "współpracy", "muszą", "roszczenie", "nadzór", "specjalistę", "pediatrii", "sanitarnych",
                        "cofnąć", "uwagi", "zawarta", "potraktowane", "rezydentury", "standardów", "ciągłości",
                        "wpłynąć", "podmiot", "świadczenie", "program", "zapłacić", "podstawowego", "zaszczepić",
                        "prywatny", "wypłacać", "fizjoterapeutów", "specjalista", "covidowego", "skierowany", "pes",
                        "refundacyjne", "terapię", "wskazanej", "położnictwa", "szyba", "warunki", "świątecznej",
                        "opisu", "rozumieniu", "osobę", "odrobienia", "zapobieganiem", "wpostępowaniu", "domowej",
                        "systemie", "formy", "funduszu", "przyjąć", "obecnej", "marca", "przechowywać", "wcześniejszej",
                        "urlopu", "domową", "leczniczym", "wydłużenia", "rozpoczęcia", "psychologa", "narodowym",
                        "udzielania", "kwarantannę", "obejmować", "rejestr", "zewnętrznym", "uzupełnienia",
                        "znieczulenia", "twierdzącej", "zgodę", "ankiecie", "dokumentacja", "miejsca", "normy",
                        "funkcji", "covidowy", "złożenia", "rezydent", "praktyką", "tymczasowym", "być", "odmowie",
                        "innych", "pacjentami", "dodatkowych", "pacjentowi", "maseczek", "przesłanki", "datą",
                        "nieprzestrzeganie", "covidowa", "ciągu", "rozwiąże", "numeru", "mocy", "kwalifikować",
                        "komory", "kwarantanną", "przejmowania", "jednym", "obowiązkowego", "system", "wyjątki",
                        "delegować", "dawki", "wykonania", "natychmiastowe", "możliwe", "zewnętrzny", "wystawione",
                        "kryzysowych", "lekarzom", "udziela", "zarządzenia", "zalecenia", "niebędących", "wysokość",
                        "dyżurze", "historii", "szczepieniach", "ii", "organu", "prokuraturę", "niewynikającym", "zol",
                        "ubezwłasnowolniona", "staż", "wątpliwości", "stażyście", "obowiązków", "szczepień",
                        "podejrzeniem", "pacjenci", "zrezygnuje", "obowiązkowej", "oprzyznanie", "lekarze", "jednostce",
                        "wypłaty", "dokumentacją", "etatu", "błąd", "otrzymanego", "powinny", "doświadczenie",
                        "zajmowania", "podania", "nową", "podwyższyć", "pracownikom", "test", "służbowe", "rodzinie",
                        "wojewodę", "miesiące", "pełnienie", "biegłego", "zatrudnionej", "przepracowany", "postąpić",
                        "zrezygnować", "uzupełnić", "najniższego", "pracującemu", "mających", "funkcjonuje",
                        "kształtować", "specjalistów", "dyżurowania", "wykwalifikowanego", "zaszczepiona",
                        "rozwiązaniach", "ubezpieczycielowi", "przedłużenia", "kurs", "interesów", "aptece", "bonu",
                        "dentysta", "podyplomowy", "specjalizacyjnego", "zagrożeniem", "odmawia", "opisywać",
                        "odpowiedzieć", "zaświadczenie", "obecności", "macierzystym", "utraci", "stanowisku",
                        "personelu", "wynika", "przestać", "hiperbarycznej", "udostępniania", "zatrudniona",
                        "nieskuteczne", "leczniczej", "ratunkowym", "opiekuna", "mailowy", "wysyłania", "klauzuli",
                        "stosować", "rezydentom", "objęta", "prowadzącego", "dentysty", "optout", "specjalistycznej",
                        "świadczyć", "przeznaczone", "skierowanie", "wychowuje", "podać", "grupy", "pozarezydenckim",
                        "potwierdzonym", "miesiąc", "zakażonych")));
        set.put("criminal_law",
                new ArrayList<>(Arrays.asList("ludzi", "przyjęć", "okręgowy", "specjalizacji", "wykonywać", "miał",
                        "prawną", "aktach", "zwolnieniu", "działania", "lekarza", "jakie", "zeznania", "nosa",
                        "odsetki", "fakt", "znamiona", "odszkodowania", "środka", "zajmująca", "termin", "choroby",
                        "szesnastolatek", "ścigania", "stawiennictwa", "wypełnia", "zwrot", "informacji", "policjant",
                        "koronawirusem", "wykonywania", "zwolnić", "wydania", "życia", "stawiennictwo", "uczynić",
                        "pacjentkę", "zaskarżenia", "pracownika", "dokumentację", "groźba", "pytać", "wniesienie",
                        "noszenia", "informacje", "żądać", "skazującego", "świadka", "sprzeciwu", "kształtują",
                        "instancji", "świadek", "przebywa", "zakaz", "oddelegować", "chce", "sytuacją", "domu",
                        "podejrzanego", "pielęgniarek", "rezydenckiej", "popełnieniu", "prokurator", "sąd", "zakazu",
                        "wyegzekwować", "prowadzi", "mogłaby", "prawnych", "ogólnych", "charakterze", "kwarantanny",
                        "wizyty", "przewiduje", "apteki", "specjalizację", "zawiadomienie", "pismo", "prawne", "innym",
                        "pacjentki", "kodeksu", "ustalenia", "rodzic", "oddelegowania", "płyty", "przesłuchania",
                        "zwłok", "wolności", "umiejętnościami", "popełnienia", "sekcji", "niezakrywającym", "seniora",
                        "zapobieganiu", "opinii", "rozmowę", "rozpoznanie", "warszawie", "specjalizacją", "przemoc",
                        "orzeczenia", "przeprowadzenia", "zaistniałą", "złamanie", "zdecyduje", "zatrudnionego",
                        "ciąży", "środków", "dyscyplinarną", "towarów", "zgody", "poinformować", "pracodawcę",
                        "zwalczaniu", "lekarz", "przestępstwa", "prawnika", "wskazano", "poweźmie", "otrzymanym",
                        "ubezpieczenie", "zmarłego", "podanej", "pismem", "odzyskać", "dobrowolnej", "żonie",
                        "transportem", "organom", "organów", "ponosi", "dokonać", "maseczki", "wezwaniem", "czuje",
                        "rzecznika", "momentu", "pieniądze", "ewentualne", "psycholog", "odpowiedzialności",
                        "obowiązywać", "dnia", "udzielić", "pracodawca", "czynu", "okolicznościach", "uznania",
                        "dotyczącymi", "zamieszkania", "stanowi", "pokryłby", "pożyczek", "nastolatka", "klientowi",
                        "ocenie", "wygląda", "zawiesić", "kosztów", "oddział", "czynności", "opinię", "zbliżania",
                        "złożyć", "osobom", "adres", "utrudnia", "skierowania", "medyczną", "karnego", "sytuacjach",
                        "epidemii", "medycznej", "komorniczej", "ciężkiego", "dłużnik", "lekarskiego", "przesłuchanie",
                        "uprawnienia", "zasadach", "okręgowego", "ustawy", "grozi", "okaże", "karnym", "współżyła",
                        "sytuacja", "prowadzić", "prokuraturze", "środki", "postępowaniu", "wykroczenia", "rozumieć",
                        "skazania", "kraju")));
        set.put("international_law",
                new ArrayList<>(Arrays.asList("ocenę", "bezpieczeństwa", "sprzedawane", "kosmetyczne", "importer",
                        "artykułu", "sprowadzający", "rękawice", "konkurencyjna", "polsce", "ochronne", "granicami",
                        "udzielać", "wielkiej")));
        set.put("tax_law", new ArrayList<>(Arrays.asList("rozszerzyć", "jedzenia", "osoba", "kwoty", "działalność",
                "zobligowany", "standardową", "wyrażone", "obowiązku", "recepty", "secure", "fiskalnych", "podstawie",
                "mieszkania", "elektronicznej", "niepublicznym", "rozliczać", "nieruchomości", "fakturę", "ceidg",
                "gospodarczej", "zwolnienia", "ramach", "kwotę", "paragony", "lekarską", "podlega", "lipca", "leki",
                "zakupu", "opieki", "nabywcą", "skarbowego", "należności", "pkd", "posiadania", "recept", "koszty",
                "leczniczego", "rejestrować", "robić", "jedną", "praktykę", "lex", "zakładzie", "prawidłowe",
                "samochodu", "korzystać", "apteka", "można", "spółka", "kasę", "działalności", "rejestru", "fakturze",
                "kas", "fiskalną", "związku", "podatku", "zwolniona", "lekarzy", "dostawy", "córka", "sprzedaży",
                "przysługuje", "paragonu", "akcyzowych", "emeryturze", "kasie", "zobowiązana", "przychodu", "dotyczy",
                "papierowej", "podatkowa", "naczelnik", "pobierane")));
        set.put("constitutional_law", new ArrayList<>(Arrays.asList("konstytucją", "powrocie", "wyjść", "przepisy")));
        // set.put("unknown", new
        // ArrayList<>(Arrays.asList("klientka","umowy","może","klientkę","zgodnie","wyjśc","klientka","charakter","świadka","lekarz")));

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("train.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(records.get(1).get(2));
        int i = 0;

        for (List<String> record : records) {
            if (i == 2000)
                return;
            String tmp = record.get(1);
            String key = getName(tmp);
            if (key == null)
                continue;
            ArrayList<String> values = set.get(key);
            if (values == null)
                continue;
            Collections.shuffle(records);
            // ("czy zmiana dotycząca braku konieczności umieszczania numeru oddziału nfz na
            // receptach",{"entities": [(69,72, "orgName")]}),
            String output = getTrain(record.get(0), values, key);
            if (output.length() < 2)
                continue;
            System.out.println("(\"" + record.get(0) + "\",{\"entities\": [" + output + "]}),");
            i++;
        }
        System.out.println(records.size());

    }
}
