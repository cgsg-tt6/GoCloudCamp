import java.util.Scanner;

import static java.lang.System.exit;

public class Client {
    /**
     * Функция, запускающая цикл, принимающий запросы пользователя.
     */
    public void run() {
        Playlist p = new Playlist();
        Scanner sc = new Scanner(System.in);
        int lastind = 0;
        while (sc.hasNext()) {
            switch (sc.nextLine()) {
                case "AddSong" -> {
                    System.out.println("Input path:");
                    p.add(sc.nextLine());
                }
                case "Play" -> {
                    p.play(lastind);
                }
                case "Pause" -> {
                    System.out.println("Pause is absolutely ready yet...");
                }
                case "Next" -> {
                    if (lastind == p.size() - 1) {
                        lastind = 0;
                    } else {
                        lastind += 1;
                    }
                    System.out.println("Next: Not ready yet...");
                }
                case "Prev" -> {
                    if (lastind == 0) {
                        lastind = p.size() - 1;
                    } else {
                        lastind -= 1;
                    }
                    System.out.println("Prev: Not ready yet...");
                }
                case "Ind" -> {
                    System.out.println("Index:"+lastind+"\nSize:"+p.size());
                }
                case "exit", "Exit" -> {
                    exit(0);
                }
            }
        }
    }

}
