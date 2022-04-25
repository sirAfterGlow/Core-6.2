import java.util.Scanner;

class Main {
    public static void printMenu(){
        System.out.println();
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать ситему налогооблажения");
    }

    public static int calcProfitTax(int prof){
        return (prof * 6) / 100;
    }

    public static int calcDiffTax(int diff){
        int tax = (diff * 15) / 100;
        if(tax > 0) return tax;
        else return 0;
    }

    public static void printBestTax(int profTax, int diffTax){
        if(profTax <= diffTax){
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + profTax + " рублей");
            System.out.println("Налог на другой системе: " + diffTax + " рублей");
            System.out.println("Экономия: " + (diffTax - profTax) + " рублей");
        }else {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + diffTax + " рублей");
            System.out.println("Налог на другой системе: " + profTax + " рублей");
            System.out.println("Экономия: " + (profTax - diffTax) + " рублей");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int profit = 0;
        int consumption = 0;

        while(true){
            printMenu();
            String input = scanner.nextLine();
            if(input.equals("end")) break;

            switch(input){
                case "1":
                    System.out.println("Введите Ваш доход");
                    profit += Integer.parseInt(scanner.nextLine());
                    break;

                case "2":
                    System.out.println("Введите Ваш расход");
                    consumption += Integer.parseInt(scanner.nextLine());
                    break;

                case "3":
                    int profTax = calcProfitTax(profit);
                    int diffTax = calcDiffTax(profit - consumption);
                    printBestTax(profTax, diffTax);
                    break;

                default:
                    System.out.println("Ошибка выбора операции");
            }
        }

        System.out.println("Программа завершена!");
    }
}