package frc.robot;

import java.util.Set;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivebase {
    Robot thisRobot;
    public double sum = 0;
    public double pitchRate = 0;

    public Drivebase(Robot thisRobotIn) {
        thisRobot = thisRobotIn;
    }

    public void teleopPeriodic() {
        thisRobot.drivebaseAutomaticControl = false;
        if(thisRobot.driverJoystick.getRawButton(Setting.autoBalanceButton)){
            thisRobot.drivebase.autoBalance();
        }
        else if(thisRobot.driverJoystick.getRawButton(Setting.LLButtonNum)){
            thisRobot.drivebase.limelightDrive();
        }
        else{
            driveDrivebase();
        }
    }

    public void driveDrivebase() {
        if (thisRobot.drivebaseAutomaticControl) {
            double avgDist = -(thisRobot.leftPosition + thisRobot.rightPosition) / 2;

            double turnOut = thisRobot.turnPID.calculate(thisRobot.currentAngle, thisRobot.goalAngle);

            double driveOut = thisRobot.drivePID.calculate(avgDist, thisRobot.goalPosition);
            if(driveOut>Setting.maxDrivebasePow) {
                driveOut = Setting.maxDrivebasePow;
            }
            if(driveOut<-Setting.maxDrivebasePow) {
                driveOut = -Setting.maxDrivebasePow;
            }
            if(turnOut>Setting.maxTurnPow) {
                turnOut = Setting.maxTurnPow;
            }
            if(turnOut<-Setting.maxTurnPow) {
                turnOut = -Setting.maxTurnPow;
            }
            SmartDashboard.putNumber("Turnout", turnOut);
            SmartDashboard.putNumber("Driveout", driveOut);
            thisRobot.differentialDrivebase.arcadeDrive(-driveOut, turnOut);
        } else {
            thisRobot.driveSpeed = thisRobot.driverJoystick.getRawAxis(Setting.driverJoystickDriveAxis);
            thisRobot.turnSpeed = thisRobot.driverJoystick.getRawAxis(Setting.driverJoystickTurnAxis);
            thisRobot.differentialDrivebase.arcadeDrive(thisRobot.driveSpeed, thisRobot.turnSpeed);
        }
    }

    public void autoBalance() {

        pitchRate = thisRobot.pitch - thisRobot.previousPitch;
        if (thisRobot.pitch > Setting.pitchTHold && Math.abs(pitchRate)<Setting.PRTHold)
            thisRobot.differentialDrivebase.arcadeDrive(-Setting.autoBalanceSpeed, 0);
        else if (thisRobot.pitch < -Setting.pitchTHold && Math.abs(pitchRate)<Setting.PRTHold)
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

    public void limelightDrive() {
        double errorTurn = 0;
        double current = thisRobot.LL_X;
        if(sum==0)
            sum = thisRobot.LL_X;
        if(Math.abs(current-sum)<=100)
            sum = (sum*.6) + (current*.4);
        if(thisRobot.LL_Y<Setting.midLLY) {
            errorTurn = -1.5*(Setting.lowerGoalX - sum);
        }
        else {
            errorTurn = -1.5*(Setting.upperGoalX - sum);
        }
        double LLturn = thisRobot.turnPID.calculate(0, errorTurn);

        thisRobot.differentialDrivebase.arcadeDrive(thisRobot.driverJoystick.getRawAxis(Setting.driverJoystickDriveAxis), LLturn);

        
    }
}
