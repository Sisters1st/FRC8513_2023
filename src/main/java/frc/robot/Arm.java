package frc.robot;

public class Arm {
    public Robot thisRobot;

    public Arm(Robot thisRobotParameter) {
        thisRobot = thisRobotParameter;
    }

    public void teleopPeriodic() {
        boolean pickUpButton = thisRobot.opperatorJoystick.getRawButtonPressed(4);
        if(pickUpButton) {
            thisRobot.armGoal = 0;
            thisRobot.clawGoal = 0;
            thisRobot.wristGoal = 0;
        }

        boolean scoreHighButton = thisRobot.opperatorJoystick.getRawButtonPressed(3);
        if(scoreHighButton) {
            thisRobot.armGoal = 800;
            thisRobot.clawGoal = 800;
            thisRobot.wristGoal = 800;
        }

        boolean toggleAutomaticControlButton = thisRobot.opperatorJoystick.getRawButtonPressed(2);
        if(toggleAutomaticControlButton) {
            thisRobot.armAutomaticControl = !thisRobot.armAutomaticControl;
            thisRobot.clawAutomaticControl = !thisRobot.clawAutomaticControl;
            thisRobot.wristAutomaticControl = !thisRobot.wristAutomaticControl;
        }

        moveArm();
        
    }
    
    public void moveArm(){
        if(thisRobot.armAutomaticControl) {
            double armError = thisRobot.armGoal - thisRobot.armPosition;
            double armPower = thisRobot.armPID.calculate(armError, thisRobot.armGoal);
            thisRobot.armMotor.set(armPower);
        }
        else {
            boolean armForward = thisRobot.opperatorJoystick.getRawButtonPressed(10);
            boolean armBackward = thisRobot.opperatorJoystick.getRawButtonPressed(11);
            if(armForward) {
                thisRobot.armMotor.set(0.5);
            }
            if(armBackward) {
                thisRobot.armMotor.set(-0.5);
            }
            if(!(armForward||armBackward)) {
                thisRobot.armMotor.set(0);
            }
        }

        
        if(thisRobot.wristAutomaticControl) {
            double wristError = thisRobot.wristGoal - thisRobot.wristPosition;
            double wristPower = thisRobot.wristPID.calculate(wristError, thisRobot.wristGoal);
            thisRobot.wristMotor.set(wristPower);
        }
        else {
            boolean wristForward = thisRobot.opperatorJoystick.getRawButtonPressed(10);
            boolean wristBackward = thisRobot.opperatorJoystick.getRawButtonPressed(11);
            if(wristForward) {
                thisRobot.wristMotor.set(0.5);
            }
            if(wristBackward) {
                thisRobot.wristMotor.set(-0.5);
            }
            if(!(wristForward||wristBackward)) {
                thisRobot.wristMotor.set(0);
            }
        }

        if(thisRobot.clawAutomaticControl) {
            double clawError = thisRobot.clawGoal - thisRobot.clawPosition;
            double clawPower = thisRobot.clawPID.calculate(clawError, thisRobot.clawGoal);
            thisRobot.clawMotor.set(clawPower);
        }
        else {
            boolean clawForward = thisRobot.opperatorJoystick.getRawButtonPressed(10);
            boolean clawBackward = thisRobot.opperatorJoystick.getRawButtonPressed(11);
            if(clawForward) {
                thisRobot.clawMotor.set(0.5);
            }
            if(clawBackward) {
                thisRobot.clawMotor.set(-0.5);
            }
            if(!(clawForward||clawBackward)) {
                thisRobot.clawMotor.set(0);
            }
        }
    }
}
