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
    public static int rigthDriveMotor1PDPPort = 5;

    public static int rightDriveMotor2CANID = 6;
    public static int rigthDriveMotor2PDPPort = 6;

    public static int rightDriveMotor3CANID = 7;
    public static int rigthDriveMotor3PDPPort = 7;

    public static MotorType drivebMotorType = MotorType.kBrushless;
    public static IdleMode drivebaseIdleMode = IdleMode.kBrake;
    public static int drivebaseCurrentLimit = 80;
    public static Boolean leftSideInverted = false;
    public static Boolean rightSideInverted = true;

    public static int PDPCANID = 1;
    public static ModuleType PDPType = ModuleType.kCTRE;

    public static int driverJoystickPort = 0;
    public static int opperatorJotstickPort = 1;
    
}
