import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

   static HashMap<String, ArrayList<String>> set = new HashMap<>();

// ("czy zmiana dotycząca braku konieczności umieszczania numeru oddziału nfz na receptach",{"entities": [(69,72, "orgName")]}),
   public static String getTrain(String text, ArrayList<String> list, String key){
       String[] words =text.toLowerCase().replaceAll(",","").replaceAll("  "," ").split(" ");
       String output="";
       for (String word : list) {
           if(Arrays.asList(words).contains(word)){
               for (int i = 0; i < text.length()-word.length(); i++) {
                   if(text.substring(i,i+word.length()+1).equals(word+" ")) {
                       output+= (output.length()>2?",":"")+"("+i+","+(i+word.length())+", \""+key+"\")";
                   }
               }

//               String[] tmp = text.split(word);
//               int last = 0;
//               for (int i = 0; i < tmp.length-1; i++) {
//                   output+=String.valueOf(last+tmp[i].length())+" ,"+String.valueOf(last+tmp[i].length()+word.length())+", "+word+" ; ";
//                   last+=tmp[i].length()+word.length()+1;
           //    }
           }
       }
       return output;
   }

   public static String getName(String name){

       switch (name){
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
        set.put("civil_law", new ArrayList<>(Arrays.asList("rozporządzać", "spadkodawcy", "dziedziczenie", "uchwałą", "nabywców", "pomieszczenie", "notarialnych", "córce", "poręczyciel", "ojczym")));
        set.put("administrative_law", new ArrayList<>(Arrays.asList("sieci", "salonu", "granicy", "domek", "ochronie", "przetwarzaniem", "żąda", "mieszkańców", "proporcjonalną", "celów")));
        set.put("pharmaceutical_law", new ArrayList<>(Arrays.asList("odpowiedzialne", "nabycie", "importu", "spożywczych", "paszportu", "społecznościowych", "gramów", "otwarcia", "żywieniowego", "punktu")));
        set.put("labor_law", new ArrayList<>(Arrays.asList("limit", "macierzyński", "organizacji", "przedsiębiorstwie", "kontynuować", "maja", "skrócić", "dyskryminację", "potrącić", "niedziele")));
        set.put("medical_law", new ArrayList<>(Arrays.asList("danym", "wynik", "różni", "utraci", "indywidualnej", "zagrożeniem", "wysyłania", "oddziału", "dowodu", "programu")));
        set.put("criminal_law", new ArrayList<>(Arrays.asList("organom", "ścigania", "zgody", "okręgowego", "pracodawcę", "zakazu", "ciężkiego", "seniora", "ponosi", "prokurator")));
        set.put("international_law", new ArrayList<>(Arrays.asList("wielkiej", "artykułu", "polsce", "granicami", "udzielać", "importer", "konkurencyjna", "bezpieczeństwa", "sprowadzający", "rękawice")));
        set.put("tax_law", new ArrayList<>(Arrays.asList("kas", "fiskalną", "elektronicznej", "przychodu", "paragony", "apteka", "zwolnienia", "naczelnik", "rejestrować")));
        set.put("constitutional_law", new ArrayList<>(Arrays.asList("powrocie", "konstytucją", "przepisy", "wyjść")));
       // set.put("unknown", new ArrayList<>(Arrays.asList("klientka","umowy","może","klientkę","zgodnie","wyjśc","klientka","charakter","świadka","lekarz")));

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
        //System.out.println(records.get(1).get(2));
        int i=0;

        for (List<String> record : records) {
            if(i==217)return;
            String tmp = record.get(1);
            String key =getName(tmp);
            if(key==null )continue;
            ArrayList<String> values=set.get(key);
            if(values==null)continue;
            Collections.shuffle(records);
           // ("czy zmiana dotycząca braku konieczności umieszczania numeru oddziału nfz na receptach",{"entities": [(69,72, "orgName")]}),
           String output=getTrain(record.get(0),values,key);
           if(output.length()<2)continue;
            System.out.println("(\""+record.get(0)+"\",{\"entities\": ["+output+"]}),");
            i++;
        }
        System.out.println(records.size());


    }
}
