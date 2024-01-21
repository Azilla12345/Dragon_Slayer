import java.util.Scanner;

public class DragonSlayer {
    Scanner myScanner = new Scanner(System.in);

    public static final String RESET = "\033[0m";      // Reset
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    int action;
    int topScore = 0;
    int currentScore;
    String response;
    String game;
    String scoreResponse;
    String playAgain;

    Room floor = new Room(0);

    boolean gameRunning = true;
    Player player1 = new Player();

    public void runGame() throws InterruptedException {
        System.out.println("Enter, Score, or Quit: ");
        game = myScanner.nextLine();
        while (game.equals("Score")) {
            System.out.println("The current highest score is " + YELLOW + topScore + RESET);
            System.out.println("Want to return to the menu?(Y or N): ");
            scoreResponse = myScanner.nextLine();
            if (scoreResponse.equals("Y")) {
                System.out.println("Returning to menu!");
                System.out.println("Enter, Score, or Quit: ");
                game = myScanner.nextLine();
            }
        }
        while (game.equals("Enter")) {
            System.out.println("Welcome adventurer!");
            System.out.println("Before you is a dragon's cave!");
            System.out.println("Fight your way to the nest and win!");
            System.out.println("The more gold you earn, the higher your score!");
            System.out.println("The current highest score is " + YELLOW + topScore + RESET);

            System.out.print("What do you call yourself?: ");
            player1.setName(myScanner.nextLine());
            System.out.println("Player 1: " + player1.name);


            for (int i = 0; i <= 3; i++) {
                System.out.println("Loading...");
                Thread.sleep(500);
            }
            System.out.println();

            boolean inRound = false;
            Dragon enemy = new Dragon(floor);
            Dragon boss = new Dragon(floor);
            currentScore = 0;

            while (gameRunning) {
                if (inRound) {
                    if ((floor.getFloor() == 6) || (player1.health <= 0)) {
                        game = "";
                        gameRunning = false;
                    } else {
                        System.out.println("There are " + enemy.amount + " dragons");
                        System.out.print("Pick action: " + RED + "1.Attack" + GREEN + " 2. Heal" +
                                PURPLE + " 3. Search:  " + RESET);
                        action = myScanner.nextInt();
                        player1.action(action);
                        if (action == 3) {
                            myScanner.nextLine();
                            System.out.println("Do you want to use it now? (Y if yes, N if no): ");
                            response = myScanner.nextLine();
                            if ((response.equals("Y")) || response.equals("y")) {
                                player1.heal();
                            } else {
                                System.out.println("Save it then!");
                            }
                        }
                        Thread.sleep(500);
                        if (action == 1) {
                            enemy.attacked(player1.attack());
                        }
                        Thread.sleep(500);
                        if (enemy.isDead()) {
                            player1.getLoot(enemy.loot());
                            if (enemy.allDead()) {
                                inRound = false;
                            } else {
                                enemy.standard();
                            }

                        }
                        if (floor.getFloor() == 5) {
                            if (boss.isDead()) {
                                inRound = false;
                            }
                        }
                        if (floor.getFloor() == 5) {
                            player1.attacked(boss.attack());
                        } else {
                            player1.attacked(enemy.attack());
                        }
                        System.out.println(player1.name + " health: " + player1.getHealth());
                        System.out.println();
                        Thread.sleep(500);
                    }
                } else {
                    floor.addFloor();
                    System.out.println("Moving to " + floor.getFloorName() + "\n");

                    if (floor.getFloor() == 5) {
                        System.out.print("Welcome to the shop, what upgrade do you want to purchase?: 1 - +2 attack multiplier, 2 - +10 hp: ");
                        int answer = myScanner.nextInt();
                        if (answer == 1) {
                            player1.DamageBuff(2);
                        } else if (answer == 2) {
                            player1.healthBuff(10);
                        }
                        System.out.println("Looks like your done shopping, move on to the next floor");
                        System.out.println();
                    }
                    inRound = true;
                    enemy.standard();
                    enemy.setAmount();
                    player1.setSearched();
                    if (floor.getFloor() == 5) {
                        boss.boss();
                    }
                }
            }
            System.out.println("You got to floor " + floor.getFloor());
            currentScore = player1.getGold();
            System.out.println("Your score is " + currentScore);
            if (currentScore > topScore) {
                topScore = currentScore;
                System.out.println("A new high score!");
            } else {
                System.out.println("Still a bit to go!");
            }
            myScanner.nextLine();
            System.out.println("Want to play again?(Y or N): ");
            playAgain = myScanner.nextLine();
            if (playAgain.equals("Y")) {
                System.out.println("Welcome back to the menu!");
                System.out.println("Enter, Score, or Quit: ");
                game = myScanner.nextLine();
                if (game.equals("Enter")) {
                    System.out.println("Lets start again!");
                    player1.reset();
                    gameRunning = true;
                }
            } else {
                System.out.println("See you next time!");
            }
        } if (game.equals("Quit")){
            System.out.println("See you next time!");
            return;
        }

    }

}
