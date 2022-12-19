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
                        "rozwodowej", "dziedziczył", "własność", "odczytu", "pomoc")));
        set.put("administrative_law",
                new ArrayList<>(Arrays.asList("obecna", "architekta", "dopłaty", "sporządzenia", "współpracuje",
                        "zabaw", "granicy", "swobodnego", "obecność", "otwierania", "wglądu", "udostępnianie",
                        "nazwisko", "cele", "użyć", "ośrodka", "pisemne", "kolejowej")));
        set.put("pharmaceutical_law",
                new ArrayList<>(Arrays.asList("lecznicze", "otwarcia", "letni", "razu", "auctore", "przerzucona",
                        "wziąć", "uprawnień", "numerem", "zostać", "viregytk", "diagnostycznym", "zbiorczego", "metrów",
                        "recepcie", "pro", "sprzedawany", "kryteria", "wyroby")));
        set.put("labor_law",
                new ArrayList<>(Arrays.asList("ponosił", "dostarczenia", "zarządu", "korekcyjnych", "wiążąca", "formę",
                        "mobbing", "samo", "członkiem", "udania", "wolnego", "odzieży", "czasami", "złożone",
                        "zawarcie", "wynikająca", "wymiaru", "zdalna", "utraconego", "poświadczonej")));
        set.put("medical_law",
                new ArrayList<>(Arrays.asList("interwencji", "żądanej", "powrotem", "zakończenia", "prywatnych",
                        "urlop", "wykonane", "ministra", "stwierdzania", "uzyskaniem", "epidemiologiczną",
                        "bezpośredni", "zewnętrznych", "zapewni", "skierowanemu", "odpracować", "zakażeniem", "chorobą",
                        "podstawa", "dyżurować", "treść", "dyżurach")));
        set.put("criminal_law",
                new ArrayList<>(Arrays.asList("ludzi", "przyjęć", "okręgowy", "specjalizacji", "wykonywać", "miał",
                        "prawną", "aktach", "zwolnieniu", "działania", "lekarza", "jakie", "zeznania", "nosa",
                        "odsetki", "fakt", "znamiona", "odszkodowania", "środka", "zajmująca", "termin", "choroby",
                        "szesnastolatek", "ścigania", "stawiennictwa", "wypełnia", "zwrot", "informacji", "policjant",
                        "koronawirusem", "wykonywania", "zwolnić")));
        set.put("international_law",
                new ArrayList<>(Arrays.asList("ocenę", "bezpieczeństwa", "sprzedawane", "kosmetyczne", "importer",
                        "artykułu", "sprowadzający", "rękawice", "konkurencyjna", "polsce", "ochronne", "granicami",
                        "udzielać", "wielkiej")));
        set.put("tax_law", new ArrayList<>(Arrays.asList("rozszerzyć", "jedzenia", "osoba", "kwoty", "działalność",
                "zobligowany", "standardową", "wyrażone", "obowiązku", "recepty", "secure", "fiskalnych", "podstawie",
                "mieszkania", "elektronicznej", "niepublicznym", "rozliczać", "nieruchomości", "fakturę", "ceidg",
                "gospodarczej", "zwolnienia", "ramach", "kwotę", "paragony", "lekarską", "podlega", "lipca", "leki",
                "zakupu", "opieki", "nabywcą", "skarbowego", "należności", "pkd", "posiadania", "recept", "koszty")));
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
            if (i == 217)
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
