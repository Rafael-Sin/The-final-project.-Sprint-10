import java.util.Scanner;

public class Main {
    static StepTracker stepTracker = new StepTracker();


    public static void main(String[] args) {
        int goalDay = 10000;
        printHello();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (true) {
            if (userInput == 1) {
                menuDataEntry();
                // переходим к вводу данных за определенный день\месяц
            } else if (userInput == 2) {
                menuStatic();
                // переходим к выводу статистики за какой то месяц
            } else if (userInput == 3) {
                changingGoalDay ();
                // переходим к изменению цели за день
            } else if (userInput == 0) {
                System.out.println("\n Программа завершена, возвращайтесь!");
                return;
            } else {
                System.out.println("\n Неизвестная команда");
            }
            printMenu();
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
    }
    static void printHello() {
        System.out.println("\nДобро пожаловать в программу подсчета шагов за 2022 год!");
        System.out.println("Вы сможете контролировать количество шагов за каждый день/месяц и не только");
        System.out.println("Также Вам будет доступна удобная статистика!");
        System.out.println("Ниже, вы увидите меню управления");
        System.out.println("Также стоит отметить, ваша стандартная цель - "+stepTracker.goalDays+" шагов в день, Вы сможете изменить эту цель в пункте меню!");
    }
    private static void printMenu() {
        System.out.println("\nОсновное меню");
        System.out.println("Укажите какой пункт меню вам нужен?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("0 - Выйти из приложения.");
    }
    public static void menuDataEntry() {
        System.out.println("\n Вы находитесь в меню ввода данных по количеству шагов");
        while (true) {
            System.out.println("Укажите число от 1 до 12 (где 1 - Январь, а 12 - Декабрь) необходимого месяца");
            Scanner scanner = new Scanner(System.in);
            int month = scanner.nextInt();
            System.out.println("Укажите день (от 1 до 30) за который вводятся данные");
            int day = scanner.nextInt();
            System.out.println("Укажите количество шагов в данный день");
            int step = scanner.nextInt();
            if ((month>0 && month < 13) && (day>0 && day <31) && (step> 0)) {
                stepTracker.monthToData[month-1].insertDayStep(day,step);
                System.out.println("Вы внесли данные за "+day+"."+month+".2022 Количество шагов: "+stepTracker.monthToData[month-1].dayStep[day-1]);
                // проверяем корректность ввода даты и данных и отправляем в stepTracker
                System.out.println("Желаете ввести данные за другую дату? (0 - нет, выход в основное меню | любое число - для продолжения)");
                int commandExit = scanner.nextInt();
                if (commandExit>0) {
                } else if (commandExit == 0) {
                    break;
                }

            } else {
                System.out.println("Некорректный ввод даты или количества шагов");
                System.out.println("Для выхода в Основное меню - введите: 0");
                System.out.println("Для повторного ввода - введите любую цифру");
                int commandExit = scanner.nextInt();
                if (commandExit == 0) {
                    break;
                }
            }
        }

    }
    private static void menuStatic() {
        printMenuStaticMonth();
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        if (command == 0) {
            System.out.println("Вы выходите в главное меню");
        } else if (command > 0 && command <13) {
            stepTracker.monthToData[command-1].allStatic();
        } else {
            System.out.println("Вы ввели неверный номер месяца");
            System.out.println("Сейчас вы вернетесь в основное меню");
        }
    }
    private static void printMenuStaticMonth() {
        System.out.println("\nВы находитесь в меню статистики");
        System.out.println("За какой месяц вас интересует статистика? (введите цифру соответствующую номеру месяца)");
        System.out.println("1 - Январь | 2 - Февраль | 3 - Март");
        System.out.println("4 - Апрель | 5 - Май | 6 - Июнь");
        System.out.println("7 - Июль | 8 -Август | 9 - Сентябрь");
        System.out.println("10 - Октябрь | 11 - Ноябрь | 12 - Декабрь");
        System.out.println("0 - Выход в предыдущее Основное меню");
    }
    private static void changingGoalDay() {
        while (true) {
            System.out.println("Сейчас ваша ежедневная цель - "+stepTracker.goalDays);
            System.out.println("Введите новую цель по количеству шагов в день:");
            Scanner scanner = new Scanner (System.in);
            int goalIf = scanner.nextInt();
            if (goalIf > 0) {
                stepTracker.goalDays = goalIf;
                System.out.println("Новая ежедневная цель - "+stepTracker.goalDays+" шагов");
                return;
            } else {
                System.out.println("Вы ввели отрицательное число");
            }
        }
    }
  }
