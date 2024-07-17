import java.lang.reflect.Array;
import java.util.*;
import static java.lang.Math.abs;

public class Main {
    public static List<String> returnStops(int entryindex, int exitindex, ArrayList<String> Line){
        List<String> yourstops;
        if (entryindex<exitindex) {
            yourstops = Line.subList(entryindex, exitindex + 1);
            return yourstops;
        }
        else {
            yourstops = Line.subList(exitindex, entryindex + 1);
            Collections.reverse(yourstops);
            return yourstops;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> Line1 = new ArrayList<>(Arrays.asList(
                "Helwan", "Ain Helwan", "Helwan University", "Wadi Hof",
                "Hadayek Helwan", "El Maasara", "Tora El Asmant", "Kozzika",
                "Tora El Balad", "Sakanat El Maadi", "Maadi", "Hadayek El Maadi",
                "Dar El Salam", "El Zahraa", "Mar Girgis", "El Malek El Saleh",
                "Al Sayeda Zeinab", "Saad Zaghloul", "Sadat", "Nasser",
                "Orabi", "Al Shohadaa", "Ghamra", "El Demerdash",
                "Manshiet El Sadr", "Kobri El Qobba", "Hammamat El Qobba", "Saray El Qobba",
                "Hadayeq El Zaitoun", "Helmeyet El Zaitoun", "El Matareyya", "Ain Shams",
                "Ezbet El Nakhl", "El Marg", "New El Marg"
        ));
        ArrayList<String> Line2 = new ArrayList<>(Arrays.asList(
                "El Mounib", "Sakiat Mekky", "Omm El Masryeen", "El Giza",
                "Faisal", "Cairo University", "El Bohoth", "Dokki",
                "Opera", "Sadat", "Mohamed Naguib", "Attaba",
                "Al Shohadaa", "Masarra", "Road El Farag", "St Teresa",
                "Khalafawy", "Mezallat", "Kolleyyet El Zeraa","Shubra El Khema"
        ));
        ArrayList<String> Line3 = new ArrayList<>(Arrays.asList(
                "Airport", "Ahmed Galal", "Adly Mansour", "El Haykestep",
                "Omar Ibn El Khattab", "Qobaa", "Hesham Barakat", "El Nozha",
                "Nadi El Shams", "Alf Maskan", "Heliopolis Square", "Haroun",
                "Al Ahram", "Koleyet El Banat", "Stadium", "Fair Zone",
                "Abbassia", "Abdou Pasha", "El Geish", "Bab El Shaaria",
                "Attaba", "Nasser", "Maspero", "Safaa Hegazy",
                "Kit Kat", "Sudan Street", "Imbaba", "El Bohy",
                "Al Qawmeya Al Arabiya", "Ring Road", "Rod al Farag Axis", "El Tawfikeya",
                "Wadi El Nil", "Gamaat El Dowal Al Arabiya", "Bulaq El Dakroor"
        ));
        String Line1Line2="Sadat", Line1Line3="Nasser", Line2Line1="Al Shohadaa",
                Line2Line3="Attaba";
        System.out.println("What's your Entry Station?");
        String entry = scanner.nextLine().trim();
        while(!Line2.contains(entry)&&!Line1.contains(entry)&&!Line3.contains(entry)){
            System.out.println("Not a valid station, try again: ");
            entry= scanner.nextLine().trim();
        }
        System.out.println("What's your Exit Station?");
        String exit = scanner.nextLine().trim();
        while(!Line2.contains(exit)&&!Line1.contains(exit)&&!Line3.contains(exit)){
            System.out.println("Not a valid station, try again: ");
            exit= scanner.nextLine().trim();
        }
        while (entry.equalsIgnoreCase(exit)){
            System.out.println("Similar Stations, type a different Exit Station: ");
            exit= scanner.nextLine().trim();
        }
        int stops=0;
        List<String> yourstops= null;
        if (Line1.contains(entry)&&Line1.contains(exit)) {
            stops = abs(Line1.indexOf(entry) - Line1.indexOf(exit));
            yourstops= returnStops(Line1.indexOf(entry),Line1.indexOf(exit),Line1);
        }
        else if (Line2.contains(entry)&&Line2.contains(exit)) {
            stops = abs(Line2.indexOf(entry) - Line2.indexOf(exit));
            yourstops= returnStops(Line2.indexOf(entry),Line2.indexOf(exit),Line2);
        }
        else if (Line3.contains(entry)&&Line3.contains(exit)) {
            stops = abs(Line3.indexOf(entry) - Line3.indexOf(exit));
            yourstops= returnStops(Line3.indexOf(entry),Line3.indexOf(exit),Line3);
        }
        else if ((Line1.contains(entry)&&Line3.contains(exit))||
                Line3.contains(entry)&&Line1.contains(exit)) {
            if (Line1.contains(entry)) {
                stops = abs(Line1.indexOf(entry) - Line1.indexOf(Line1Line3));
                stops+=abs(Line3.indexOf(exit) - Line3.indexOf(Line1Line3));
                yourstops=returnStops(Line1.indexOf(entry), Line1.indexOf(Line1Line3),Line1);
                List<String> temp= returnStops(Line3.indexOf(Line1Line3), Line3.indexOf(exit),Line3);
                yourstops.addAll(temp);
                Set<String> tempset= new LinkedHashSet<>(yourstops);
                yourstops.clear();
                yourstops.addAll(tempset);
            }
            else{
                stops = abs(Line3.indexOf(entry) - Line3.indexOf(Line1Line3));
                stops+=abs(Line1.indexOf(exit) - Line1.indexOf(Line1Line3));
                yourstops=returnStops(Line3.indexOf(entry), Line3.indexOf(Line1Line3),Line3);
                List<String> temp= returnStops(Line3.indexOf(Line1Line3), Line1.indexOf(exit),Line1);
                yourstops.addAll(temp);
                Set<String> tempset= new LinkedHashSet<>(yourstops);
                yourstops.clear();
                yourstops.addAll(tempset);
            }
        }
        else if ((Line2.contains(entry)&&Line3.contains(exit))||
                Line3.contains(entry)&&Line2.contains(exit)) {
            if (Line2.contains(entry)) {
                stops = abs(Line2.indexOf(entry) - Line2.indexOf(Line2Line3));
                stops+=abs(Line3.indexOf(exit) - Line3.indexOf(Line2Line3));
                yourstops=returnStops(Line2.indexOf(entry), Line2.indexOf(Line2Line3),Line2);
                List<String> temp= returnStops(Line3.indexOf(Line2Line3), Line3.indexOf(exit),Line3);
                yourstops.addAll(temp);
                Set<String> tempset= new LinkedHashSet<>(yourstops);
                yourstops.clear();
                yourstops.addAll(tempset);
            }
            else{
                stops = abs(Line3.indexOf(entry) - Line3.indexOf(Line2Line3));
                stops+=abs(Line2.indexOf(exit) - Line2.indexOf(Line2Line3));
                yourstops=returnStops(Line3.indexOf(entry), Line3.indexOf(Line2Line3),Line3);
                List<String> temp= returnStops(Line2.indexOf(Line2Line3), Line2.indexOf(exit),Line2);
                yourstops.addAll(temp);
                Set<String> tempset= new LinkedHashSet<>(yourstops);
                yourstops.clear();
                yourstops.addAll(tempset);

            }
        }
        else if ((Line1.contains(entry)&&Line2.contains(exit))||
                Line2.contains(entry)&&Line1.contains(exit)) {
            if (Line1.contains(entry)) {
                stops = abs(Line1.indexOf(entry) - Line2.indexOf(Line1Line2));
                stops+=abs(Line2.indexOf(exit) - Line2.indexOf(Line1Line2));
                yourstops=returnStops(Line1.indexOf(entry), Line1.indexOf(Line1Line2),Line1);
                List<String> temp= returnStops(Line2.indexOf(Line1Line2), Line2.indexOf(exit),Line2);
                yourstops.addAll(temp);
                Set<String> tempset= new LinkedHashSet<>(yourstops);
                yourstops.clear();
                yourstops.addAll(tempset);
            }
            else{
                stops = abs(Line2.indexOf(entry) - Line2.indexOf(Line1Line2));
                stops+=abs(Line1.indexOf(exit) - Line1.indexOf(Line1Line2));
                yourstops=returnStops(Line2.indexOf(entry), Line2.indexOf(Line1Line2),Line2);
                List<String> temp= returnStops(Line1.indexOf(Line1Line2), Line1.indexOf(exit),Line1);
                yourstops.addAll(temp);
                Set<String> tempset= new LinkedHashSet<>(yourstops);
                yourstops.clear();
                yourstops.addAll(tempset);

            }

        }
        int price=(stops/9)*6;
        System.out.println("You will arrive at you destination after "+stops+" stops.\n"+
                "Your price is "+price+"\n");
        System.out.println("You route:");
        System.out.println(yourstops);

    }
}
