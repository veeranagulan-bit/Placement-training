public class AnimalFoodChainSystem {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("         ANIMAL INFORMATION & FOOD CHAIN");
        System.out.println("====================================================");

        displayAnimal(
                1,
                "Panda",
                "Eating bamboo, climbing trees, sleeping",
                "Embarrassment",
                "Bamboo",
                "20 Years",
                "Bamboo Forests",
                "1860"
        );

        displayAnimal(
                2,
                "Bison",
                "Grazing, walking with herd",
                "Herd",
                "Grass, Shrubs",
                "25 Years",
                "Grasslands",
                "500000"
        );

        displayAnimal(
                3,
                "Octopus",
                "Hunting, hiding, exploring",
                "Solitary",
                "Fish, Crabs, Shellfish",
                "5 Years",
                "Ocean",
                "300 Species"
        );

        displayAnimal(
                4,
                "Fox",
                "Hunting, running, digging dens",
                "Skulk",
                "Rabbits, Birds, Fruits",
                "10 Years",
                "Forests and Grasslands",
                "Millions"
        );

        displayAnimal(
                5,
                "Anaconda",
                "Swimming, hunting, resting",
                "Solitary",
                "Fish, Birds, Mammals",
                "30 Years",
                "Swamps and Rivers",
                "Several Thousand"
        );

        displayAnimal(
                6,
                "Green Iguana",
                "Climbing trees, basking in sun",
                "Solitary",
                "Leaves, Fruits, Flowers",
                "20 Years",
                "Rainforest",
                "Common"
        );

        displayAnimal(
                7,
                "Rhino",
                "Grazing, walking, resting",
                "Crash",
                "Grass, Plants",
                "50 Years",
                "Grasslands and Savannah",
                "27000"
        );

        System.out.println("\n====================================================");
        System.out.println("                 DAILY ROUTINES");
        System.out.println("====================================================");

        System.out.println("Panda        : Wake Up -> Eat Bamboo -> Rest -> Sleep");
        System.out.println("Bison        : Graze -> Walk -> Rest -> Graze -> Sleep");
        System.out.println("Octopus      : Hide -> Hunt -> Explore -> Rest");
        System.out.println("Fox          : Search Food -> Hunt -> Play -> Sleep");
        System.out.println("Anaconda     : Rest -> Swim -> Hunt -> Digest -> Rest");
        System.out.println("Green Iguana : Sunbathe -> Eat Leaves -> Climb -> Rest");
        System.out.println("Rhino        : Graze -> Drink Water -> Rest -> Sleep");

        System.out.println("\n====================================================");
        System.out.println("                    FOOD CHAINS");
        System.out.println("====================================================");

        System.out.println("\n1. Panda Food Chain");
        System.out.println("Bamboo --> Panda");

        System.out.println("\n2. Bison Food Chain");
        System.out.println("Grass --> Bison");

        System.out.println("\n3. Rhino Food Chain");
        System.out.println("Grass --> Rhino");

        System.out.println("\n4. Green Iguana Food Chain");
        System.out.println("Leaves/Fruits --> Green Iguana --> Anaconda");

        System.out.println("\n5. Ocean Food Chain");
        System.out.println("Plankton --> Small Fish --> Octopus");

        System.out.println("\n6. Forest Food Chain");
        System.out.println("Plants --> Rabbit --> Fox");

        System.out.println("\n====================================================");
        System.out.println("           COMBINED SIMPLIFIED FOOD CHAIN");
        System.out.println("====================================================");

        System.out.println(
                "Plants/Bamboo/Grass\n" +
                "        |\n" +
                "        v\n" +
                " Panda  Bison  Rhino  Green Iguana\n" +
                "                        |\n" +
                "                        v\n" +
                "                    Anaconda\n"
        );

        System.out.println("Ocean Chain:");
        System.out.println("Plankton -> Small Fish -> Octopus");

        System.out.println("\n====================================================");
        System.out.println("                    END REPORT");
        System.out.println("====================================================");
    }

    public static void displayAnimal(
            int number,
            String name,
            String habits,
            String family,
            String food,
            String lifespan,
            String habitat,
            String population) {

        System.out.println("\nAnimal No : " + number);
        System.out.println("Name      : " + name);
        System.out.println("Habits    : " + habits);
        System.out.println("Family    : " + family);
        System.out.println("Food      : " + food);
        System.out.println("Life Span : " + lifespan);
        System.out.println("Habitat   : " + habitat);
        System.out.println("Population: " + population);
        System.out.println("----------------------------------------------------");
    }
}