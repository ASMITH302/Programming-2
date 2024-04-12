package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Models RunningComp entities
 *
 * @author Martin Gallacher
 * @author Bobby Law
 */
public class RunningComp {
    private int id;
    private String season;
    private String competition;
    private String venue;
    private int rank;
    private List<Runner> runners;

    /**
     * The default RunningComp constructor
     */
    public RunningComp() {
        this.id = 0;
        this.season = null;
        this.competition = null;
        this.venue = null;
        this.rank = 0;
        this.runners = new ArrayList<>();
    }

    /**
     * A constructor which accepts season, competition and opponent values
     */
    public RunningComp(String season, String competition, String venue, int rank) {
        this.id = 0;
        this.season = season;
        this.competition = competition;
        this.venue = venue;
        this.rank = rank;
        this.runners = new ArrayList<>();
    }

    /**
     * A constructor which accepts id, competition, venue and result values
    */
   public RunningComp(int id, String season, String competition, String venue, int rank) {
       this.id = id;
       this.season = season;
       this.competition = competition;
       this.venue = venue;
       this.rank = rank;
       this.runners = new ArrayList<>();
   }

    /**
     * A getter for id values
     */
    public int getId() {
        return id;
    }

    /**
     * A setter method for id values
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A getter for season values
     */
    public String getSeason() {
        return season;
    }

    /**
     * A setter method for season values
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * A getter for competition values
     */
    public String getCompetition() {
        return competition;
    }

    /**
     * A setter method for competition values
     */
    public void setCompetition(String competition) {
        this.competition = competition;
    }

    /**
     * A getter for opponent values
     */
    public String getVenue() {
        return venue;
    }

    /**
     * A setter method for opponent values
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * A getter for result values
     */
    public int getRank() {
        return rank;
    }

    /**
     * A setter method for result values
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * A getter for players values
     */
    public List<Runner> getRunners() {
        return this.runners;
    }

    /**
     * A setter method for players values
     */
    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    /**
     * Adds a supplied Runner object to the players attribute
     */
    public void addRunnerToComp(Runner player) {
        this.runners.add(player);
    }

    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {
        return super.toString() + "\nstr: " + this.runners + this.venue + this.season + this.competition + this.id + this.rank;
    }
}
