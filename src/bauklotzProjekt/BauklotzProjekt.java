package bauklotzProjekt;

import java.util.Arrays;

public class BauklotzProjekt {
    public static void main(String[] args){
        if( Arrays.asList(args).contains("cli")) {
            new Cli();
        }
    }

    public static void test(){
        Robot robot = new Robot(new Client (5005));
    }

    public static void ersteAufgabe(){
        System.out.println("%%% Aufgabe 1 %%%");
        Client client = new Client(5005);
        client.received();
        String[] messages = {"Hello Robot", "GetStatus", "GetRobot", "SetVerbosity 0", "MoveRTJoints 10 20 10 10 10 10", "GetJointsMaxTurnMax", "Quit"};
        for(String message : messages){
            client.send(message);
        }
    }
}
