package udemy.generics;

/**
 *
 * @author sazizian
 */
public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("UNO-Fotbal");
        BaseballPlayer pat = new BaseballPlayer("UNO-Baseball");
        SoccerPlayer beckham = new SoccerPlayer("UNO-Soccer");

        Team<FootballPlayer> adelaideCrows = new Team<>("UNO");
        adelaideCrows.addPlayer(joe);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago-Uni");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> brokenTeam = new Team<>("UNL");
        brokenTeam.addPlayer(beckham);
//
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);
//
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
        adelaideCrows.matchResult(baseballTeam, 1, 1);
    }
}
