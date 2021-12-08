package bauklotzProjekt;
import java.util.Scanner;
import java.lang.Integer;

public class Cli {
    private Scanner scanner = new Scanner(System.in);
    private static Robot robot;
    private boolean on = true;


    public Cli(){
        robot = new Robot(new Client(5005));
        System.out.println("Verbunden mit Roboter");
        System.out.println("Help für alle Befehle");
        menu();

    }

    private void menu(){
        while(on){
            String command = scanner.next();
            switch (command) {
                case "Help":
                    help();
                    break;
                case "1":
                    geschwindigkeitSetzen();;
                    break;
                case "2":
                    commandoEingeben();
                    break;
                case "3":
                    on = false;
                    robot.disconnect();
                    break;

            }
        }
    }


    private void help(){
        System.out.println("1 um die Geschwindigkeit zu setzen \n" +
                "2 für commando Eingabe \n" +
                "3 zum disconnect");
    }

    private void geschwindigkeitSetzen(){
        System.out.println("Geben Sie die Geschwindigkeit in Prozent an");
        robot.setSpeed(scanner.next());

    }

    private void commandoEingeben(){
        System.out.println("Geben Sie Ihren Befehl an");
        String message = null;
        while(message == null) {
            message = scanner.nextLine();
        }
        robot.send(message);
    }
}
