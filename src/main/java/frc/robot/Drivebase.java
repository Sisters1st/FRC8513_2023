package frc.robot;

public class Drivebase {
    Robot thisRobot;
    public Drivebase(Robot thisRobotIn){
        thisRobot = thisRobotIn;
    }

    public void teleopPeriodic(){
        thisRobot.drivebaseAutomaticControl=false;
        driveDrivebase();
    }

    public void driveDrivebase(){
        if(thisRobot.drivebaseAutomaticControl){
            double avgDist = (thisRobot.leftPosition + thisRobot.rightPosition) / 2;

            double turnOut = thisRobot.turnPID.calculate(thisRobot.currentAngle, thisRobot.goalAngle);

            double driveOut = thisRobot.drivePID.calculate(avgDist, thisRobot.goalPosition);

            thisRobot.differentialDrivebase.tankDrive(driveOut, turnOut);
        } else {
            thisRobot.leftSpeed = thisRobot.driverJoystick.getRawAxis(Setting.driverJoystickLeftStickAxis);
            thisRobot.rightSpeed = thisRobot.driverJoystick.getRawAxis(Setting.driverJoystickLeftStickAxis); 
            thisRobot.differentialDrivebase.tankDrive(thisRobot.leftSpeed, thisRobot.rightSpeed);
        }
    }
}
