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
        thisRobot.autoStep = 0;
    }

    public void autoPeriodic(){
        if(System.currentTimeMillis() > thisRobot.autoStartTime + thisRobot.autoWaitTime){
            if (thisRobot.m_autoSelected == thisRobot.kDriveStraightAndMoveArm) {
        
                switch (thisRobot.autoStep) {
                    case 0:
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

                        if(isRobotWithinThreshold()){
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    case 1:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 90;
                        thisRobot.goalPosition = 0;
                        thisRobot.drivebase.driveDrivebase();
        
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;
        
                        thisRobot.wristGoal = 220;
                        thisRobot.armGoal = 500;
                        thisRobot.clawGoal = 0;
                        thisRobot.arm.moveArm();
                        
                        if(isRobotWithinThreshold()){
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    default:
                        thisRobot.drivebaseAutomaticControl = false;
                        thisRobot.drivebase.driveDrivebase();
        
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;
                        thisRobot.arm.moveArm();
                        //dont drive and holt wrist arm claw in position
                }
                

            }
            if (thisRobot.m_autoSelected == thisRobot.kDriveStraight) {

                thisRobot.drivebaseAutomaticControl = true;
                thisRobot.goalAngle = 0;
                thisRobot.goalPosition = 1000;
                thisRobot.drivebase.driveDrivebase();

            }
            if (thisRobot.m_autoSelected == thisRobot.kDefaultAuto) {
            }
        } else {
            //wait for time to pass
        }
    }


    public boolean isRobotWithinThreshold(){

        if(Math.abs(thisRobot.wristGoal - thisRobot.wristPosition) > Setting.wristTHold){
            return false;
        }

        if(Math.abs(thisRobot.armGoal - thisRobot.armPosition) > Setting.armTHold){
            return false;
        }

        if(Math.abs(thisRobot.clawGoal - thisRobot.clawPosition) > Setting.clawTHold){
            return false;
        }

        if(Math.abs((thisRobot.leftPosition + thisRobot.rightPosition)/2 - thisRobot.armPosition) > Setting.drivebaseDistanceTHold){
            return false;
        }

        if(Math.abs(thisRobot.currentAngle - thisRobot.goalAngle) > Setting.drivebaseAngTHold){
            return false;
        }

        return true;
    }
}
