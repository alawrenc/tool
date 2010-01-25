package TOOL.Calibrate;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.GridLayout;
import java.util.HashMap;

public class JointsViewer extends JFrame {
    private JPanel framePanel;
    public static final int BOX_HEIGHT = 700;
    public static final int BOX_WIDTH = 300;

    //string constants
    public static final String HEADING = "Joint Values";
    public static final int NUM_JOINTS = 22;
    public static final String JOINT_STRINGS [] = { "HeadYaw",
                                                    "HeadPitch",
                                                    "LShoulderPitch",
                                                    "LShoulderRoll",
                                                    "LElbowYaw",
                                                    "LElbowRoll",
                                                    "LHipYawPitch",
                                                    "LHipRoll",
                                                    "LHipPitch",
                                                    "LKneePitch",
                                                    "LAnklePitch",
                                                    "LAnkleRoll",
                                                    "RHipYawPitch",
                                                    "RHipRoll",
                                                    "RHipPitch",
                                                    "RKneePitch",
                                                    "RAnklePitch",
                                                    "RAnkleRoll",
                                                    "RShoulderPitch",
                                                    "RShoulderRoll",
                                                    "RElbowYaw",
                                                    "RElbowRoll"
    };
    protected HashMap <Integer, String> jointIDStringMap;

    protected JointsViewer(){
        super("Joints Viewer");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setLayout(new GridLayout(2,NUM_JOINTS));
        framePanel = new JPanel();
        framePanel.setPreferredSize(new Dimension(BOX_HEIGHT, BOX_WIDTH));
        populateJointMap();
        populateFrame(framePanel);
        this.add(framePanel);
        setVisible(true);
    }

    private void populateJointMap(){
        jointIDStringMap = new HashMap<Integer, String>();
        for (int i = 0; i < NUM_JOINTS; i++){
            jointIDStringMap.put(i, JOINT_STRINGS[i]);
        }
    }

    private void populateFrame(JPanel f){
        for (int i = 0; i < NUM_JOINTS; i++){
            f.add(new JLabel(JOINT_STRINGS[i]));
        }
    }
}