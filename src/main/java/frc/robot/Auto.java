package frc.robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto {
    public Robot thisRobot;

    public Auto(Robot thisRobotParameter) {
        thisRobot = thisRobotParameter;
    }

    /**
     * This function is run once at the beginning of each autonomous mode.
     */
    public void autoInit() {
        thisRobot.m_timer.reset();
        thisRobot.m_timer.start();
        thisRobot.autoStartingAngle = thisRobot.currentAngle;
        thisRobot.turnPID.reset();
        thisRobot.ahrs.reset();
        SmartDashboard.putNumber("autoStartingAngle", thisRobot.autoStartingAngle);
        thisRobot.leftDriveMotor1.getEncoder().setPosition(0);
        thisRobot.rightDriveMotor1.getEncoder().setPosition(0);
        thisRobot.drivePID.reset();
        thisRobot.autoStartTime = System.currentTimeMillis();
        thisRobot.autoWaitTime = Preferences.getInt("AutoWait", 0);
        thisRobot.autoStep = 0;
    }

    public void autoPeriodic() {
        if (System.currentTimeMillis() > thisRobot.autoStartTime + thisRobot.autoWaitTime) {
            if (thisRobot.m_autoSelected == thisRobot.kDriveStraight) {

                thisRobot.drivebaseAutomaticControl = true;
                thisRobot.goalAngle = 0;
                thisRobot.goalPosition = 50;
                thisRobot.drivebase.driveDrivebase();

            }
            if (thisRobot.m_autoSelected == thisRobot.kDefaultAuto) {
                // do nothing auto
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreConeAndStation) {
                switch (thisRobot.autoStep) {
                    // get arm into mid position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.conePlaceHighWristPosition;
                        thisRobot.armGoal = Setting.conePlaceHighArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cone
                    case 1:
                        thisRobot.clawGoal = Setting.clawOpenConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    //bring arm back to starting configuration
                    case 2:
                        thisRobot.armGoal = Setting.startingConfigPos;
                        thisRobot.wristGoal = Setting.wristFoldedInPosition;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive to station
                    case 3:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 30;
                        thisRobot.drivebase.driveDrivebase();
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // balance on station
                    case 4:
                        thisRobot.drivebase.autoBalance();

                        thisRobot.arm.moveArm();
                        break;
                    // stop moving
                    case 5:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreCubeAndStation) {
                switch (thisRobot.autoStep) {
                    // get arm into mid position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.cubePlaceBackwardWristPosition;
                        thisRobot.armGoal = Setting.cubePlaceBackwardArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cube
                    case 1:
                        thisRobot.clawGoal = Setting.cubePlaceBackwardClawPosition;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    //bring arm back to starting configuration
                    case 2:
                        thisRobot.armGoal = Setting.startingConfigPos;
                        thisRobot.wristGoal = Setting.wristFoldedInPosition;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive to station
                    case 3:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 30;
                        thisRobot.drivebase.driveDrivebase();
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // balance on station
                    case 4:
                        thisRobot.drivebase.autoBalance();
                        thisRobot.arm.moveArm();
                        break;
                    // stop moving
                    case 5:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreConeReloadScore) { // CHANGE BASED ON CUBE VERSION
                switch (thisRobot.autoStep) {
                    // get arm into mid position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.conePlaceHighWristPosition;
                        thisRobot.armGoal = Setting.conePlaceHighArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cone
                    case 1:
                        thisRobot.clawGoal = Setting.clawOpenConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    //drive to get another cone and bring arm back to starting configuration
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armGoal = Setting.startingConfigPos;
                        thisRobot.wristGoal = Setting.wristFoldedInPosition;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // move arm to pickup from floor position
                    case 3:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.conePickupFlrWristPosition;
                        thisRobot.armGoal = Setting.conePickupFlrArmPosition;
                        thisRobot.clawGoal = Setting.clawOpenConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        // open claw to get cone
                    case 4:
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive back to score and move arm to starting config
                    case 5:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armGoal = Setting.startingConfigPos;
                        thisRobot.wristGoal = Setting.wristFoldedInPosition;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // move arm to mid position
                    case 6:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.conePlaceHighWristPosition;
                        thisRobot.armGoal = Setting.conePlaceHighArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cone
                    case 7:
                        thisRobot.clawGoal = Setting.clawOpenConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // stop moving
                    case 8:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreCubeReloadScore) {
                switch (thisRobot.autoStep) {
                    // get arm into backward mid position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.cubePlaceBackwardWristPosition;
                        thisRobot.armGoal = Setting.cubePlaceBackwardArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cube
                    case 1:
                        thisRobot.clawGoal = Setting.cubePlaceBackwardClawPosition;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive to get another cube, close claw, and bring arm to floor
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 30;
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.armGoal = Setting.cubePickupFlrArmPosition;
                        thisRobot.wristGoal = Setting.cubePickupFlrWristPosition;
                        thisRobot.clawGoal = Setting.clawClosedCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw 
                    case 3:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive forward
                    case 4:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 30;
                        thisRobot.drivebase.driveDrivebase();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // close claw to secure cube
                    case 5:
                        thisRobot.clawGoal = Setting.clawClosedCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // turn 180 to go back
                    case 6:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 180;
                        thisRobot.drivebase.driveDrivebase();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive back to score and move arm to high
                    case 7:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 60; //CHANGE
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armGoal = Setting.cubePlaceHighArmPosition;
                        thisRobot.wristGoal = Setting.cubePlaceHighWristPosition;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cube
                    case 8:
                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // stop moving
                    case 9:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kStation) {
                switch (thisRobot.autoStep) {
                    // drive to station
                    case 0:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // balance on station
                    case 1:
                        thisRobot.drivebase.autoBalance();

                        thisRobot.arm.moveArm();
                        break;
                    // stop moving
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreConeAndBackUp) {
                switch (thisRobot.autoStep) {
                    // get arm into mid position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.conePlaceHighWristPosition;
                        thisRobot.armGoal = Setting.conePlaceHighArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cone
                    case 1:
                        thisRobot.clawGoal = Setting.clawOpenConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive back and move arm back to starting config
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = -62.4;
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armGoal = Setting.startingConfigPos;
                        thisRobot.wristGoal = Setting.wristFoldedInPosition;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // stop moving
                    case 3:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreCubeMidAndBackUp) {
                switch (thisRobot.autoStep) {
                    // get arm into mid position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.cubePlaceMedWristPosition;
                        thisRobot.armGoal = Setting.cubePlaceMedArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cube
                    case 1:
                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive back and move arm back to starting config
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = -62.4;
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armGoal = Setting.startingConfigPos;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.wristGoal = Setting.wristFoldedInPosition;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // stop moving
                    case 3:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreCubeHighAndBackUp) {
                switch (thisRobot.autoStep) {
                    // get arm into mid position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.cubePlaceHighWristPosition;
                        thisRobot.armGoal = Setting.cubePlaceHighArmPosition;
                        thisRobot.clawGoal = Setting.clawClosedCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to score cube
                    case 1:
                        thisRobot.autoStepTime = System.currentTimeMillis();
                        thisRobot.autoStep++;
                        thisRobot.arm.moveArm();
                        break;
                    case 2:
                        if (System.currentTimeMillis() - thisRobot.autoStepTime > 100) {
                            thisRobot.autoStep++;
                        }
                        thisRobot.arm.moveArm();
                        break;
                    case 3:
                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive back and move arm back to starting config
                    case 4:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = -67; //-62.4
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armGoal = Setting.startingConfigPos;
                        thisRobot.wristGoal = Setting.wristFoldedInPosition;
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // stop moving
                    case 5:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
        } else {
            // wait for time to pass
        }
    }

    public boolean isRobotWithinThreshold() {
        boolean passedAllChecks = true;
        if (Math.abs(thisRobot.calculatedWristGoal - thisRobot.wristPosition) > Setting.wristTHold) {
            passedAllChecks = false;
        }

        if (Math.abs(thisRobot.armGoal - thisRobot.armPosition) > Setting.armTHold) {
            passedAllChecks = false;
        }

        if (Math.abs(thisRobot.clawGoal - thisRobot.clawPosition) > Setting.clawTHold) {
            passedAllChecks = false;
        }

        if (Math.abs((-thisRobot.leftPosition + -thisRobot.rightPosition) / 2 - thisRobot.goalPosition) > Setting.drivebaseDistanceTHold) {
            passedAllChecks = false;
        }

        if (Math.abs(thisRobot.currentAngle - thisRobot.goalAngle) > Setting.drivebaseAngTHold) {
            passedAllChecks = false;
        }

        SmartDashboard.putBoolean("Passed All Checks", passedAllChecks);

        if (passedAllChecks) {
            thisRobot.autoTholdCount++;
        } else {
            thisRobot.autoTholdCount = 0;
        }

        if (thisRobot.autoTholdCount > Setting.inTholdCount)
            return true;
        return false;
    }
}
