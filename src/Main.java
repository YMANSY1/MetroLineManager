import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> Line1 = new ArrayList<>(Arrays.asList("Helwan", "Ain Helwan", "Helwan University",
                "Wadi Hof", "Hadayek Helwan", "El Maasara", "Tora El Asmant", "Kotsika", "Tora El Balad",
                "Sakanat El Maadi", "Maadi", "Hadayek El Maadi", "Dar El Salam", "El Zahraa", "Mar Girgis",
                "El Malek El Saleh", "Al Sayyeda Zeinab", "Saad Zaghloul", "Sadat", "Gamal Abdel Nasser",
                "Orabi", "Al Shohadaa", "Ghamra", "El Demerdash", "Manshiet El Sadr", "Kobri El Qobba",
                "Hammamat El Qobba", "Saray El Qobba", "Hadayek El Zaitoun", "Helmeyet El Zaitoun",
                "El Matareyya", "Ain Shams", "Ezbet El Nakhl", "El Marg", "New El Marg"));
        ArrayList<String> Line2 = new ArrayList<>(Arrays.asList(
                "El Mounib", "Sakiat Mekky", "Omm El Masryeen", "El Giza",
                "Faisal", "Cairo University", "El Bohoth", "Dokki",
                "Opera", "Sadat", "Mohamed Naguib", "Attaba",
                "Al Shohadaa", "Masarra", "Road El Farag", "St Teresa",
                "Khalafawy", "Mezallat", "Kolleyyet El Zeraa","Shubra El Khema"
        ));
        ArrayList<String> Line3 = new ArrayList<>(Arrays.asList("Attaba", "Bab El Shaaria", "Abdou Pasha",
                "El Geish", "El Abbassia", "Cairo Fair", "Stadium", "Koleyet El Banat", "Al Ahram",
                "Haroun", "Heliopolis", "Alf Maskan", "Helmeyet El Zaitoun", "Hadayeq El Kobba",
                "El Sabtiyya", "Wadi El Nile", "Kit Kat", "Tawfiqiyya", "Bulaq", "El Bohoth",
                "Cairo University", "Rod El Farag Axis", "Bab El Shaaria", "Attaba", "El Shams Club",
                "Al Nozha", "Nadi El Shams", "Al Haykestep", "Omar Ibn El Khattab", "Qobaa",
                "Hesham Barakat", "Adly Mansour"));

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
        int stops= abs(Line2.indexOf(entry)-Line2.indexOf(exit));
        int price;
        if (stops<=9) price=6;
        else if (stops>=10 && stops<=18) price=12;
        else price=18;
        System.out.println("You will arrive at you destination after "+stops+" stops.\n"+
                "Your price is "+price+"\n");
        System.out.println("You route:");
        List<String> yourstops;
        if (Line2.indexOf(entry)<Line2.indexOf(exit)) {
            yourstops = Line2.subList(Line2.indexOf(entry), Line2.indexOf(exit) + 1);
            System.out.println(yourstops);
        }
        else {
            yourstops = Line2.subList(Line2.indexOf(exit), Line2.indexOf(entry) + 1);
            Collections.reverse(yourstops);
            System.out.println(yourstops);
        }

    }
}
