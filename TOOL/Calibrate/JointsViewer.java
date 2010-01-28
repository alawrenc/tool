package TOOL.Calibrate;
import TOOL.Data.Frame;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;

public class JointsViewer extends JFrame {
    private JPanel framePanel;
    public static final int BOX_HEIGHT = 700;
    public static final int BOX_WIDTH = 200;

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

    protected JointsViewer() {
        super("Joints Viewer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        framePanel = createPanel();
        populateFrame(framePanel);

        setContentPane(framePanel);
        pack();
        setVisible(true);
    }

    private JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(NUM_JOINTS, 2, 5, 10));
        panel.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        return panel;
    }


    private void populateFrame(JPanel f) {
        populateJointMap();
        for (int i = 0; i < NUM_JOINTS; i++) {
            f.add( new JLabel(JOINT_STRINGS[i]), 2*i);
            f.add( new JLabel(Integer.toString(i)), 2*i+1 );
        }
    }

    private void populateJointMap() {
        jointIDStringMap = new HashMap<Integer, String>();
        for (int i = 0; i < NUM_JOINTS; i++) {
            jointIDStringMap.put(i, JOINT_STRINGS[i]);
        }
    }

    protected void update(Frame f) {
        System.out.println("update being called");
        List<Float> joints = f.joints();
        for (int i = 0; i < NUM_JOINTS; i++) {
            JLabel jointValue = (JLabel)framePanel.getComponent(2*i+1);
            jointValue.setText(joints.get(i).toString());
        }
    }
}