package Part2.gui;

package gui;

import javax.swing.*;
import java.awt.*;
import main.Horse;
import main.Race;
import main.Bet;
import java.util.ArrayList;

/**
 * Class: Frame
 * Description: JFrame that holds all of the JPanel objects
 *
 *
 * @Author Sam Chen Yu
 * @Version 1.0
 */
public class Frame extends JFrame {

    // Panels
    MainPanel mp;
    RacePanel rp;
    AddMoneyPanel ap;
    BetPanel bp;
    CustomHorsePanel chp;
    CustomTrackPanel ctp;

    // Variables
    public int accountBalance = 100;
    public ArrayList<Bet> bets = new ArrayList<>();
    Race race;
    public ArrayList<Horse> lanes;

    /**
     * Constructor that sets up the Panels
     * @param race Race object containing the horses
     */
    public Frame(Race race) {
        super("Horse Race Simulation");
        this.race = race;
        lanes = race.getLanes();
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        mainPanel();
    }

    /**
     * Method that sets up the MainPanel
     */
    public void mainPanel() {
        getContentPane().removeAll();
        mp = new MainPanel(this);
        add(mp);
        mp.setVisible(true);
        mp.accountBalanceLabel.setText("Account Balance: $" + accountBalance);
        revalidate();
        repaint();

    }

    /**
     * Method that sets up the BetPanel
     */
    public void moneyClicked() {
        getContentPane().removeAll();
        bp = new BetPanel(this, bets);
        bp.accountBalanceLabel.setText("Account Balance: $" + accountBalance);
        bp.updateTable(false);
        bp.setVisible(true);
        add(bp);
        revalidate();
        repaint();
    }

    /**
     * Method that sets up the AddMoneyPanel
     */
    public void addMoneyClicked() {
        getContentPane().removeAll();
        ap = new AddMoneyPanel(this);
        ap.setVisible(true);
        add(ap);
        revalidate();
        repaint();
    }

    /**
     * Method that sets up the CustomHorsePanel
     */
    public void customHorseClicked() {
        getContentPane().removeAll();
        chp = new CustomHorsePanel(this);
        chp.setVisible(true);
        add(chp);
        chp.startThread();
        revalidate();
        repaint();
    }

    /**
     * Method that sets up the CustomTrackPanel
     */
    public void customTrackClicked() {
        getContentPane().removeAll();
        ctp = new CustomTrackPanel(this);
        ctp.setVisible(true);
        add(ctp);
        revalidate();
        repaint();
    }

    /**
     * Method that sets up the RacePanel
     */
    public void raceClicked() {
        getContentPane().removeAll();
        rp = new RacePanel(this, race);
        rp.setVisible(true);
        if(ctp == null) {
            rp.startThread(1);
            race.setRaceLength(20);
        } else {
            rp.startThread(ctp.getTrack());
            race.setRaceLength(ctp.getTrackLength());
        }
        add(rp);
        revalidate();
        repaint();

    }
}
