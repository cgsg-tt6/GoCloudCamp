/*
там короче нужно плейлист реализовать
1. просто с музыкальными данными работать - включать их, использовать в коде
2. реализовать функции play, stop, loop (возможно, просто юзая встроенные функции)
3. добавление музыки из командной строки... или из консоли... или из файла

5. когда-нибудь - графический интерфейс...

 */

/**
 * @TODO
 * переделать методы в соответствии с ТЗ (после поспроизведения данного трека автоматически воспроизводится следующий)
 * Pause
 * Next/Prev
 * Класс Client, реализация ввода команд нормальная, а не прописывать в мейне методы.
 */


/**
 * Главный класс - точка входа программы, рабтает на самом высоком абстрактном уровне.
 */
public class Main {
    public static void main(String[] args) {
        Playlist cool = new Playlist();
        cool.add("DVRST - Your name.wav");
        //cool.delete_by_id(0);
        cool.add("DVRST - Close eyes.wav");
        //cool.play(0);
        cool.playAll();
    }
}
