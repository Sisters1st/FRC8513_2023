package frc.robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto {
    public Robot thisRobot;

    public Auto(Robot thisRobotParameter) {
        thisRobot = thisRobotParameter;
    }

    /** This function is run once at the beginning of each autonomous mode. */
    public void autoInit() {
        thisRobot.m_timer.reset();
        thisRobot.m_timer.start();
        thisRobot.autoStartingAngle = thisRobot.currentAngle;
        thisRobot.turnPID.reset();
        SmartDashboard.putNumber("autoStartingAngle", thisRobot.autoStartingAngle);
        thisRobot.leftDriveMotor1.getEncoder().setPosition(0);
        thisRobot.rightDriveMotor1.getEncoder().setPosition(0);
        thisRobot.drivePID.reset();
        thisRobot.autoStartTime = System.currentTimeMillis();
        thisRobot.autoWaitTime = Preferences.getInt("AutoWait", 0);
    }

    public void autoPeriodic(){
        if (thisRobot.m_autoSelected == thisRobot.kDriveStraightAndMoveArm) {

            thisRobot.drivebaseAutomaticControl = true;
            thisRobot.goalAngle = 0;
            thisRobot.goalPosition = 1000;
            thisRobot.drivebase.driveDrivebase();

            thisRobot.armAutomaticControl = true;
            thisRobot.clawAutomaticControl = true;
            thisRobot.wristAutomaticControl = true;

            thisRobot.wristGoal = 100;
            thisRobot.armGoal = 225;
            thisRobot.clawGoal = 45;
            thisRobot.arm.moveArm();

        }
        if (thisRobot.m_autoSelected == thisRobot.kDriveStraight) {

            thisRobot.drivebaseAutomaticControl = true;
            thisRobot.goalAngle = 0;
            thisRobot.goalPosition = 1000;
            thisRobot.drivebase.driveDrivebase();

        }
        if (thisRobot.m_autoSelected == thisRobot.kDefaultAuto) {
        }
    }
}
