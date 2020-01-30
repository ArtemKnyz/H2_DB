import BL.UTIL;
import ent.TRANSLATE;
import service.TransService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class mainDo {
    int id;
    static String rus_word;
    static String eng_word= null;
    static String comment= null;


    // input words in DB

    boolean mainCheck = true;
    String addSymbol = "add";
    String getAll = "getAll";

    //ввод слов в базу данных

    static void addSymbol() {
        boolean check = true;
        Scanner scan = new Scanner(System.in);
        while (check) {
            System.out.print("Хотите ввести новую запись? Нажмите 1: ");
            int printSymbol = scan.nextInt();
            if (printSymbol == 1) {
                TransService transService = new TransService();
                TRANSLATE translate = new TRANSLATE();
                System.out.print("введите русское слово  rus_word: ");
                scan.nextLine();
                rus_word = scan.nextLine();
                translate.setRus_word(rus_word + "\n");
                System.out.print("введите английский перевод: ");
                eng_word = scan.nextLine();
                translate.setEng_word(eng_word + "\n");
                System.out.print("введите комментарии: ");
                comment = scan.nextLine();
                translate.setComment(comment + "\n");
                try {
                    transService.add(translate);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Ввод в Базу Данных закончен.");
                check = false;
                //break;
            }
        }
        scan.close();
    }

    public static void main(String[] args) {

        int chooseSymbol=1;
        boolean ch = true;
        /*while (ch) {
            Scanner scan = new Scanner(System.in);*/
            System.out.println("1. Добавить запись в базу данных");
            System.out.println("2. Получить имеющиеся слова");
           // chooseSymbol = scan.nextInt();
            //chooseSymbol = 0;
           /* try {
                chooseSymbol = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("какая то ошибка");
            }*/

            switch (chooseSymbol) {
                case 1:
                    addSymbol();
                    break;
                case 2:
                    getAll();
                    break;
                default:
                    System.out.println("Just nothing");
            }
            ch=true;
            chooseSymbol = 0;
           //scan.close();
        }




            static void getAll() {
                TransService transService = new TransService();
                TRANSLATE translate = new TRANSLATE();
                try {
                    transService.getAll();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("в базе ничего нет");
                }
            }


    }

