package frc.robot;

public class Drivebase {
    Robot thisRobot;

    public Drivebase(Robot thisRobotIn) {
        thisRobot = thisRobotIn;
    }

    public void teleopPeriodic() {
        thisRobot.drivebaseAutomaticControl = false;
        if(thisRobot.driverJoystick.getRawButton(Setting.autoBalanceButton)){
            thisRobot.drivebase.autoBalance();
        }
        else{
            driveDrivebase();
        }
    }

    public void driveDrivebase() {
        if (thisRobot.drivebaseAutomaticControl) {
            double avgDist = (thisRobot.leftPosition + thisRobot.rightPosition) / 2;

            double turnOut = thisRobot.turnPID.calculate(thisRobot.currentAngle, thisRobot.goalAngle);

            double driveOut = thisRobot.drivePID.calculate(avgDist, thisRobot.goalPosition);

            thisRobot.differentialDrivebase.tankDrive(driveOut, turnOut);
        } else {
            thisRobot.driveSpeed = thisRobot.driverJoystick.getRawAxis(Setting.driverJoystickDriveAxis);
            thisRobot.turnSpeed = thisRobot.driverJoystick.getRawAxis(Setting.driverJoystickTurnAxis);
            thisRobot.differentialDrivebase.arcadeDrive(thisRobot.driveSpeed, thisRobot.turnSpeed);
        }
    }

    public void autoBalance() {

        if (thisRobot.pitch > Setting.pitchTHold)
            thisRobot.differentialDrivebase.arcadeDrive(-Setting.autoBalanceSpeed, 0);
        else if (thisRobot.pitch < -Setting.pitchTHold)
            thisRobot.differentialDrivebase.arcadeDrive(Setting.autoBalanceSpeed, 0);
        else
            thisRobot.differentialDrivebase.arcadeDrive(0, 0);

        if (thisRobot.pitch > -Setting.autoBalanceTHold && thisRobot.pitch < Setting.autoBalanceTHold) {
            thisRobot.balanceCount++;
        } else {
            thisRobot.balanceCount = 0;
        }
        if (thisRobot.balanceCount > Setting.balanceCountTHold) {
            thisRobot.autoStep++;
            //thisRobot.resetSensors();
        }
    }
}
