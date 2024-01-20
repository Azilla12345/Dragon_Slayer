import java.util.Scanner;

public class DragonSlayer {
    Scanner myScanner = new Scanner(System.in);

    int action;

    Room floor = new Room(0);

    boolean gameRunning = true;
    Player player1 = new Player();

    public void runGame() throws InterruptedException {

        System.out.print("What do you call yourself?: ");
        player1.setName(myScanner.nextLine());
        System.out.println("Player 1: " + player1.name);


        for(int i = 0; i <= 3; i++) {
            System.out.println("Loading...");
            Thread.sleep(500);
        }
        System.out.println();

        boolean inRound = false;
        Dragon enemy = new Dragon(floor);
        Dragon boss = new Dragon(floor);

        while (gameRunning) {
            if (inRound) {
                if ((floor.getFloor() == 6) || (player1.health <= 0)) {
                    gameRunning = false;
                } else {
                    System.out.println("There are " + enemy.amount + " dragons");
                    System.out.print("Pick action: 1.Attack, 2. Guard, 3. Heal:  ");
                    action = myScanner.nextInt();
                    player1.action(action);
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
                if (floor.getFloor() == 5) {
                    boss.boss();
                }
            }
        }

        System.out.println("You got to floor " + floor.getFloor());



    }

}
