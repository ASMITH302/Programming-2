package daos;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.RunningComp;
import model.Runner;

public class SQLDAO extends DAO {
    static private final String userName = "root";
    static private final String password = "";
    static private final String url = "jdbc:mysql://localhost:3306/runningComps";
    //static private final String url = "jdbc:mariadb://localhost:3306/runningComps";
    static private Connection connection = null;

    public SQLDAO() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to database");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<RunningComp> getRunningComps() {
        List<RunningComp> runningCompList = new ArrayList<>();
        try {
            //String queryString = "SELECT * FROM RUNNINGCOMPS ORDER BY RUNNINGCOMPID ";
            Statement stmt = connection.createStatement();
            String queryString = "CALL GETRUNNINGCOMPS()";
            ResultSet rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                int runningCompId = rs.getInt("RUNNINGCOMPID");
                String season = rs.getString("SEASON");
                String competition = rs.getString("COMPETITION");
                String venue = rs.getString("VENUE");
                int rank = rs.getInt("RANK");
                RunningComp runningComp = new RunningComp(runningCompId, season, competition, venue, rank);
                runningCompList.add(runningComp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return runningCompList;
    }

    public List<Runner> getRunningCompRunners(int runningCompId) {
        List<Runner> runners = new ArrayList<>();
        //String queryString = "SELECT * FROM RUNNERS WHERE RUNNINGCOMPID = ?  "
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL GETRUNNINGCOMPRUNNERS()";
            ResultSet rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                int runnerNumber = rs.getInt("RUNNERNUMBER");
                String runnerName = rs.getString("RUNNERNAME");
                String gender = rs.getString("GENDER");
                Runner runner = new Runner( runnerNumber, runnerName, runningCompId, gender);
                runners.add(runner);
            }
        } catch(SQLException ex){System.out.println(ex.getMessage());}
        return runners;
    }

    @Override
    public void addRunningComp(RunningComp runningComp) {

    }

    @Override
    public void addRunner(Runner runner) {

    }

    @Override
    public RunningComp getRunningComp(int runningCompId) {
        return null;
    }
    
}