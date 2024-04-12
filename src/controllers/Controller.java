package controllers;

import helpers.InputHelper;
import model.RunningComp;
import model.Runner;
import repositories.Repository;

import java.util.List;

public class Controller {
    private Repository repository;

    public Controller() {repository = new Repository();}

    public void run() {
        boolean finished = false;
        InputHelper inputHelper = new InputHelper();
        do {
            System.out.print("\nA. List RunningComp");
            System.out.print("\tB. Add RunningComp");
            System.out.print("\tC. Add Runner");
            System.out.print("\tQ. Quit\n");
            char choice = inputHelper.readCharacter("Enter choice", "ABCQ");
            switch (choice) {
                case 'A':
                    listRunningComps();
                    break;
                case 'B':
                    addRunningComp();
                    break;
                case 'C':
                    addRunner();
                    break;
                case 'Q':
                    finished = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (!finished);
    }

    private void listRunningComps() {
        System.out.println("List Running Competitions");
        System.out.println("=========================");
        List<RunningComp> runningComps = repository.getRunningComps();
        System.out.println(runningComps);
    }

    private void addRunningComp() {
        System.out.println("Add Running Competition");
        System.out.println("=======================");
        InputHelper inputHelper = new InputHelper();
        String Season = inputHelper.readString("Enter new season");
        String Competition = inputHelper.readString("Enter new competition");
        String Venue = inputHelper.readString("Enter new venue");
        int Rank = inputHelper.readInt("Enter new rank");
        RunningComp newRunningComp = new RunningComp(Season, Competition, Venue, Rank);
        repository.addRunningComp(newRunningComp);
    }

    private void addRunner() {
        System.out.println("Add Runner");
        System.out.println("==========");
        // Complete this method
        InputHelper inputHelper = new InputHelper();
        int runnerNumber = inputHelper.readInt("Enter new runner number");
        String runnerName = inputHelper.readString("Enter new runner name");
        int runningCompId = inputHelper.readInt("Enter new runningCompId");
        String gender = inputHelper.readString("Enter new runner gender");
        Runner newRunner = new Runner(runnerNumber, runnerName, runningCompId, gender);
        repository.addRunner(newRunner);
    }

    private RunningComp findRunningComp() {
        InputHelper inputHelper = new InputHelper();
        RunningComp requiredRunningComp;
        int runningCompId;
        do {
            runningCompId = inputHelper.readInt("Enter Running Competition Id (0 to Quit)");
            if (runningCompId != 0) {
                requiredRunningComp = repository.getRunningCompId(runningCompId);
                if (requiredRunningComp != null)
                    return requiredRunningComp;
                else
                    System.out.println("Running Competition Not Found");
            }
        } while (runningCompId != 0);
        return null;
    }
}
