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
                    // get arm into high position
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
                    // drive to station
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 100;
                        thisRobot.drivebase.driveDrivebase();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // balance on station
                    case 3:
                        thisRobot.drivebase.autoBalance();

                        thisRobot.arm.moveArm();
                        break;
                    // stop moving
                    case 4:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreCubeAndStation) {
                switch (thisRobot.autoStep) {
                    // get arm into high position
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
                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive to station
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // balance on station
                    case 3:
                        thisRobot.drivebase.autoBalance();

                        thisRobot.arm.moveArm();
                        break;
                    // stop moving
                    case 4:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreConeReloadScore) {
                switch (thisRobot.autoStep) {
                    // get arm into high position
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
                    // drive to get another cone and move arm to pickup from floor position
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

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
                        break;
                    // open claw to get cone
                    case 3:
                        thisRobot.clawGoal = Setting.clawClosedConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive back to score and move arm to high position
                    case 4:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

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
                    case 5:
                        thisRobot.clawGoal = Setting.clawOpenConePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // stop moving
                    case 6:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreCubeReloadScore) {
                switch (thisRobot.autoStep) {
                    // get arm into high position
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
                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive to get another cube and move arm to pickup from floor position
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.cubePickupFlrWristPosition;
                        thisRobot.armGoal = Setting.cubePickupFlrArmPosition;
                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // open claw to get cube
                    case 3:
                        thisRobot.clawGoal = Setting.clawClosedCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // drive back to score and move arm to high position
                    case 4:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 50;
                        thisRobot.drivebase.driveDrivebase();

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
                    case 5:
                        thisRobot.clawGoal = Setting.clawOpenCubePos;
                        thisRobot.arm.moveArm();

                        if (isRobotWithinThreshold()) {
                            thisRobot.autoStep++;
                            thisRobot.resetSensors();
                        }
                        break;
                    // stop moving
                    case 6:
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
                    case 3:
                        thisRobot.drivebase.autoBalance();

                        thisRobot.arm.moveArm();
                        break;
                    // stop moving
                    case 4:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = 0;

                        thisRobot.arm.moveArm();
                        break;
                }
            }
            if (thisRobot.m_autoSelected == thisRobot.kScoreConeAndBackUp) {
                switch (thisRobot.autoStep) {
                    // get arm into high position
                    case 0:
                        thisRobot.armAutomaticControl = true;
                        thisRobot.clawAutomaticControl = true;
                        thisRobot.wristAutomaticControl = true;

                        thisRobot.wristGoal = Setting.conePlaceMedWristPosition;
                        thisRobot.armGoal = Setting.conePlaceMedArmPosition;
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
                    // drive back
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = -62.4;
                        thisRobot.drivebase.driveDrivebase();
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
            if (thisRobot.m_autoSelected == thisRobot.kScoreCubeAndBackUp) {
                switch (thisRobot.autoStep) {
                    // get arm into high position
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
                    // drive back
                    case 2:
                        thisRobot.drivebaseAutomaticControl = true;
                        thisRobot.goalAngle = 0;
                        thisRobot.goalPosition = -62.4; // ths is -20 for testing. Should be -62.4 for competition
                        thisRobot.drivebase.driveDrivebase();
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

        if (Math.abs((thisRobot.leftPosition + thisRobot.rightPosition) / 2
                - thisRobot.goalPosition) > Setting.drivebaseDistanceTHold) {
            passedAllChecks = false;
        }

        if (Math.abs(thisRobot.currentAngle - thisRobot.goalAngle) > Setting.drivebaseAngTHold) {
            passedAllChecks = false;
        }
        if(passedAllChecks){
           thisRobot.autoTholdCount++;
        } else {
            thisRobot.autoTholdCount = 0;
        }
        if(thisRobot.autoTholdCount > Setting.inTholdCount)
            return true;

        return false;
    }
}
