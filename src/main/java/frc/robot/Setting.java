package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;

public class Setting {

    public static int leftDriveMotor1CANID = 2;
    public static int leftDriveMotor1PDPPort = 2;

    public static int leftDriveMotor2CANID = 3;
    public static int leftDriveMotor2PDPPort = 3;

    public static int leftDriveMotor3CANID = 4;
    public static int leftDriveMotor3PDPPort = 4;

    public static int rightDriveMotor1CANID = 5;
    public static int rightDriveMotor1PDPPort = 5;

    public static int rightDriveMotor2CANID = 6;
    public static int rightDriveMotor2PDPPort = 6;

    public static int rightDriveMotor3CANID = 7;
    public static int rightDriveMotor3PDPPort = 7;

    public static int wristMotorCANID = 8;
    public static int wristMotorPDPPort = 8;
    public static MotorType wristMotorType = MotorType.kBrushless;
    public static IdleMode wristMotorIdleMode = IdleMode.kBrake;
    public static int wristMotorCurrentLimit = 40;
    public static Boolean wristMotorInverted = false;
    public static double wristTHold = 5;

    public static int armMotorCANID = 8;
    public static int armMotorPDPPort = 8;
    public static MotorType armMotorType = MotorType.kBrushless;
    public static IdleMode armMotorIdleMode = IdleMode.kBrake;
    public static int armMotorCurrentLimit = 40;
    public static Boolean armMotorInverted = false;
    public static double armTHold = 5;

    public static int clawMotorCANID = 8;
    public static int clawMotorPDPPort = 8;
    public static MotorType clawMotorType = MotorType.kBrushless;
    public static IdleMode clawMotorIdleMode = IdleMode.kBrake;
    public static int clawMotorCurrentLimit = 40;
    public static Boolean clawMotorInverted = false;
    public static double clawTHold = 5;

    public static MotorType drivebMotorType = MotorType.kBrushless;
    public static IdleMode drivebaseIdleMode = IdleMode.kBrake;
    public static int drivebaseCurrentLimit = 80;
    public static Boolean leftSideInverted = false;
    public static Boolean rightSideInverted = true;
    public static double drivebaseDistanceTHold = 10;
    public static double drivebaseAngTHold = 10;

    public static int PDPCANID = 1;
    public static ModuleType PDPType = ModuleType.kCTRE;

    public static int driverJoystickPort = 1;
    public static int opperatorJotstickPort = 0;

    public static int driverJoystickLeftStickAxis = 1;
    public static int driverJoystickRightStickAxis = 5;

    public static double turnPID_p = 1;
    public static double turnPID_i = .0001;
    public static double turnPID_d = .01;

    public static double drivePID_p = 1;
    public static double drivePID_i = .0001;
    public static double drivePID_d = .01;

    public static double armPID_p = 1;
    public static double armPID_i = .0001;
    public static double armPID_d = .001;
    
    public static double clawPID_p = 1;
    public static double clawPID_i = .0001;
    public static double clawPID_d = .001;

    public static double wristPID_p = 1;
    public static double wristPID_i = .0001;
    public static double wristPID_d = .001;

    //add arm/claw/wrist positions for different scenarios and the buttons associated with them
    
}
