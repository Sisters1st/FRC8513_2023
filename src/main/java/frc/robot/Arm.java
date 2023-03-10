package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm {
    public Robot thisRobot;

    public Arm(Robot thisRobotParameter) {
        thisRobot = thisRobotParameter;
    }

    public void teleopInit() {
        // set the goals to the current position so the bot doesnt move when you enable,
        // default claw to close

        thisRobot.isClawClosed = true;
    }

    public void teleopPeriodic() {
        boolean toggleAutomaticControlButtonPressed = thisRobot.opperatorJoystick
                .getRawButtonPressed(Setting.toggleAutomaticArmControlButtonNum);
        if (toggleAutomaticControlButtonPressed) {
            thisRobot.armAutomaticControl = !thisRobot.armAutomaticControl;
            thisRobot.clawAutomaticControl = !thisRobot.clawAutomaticControl;
            thisRobot.wristAutomaticControl = !thisRobot.wristAutomaticControl;
            thisRobot.armGoal = thisRobot.armPosition;
            thisRobot.wristGoal = thisRobot.wristPosition;
            thisRobot.clawGoal = thisRobot.clawPosition;
        }

        // If toggle button pressed on the operator jostick, toggle cube cone mode
        boolean toggleCubeConeButtonPressed = thisRobot.opperatorJoystick
                .getRawButtonPressed(Setting.toggleConeCubeModeButton);
        if (toggleCubeConeButtonPressed) {
            thisRobot.armInConeMode = !thisRobot.armInConeMode;
        }

        // toggel claw open close
        boolean toggleClawButtonPressed = thisRobot.opperatorJoystick
                .getRawButtonPressed(Setting.toggleClawPositionButton);
        if (toggleClawButtonPressed) {
            thisRobot.isClawClosed = !thisRobot.isClawClosed;
        }

        boolean returnToStartingConfig = thisRobot.driverJoystick.getRawButtonPressed(Setting.startingConfigButton);
        if(returnToStartingConfig) {
            thisRobot.armPosition = 15;
            thisRobot.wristPosition = 0;
        }
        // if in cone mode, use cone setpoints. If in cube mode use cube setpoints
        if (thisRobot.armInConeMode) {

            if (thisRobot.isClawClosed) {
                thisRobot.clawGoal = Setting.clawClosedConePos;
            } else {
                thisRobot.clawGoal = Setting.clawOpenConePos;
            }

            boolean pickupFloorButtonPressed = thisRobot.opperatorJoystick
                    .getRawButtonPressed(Setting.pickUpFloorButtonNum);
            if (pickupFloorButtonPressed) {
                thisRobot.armGoal = Setting.conePickupFlrArmPosition;
                thisRobot.wristGoal = Setting.conePickupFlrWristPosition;
            }

            boolean pickupHPButtonPressed = thisRobot.opperatorJoystick.getRawButtonPressed(Setting.pickUpHPButtonNum);
            if (pickupHPButtonPressed) {
                thisRobot.armGoal = Setting.conePickupHPSArmPosition;
                thisRobot.wristGoal = Setting.conePickupHPSWristPosition;
            }

            boolean scoreHighButtonPressed = thisRobot.opperatorJoystick
                    .getRawButtonPressed(Setting.scoreHighButtonNum);
            if (scoreHighButtonPressed) {
                thisRobot.armGoal = Setting.conePlaceHighArmPosition;
                thisRobot.wristGoal = Setting.conePlaceHighWristPosition;
            }

            boolean scoreMidButtonPressed = thisRobot.opperatorJoystick.getRawButtonPressed(Setting.scoreMidButtonNum);
            if (scoreMidButtonPressed) {
                thisRobot.armGoal = Setting.conePlaceMedArmPosition;
                thisRobot.wristGoal = Setting.conePlaceMedWristPosition;
            }

        } else {
            // all cube positions
            if (thisRobot.isClawClosed) {
                thisRobot.clawGoal = Setting.clawClosedCubePos;
            } else {
                thisRobot.clawGoal = Setting.clawOpenCubePos;
            }

            boolean pickupFloorButtonPressed = thisRobot.opperatorJoystick
                    .getRawButtonPressed(Setting.pickUpFloorButtonNum);
            if (pickupFloorButtonPressed) {
                thisRobot.armGoal = Setting.cubePickupFlrArmPosition;
                thisRobot.wristGoal = Setting.cubePickupFlrWristPosition;
            }

            boolean pickupHPButtonPressed = thisRobot.opperatorJoystick.getRawButtonPressed(Setting.pickUpHPButtonNum);
            if (pickupHPButtonPressed) {
                thisRobot.armGoal = Setting.cubePickupHPSArmPosition;
                thisRobot.wristGoal = Setting.cubePickupHPSWristPosition;
            }

            boolean scoreHighButtonPressed = thisRobot.opperatorJoystick
                    .getRawButtonPressed(Setting.scoreHighButtonNum);
            if (scoreHighButtonPressed) {
                thisRobot.armGoal = Setting.cubePlaceHighArmPosition;
                thisRobot.wristGoal = Setting.cubePlaceHighWristPosition;
            }

            boolean scoreMidButtonPressed = thisRobot.opperatorJoystick.getRawButtonPressed(Setting.scoreMidButtonNum);
            if (scoreMidButtonPressed) {
                thisRobot.armGoal = Setting.cubePlaceMedArmPosition;
                thisRobot.wristGoal = Setting.cubePlaceMedWristPosition;
            }
        }
        moveArm();
    }

    public void moveArm() {
        if (thisRobot.armAutomaticControl) {
            double armPower = thisRobot.armPID.calculate(thisRobot.armPosition*18/22, thisRobot.armGoal);
            if(armPower > 1)
                armPower = 1;
            if(armPower < -1)
                armPower = -1;
            double armSpeed = Math.abs(thisRobot.armPosition - thisRobot.prevArmPosition);
            if(thisRobot.armPosition > Setting.armFoldedMax){
                if(armSpeed > Setting.armMaxSpeed / 2){
                    if(armPower > 0){
                        armPower = armPower - (armSpeed - Setting.armMaxSpeed / 2);
                    } else {
                        armPower = armPower + (armSpeed - Setting.armMaxSpeed / 2);
                    }
                }
            } else {
                if (armSpeed > Setting.armMaxSpeed) {
                    if (armPower > 0) {
                        armPower = armPower - (armSpeed - Setting.armMaxSpeed);
                    } else {
                        armPower = armPower + (armSpeed - Setting.armMaxSpeed);
                    }
                }
            }
            thisRobot.armMotor.set(armPower);

        } else {
            boolean armForward = thisRobot.manualJoystick.getRawButton(Setting.armForwardButtonNum);
            boolean armBackward = thisRobot.manualJoystick.getRawButton(Setting.armBackwardButtonNum);
            if (armForward) {
                thisRobot.armMotor.set(Setting.armForwardPower);
            }
            if (armBackward) {
                thisRobot.armMotor.set(Setting.armReversePower);
            }
            if (!(armForward || armBackward)) {
                double armJoystickPower = thisRobot.manualJoystick.getRawAxis(Setting.armJoystickControlAxis);
                thisRobot.armMotor.set(armJoystickPower);
            }
        }

        if (thisRobot.wristAutomaticControl) {
            // this takes the wrist goals we are setting (which will be just small offets)
            // and adds or subtracts them
            // the reason we have this is because as the arm rotates, the wrist moves as
            // well because of the way the chain is setup
            // in order to have the wrist not break itslef, we need to move the wrist while
            // the arm is moving in order to keep them in ralation to eachother
            // because of this, the goal for the wrist will be based off the arm position
            // plus/minus our goal
            // this will have the wrist move with the arm, but we can still control its
            // relative position by adding or subtracting some rotations

            // the armFoldedMin and max check ensures when the arm is above the robot, the
            // wrist stays folded in so the robot doesnt break 6'6"
            double wristPower;
            if (thisRobot.armPosition > Setting.armFoldedMin && thisRobot.armPosition < Setting.armFoldedMax) {
                wristPower = thisRobot.wristPID.calculate(thisRobot.wristPosition, thisRobot.armPosition * Setting.armToWristRatio);
                thisRobot.calculatedWristGoal = thisRobot.wristPosition;
            } else {
                thisRobot.calculatedWristGoal = thisRobot.armPosition * Setting.armToWristRatio + thisRobot.wristGoal;
                wristPower = thisRobot.wristPID.calculate(thisRobot.wristPosition, thisRobot.calculatedWristGoal);
            }
            thisRobot.wristMotor.set(wristPower);
        } else {
            boolean wristForward = thisRobot.manualJoystick.getRawButton(Setting.wristForwardButtonNum);
            boolean wristBackward = thisRobot.manualJoystick.getRawButton(Setting.wristBackwardButtonNum);
            if (wristForward) {
                thisRobot.wristMotor.set(Setting.wristForwardPower);
            }
            if (wristBackward) {
                thisRobot.wristMotor.set(Setting.wristReversePower);
            }
            if (!(wristForward || wristBackward)) {
                double wristJoystickPower = thisRobot.manualJoystick.getRawAxis(Setting.wristJoystickControlAxis);
                thisRobot.wristMotor.set(wristJoystickPower);
            }
        }
        SmartDashboard.putNumber("test1", 1);
        if (thisRobot.clawAutomaticControl) {
            SmartDashboard.putNumber("test2", 2);
            double clawPower = thisRobot.clawPID.calculate(thisRobot.clawPosition, thisRobot.clawGoal);
            thisRobot.clawMotor.set(clawPower);
            SmartDashboard.putNumber("clawPower", clawPower);
        } else {
            boolean clawForward = thisRobot.manualJoystick.getRawButton(Setting.clawForwardButtonNum);
            boolean clawBackward = thisRobot.manualJoystick.getRawButton(Setting.clawBackwardButtonNum);
            if (clawForward) {
                thisRobot.clawMotor.set(Setting.clawForwardPower);
            }
            if (clawBackward) {
                thisRobot.clawMotor.set(Setting.clawReversePower);
            }
            if (!(clawForward || clawBackward)) {
                thisRobot.clawMotor.set(0);
            }
        }
    }
}
