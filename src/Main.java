public class Main {

    public static void main(String[] args) {
        Farm farm = new Farm();

        farm.giveBirth(1, 2, "second");
        farm.giveBirth(1, 3, "third");
        farm.giveBirth(2, 4, "four");
        farm.giveBirth(4, 5, "five");
        farm.printFarm();

        System.out.println();
        farm.endLifeSpan(2);
        farm.printFarm();

    }

}

