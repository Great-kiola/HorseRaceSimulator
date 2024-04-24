package Part2.gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * Class: CustomTrackPanel
 * Description: JPanel that allows the user to select a track for the horses
 *
 *
 *
 * @Author Sam Chen Yu
 * @Version 1.0
 */
public class TrackPanel extends JPanel{

    // Depedency Injection
    Frame frame;

    // GUI Components
    JLabel titleLabel;
    JComboBox<String> trackList; // for selecting which track to edit
    JLabel lengthLabel, difficultyLabel, sceneryLabel;
    BufferedImage track1, track2, track3, track4;
    boolean track1Selected, track2Selected, track3Selected, track4Selected;
    JButton backButton;

    /**
     * Constructor for CustomTrackPanel
     * @param frame Frame object dependency injection
     */
    public CustomTrackPanel(Frame frame) {
        super();
        this.frame = frame;
        setSize(800, 800);
        setBackground(Color.BLACK);
        setLayout(null);
        loadImages();

        track1Selected = true;
        track2Selected = false;
        track3Selected = false;
        track4Selected = false;

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 100, 30);
        backButton.addActionListener(e -> {
            frame.mainPanel();
        });
        add(backButton);

        titleLabel = new JLabel("Customise Track");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(300, 50, 400, 30);
        add(titleLabel);

        trackList = new JComboBox<String>();
        trackList.setBounds(300, 100, 200, 30);
        trackList.addItem("Cheltenham");
        trackList.addItem("Ascot");
        trackList.addItem("Chester");
        trackList.addItem("Aintree");
        trackList.addActionListener(e -> {
            String selectedItem = (String)trackList.getSelectedItem();
            switch(selectedItem) {
                case "Cheltenham":
                    track1Selected = true;
                    track2Selected = false;
                    track3Selected = false;
                    track4Selected = false;
                    lengthLabel.setText("Length: 2.5 miles");
                    difficultyLabel.setText("Difficulty: 4/5");
                    sceneryLabel.setText("Scenery: 4/5");
                    break;
                case "Ascot":
                    track1Selected = false;
                    track2Selected = true;
                    track3Selected = false;
                    track4Selected = false;
                    lengthLabel.setText("Length: 5 miles");
                    difficultyLabel.setText("Difficulty: 2/5");
                    sceneryLabel.setText("Scenery: 2/5");
                    break;
                case "Chester":
                    track1Selected = false;
                    track2Selected = false;
                    track3Selected = true;
                    track4Selected = false;
                    lengthLabel.setText("Length: 7.5 miles");
                    difficultyLabel.setText("Difficulty: 5/5");
                    sceneryLabel.setText("Scenery: 4/5");
                    break;
                case "Aintree":
                    track1Selected = false;
                    track2Selected = false;
                    track3Selected = false;
                    track4Selected = true;
                    lengthLabel.setText("Length: 12 miles");
                    difficultyLabel.setText("Difficulty: 3/5");
                    sceneryLabel.setText("Scenery: 5/5");
                    break;
                default:
                    track1Selected = false;
                    track2Selected = false;
                    track3Selected = false;
                    track4Selected = false;
                    lengthLabel.setText("Length:");
                    difficultyLabel.setText("Difficulty:");
                    sceneryLabel.setText("Scenery:");
                    break;
            }
            repaint();
        });
        add(trackList);

        lengthLabel = new JLabel("Length: 2.5 miles");
        lengthLabel.setForeground(Color.WHITE);
        lengthLabel.setBounds(300, 150, 200, 30);
        add(lengthLabel);

        difficultyLabel = new JLabel("Difficulty: 2/5");
        difficultyLabel.setForeground(Color.WHITE);
        difficultyLabel.setBounds(300, 200, 200, 30);
        add(difficultyLabel);

        sceneryLabel = new JLabel("Scenery: 2/5");
        sceneryLabel.setForeground(Color.WHITE);
        sceneryLabel.setBounds(300, 250, 200, 30);
        add(sceneryLabel);

        setVisible(false);
    }


    /**
     * Load images from resources
     */
    public void loadImages() {
        // Load images from resources
        try {
            track1 = ImageIO.read(getClass().getResourceAsStream("/res/racetrack1.jpeg"));
            track2 = ImageIO.read(getClass().getResourceAsStream("/res/racetrack2.jpeg"));
            track3 = ImageIO.read(getClass().getResourceAsStream("/res/racetrack3.jpeg"));
            track4 = ImageIO.read(getClass().getResourceAsStream("/res/racetrack4.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image loading failure in CustomTrackPanel.java");
        }
    }

    /**
     * Paint the images on the panel
     * @param g Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(track1Selected) {
            g.drawImage(track1, 100, 300, 600, 300, null);
        } else if(track2Selected) {
            g.drawImage(track2, 100, 300, 600, 300, null);
        } else if(track3Selected) {
            g.drawImage(track3, 100, 300, 600, 300, null);
        } else if(track4Selected) {
            g.drawImage(track4, 100, 300, 600, 300, null);
        }

    }

    /**
     * Accessor for the track selected
     * @return int representing the track selected
     */
    public int getTrack() {
        if(track1Selected) {
            return 1;
        } else if(track2Selected) {
            return 2;
        } else if(track3Selected) {
            return 3;
        } else  {
            return 4;
        }
    }

    /**
     * Accessor for the track length.
     * Because the length of the track in the JPanel is the same, these are actually the speeds of the horses
     * which are limited on a longer track to simulate the feeling of a longer track.
     * @return int representing the track length
     */
    public int getTrackLength() {
        if(track1Selected) {
            return 20;
        } else if(track2Selected) {
            return 15;
        } else if(track3Selected) {
            return 7;
        } else  {
            return 2;
        }
    }


}
