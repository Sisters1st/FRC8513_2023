package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;

public class Setting {

    //drive motor settings
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

    //wrist settings
    public static int wristMotorCANID = 8;
    public static int wristMotorPDPPort = 8;
    public static MotorType wristMotorType = MotorType.kBrushless;
    public static IdleMode wristMotorIdleMode = IdleMode.kBrake;
    public static int wristMotorCurrentLimit = 40;
    public static Boolean wristMotorInverted = false;
    public static double wristTHold = 5;

    //arm settings
    public static int armMotorCANID = 8;
    public static int armMotorPDPPort = 8;
    public static MotorType armMotorType = MotorType.kBrushless;
    public static IdleMode armMotorIdleMode = IdleMode.kBrake;
    public static int armMotorCurrentLimit = 40;
    public static Boolean armMotorInverted = false;
    public static double armTHold = 5;

    //claw settings
    public static int clawMotorCANID = 8;
    public static int clawMotorPDPPort = 8;
    public static MotorType clawMotorType = MotorType.kBrushless;
    public static IdleMode clawMotorIdleMode = IdleMode.kBrake;
    public static int clawMotorCurrentLimit = 40;
    public static Boolean clawMotorInverted = false;
    public static double clawTHold = 5;

    //drivebase settings
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

    //turn PID
    public static double turnPID_p = 1;
    public static double turnPID_i = .0001;
    public static double turnPID_d = .01;

    //drive PID
    public static double drivePID_p = 1;
    public static double drivePID_i = .0001;
    public static double drivePID_d = .01;

    //arm PID
    public static double armPID_p = 1;
    public static double armPID_i = .0001;
    public static double armPID_d = .001;
    
    //claw PID
    public static double clawPID_p = 1;
    public static double clawPID_i = .0001;
    public static double clawPID_d = .001;

    //wrist PID
    public static double wristPID_p = 1;
    public static double wristPID_i = .0001;
    public static double wristPID_d = .001;

    //Button settings
    public static final int toggleAutomaticControlButtonNum = 2;
    public static final int scoreHighButtonNum = 3;
    public static final int pickUpButtonNum = 4;
    public static final int drivebaseAutomaticControlButtonNum = 7;
    public static final int armForwardButtonNum = 10;
    public static final int armBackwardButtonNum = 11;


    //POSITIONS & BUTTONS (arm/claw/wrist)
    //pickup cube from floor
    public static int cubePickupFlrButtonNum = 20;
    public static int cubePickupFlrArmPosition = 100;
    public static int cubePickupFlrClawPosition = 100;
    public static int cubePickupFlrWristPosition = 100;

    //pickup cone from floor
    public static int conePickupFlrButtonNum = 21;
    public static int conePickupFlrArmPosition = 100;
    public static int conePickupFlrClawPosition = 100;
    public static int conePickupFlrWristPosition = 100;

    //pickup cube from human player station
    public static int cubePickupHPSButtonNum = 22;
    public static int cubePickupHPSArmPosition = 100;
    public static int cubePickupHPSClawPosition = 100;
    public static int cubePickupHPSWristPosition = 100;

    //pickup cone from human player station
    public static int conePickupHPSButtonNum = 23;
    public static int conePickupHPSArmPosition = 100;
    public static int conePickupHPSClawPosition = 100;
    public static int conePickupHPSWristPosition = 100;

    //place cube on high
    public static int cubePlaceHighButtonNum = 24;
    public static int cubePlaceHighArmPosition = 100;
    public static int cubePlaceHighClawPosition = 100;
    public static int cubePlaceHighWristPosition = 100;

    //place cube on med
    public static int cubePlaceMedButtonNum = 25;
    public static int cubePlaceMedArmPosition = 100;
    public static int cubePlaceMedClawPosition = 100;
    public static int cubePlaceMedWristPosition = 100;

    //place cone on high
    public static int conePlaceHighButtonNum = 26;
    public static int conePlaceHighArmPosition = 100;
    public static int conePlaceHighClawPosition = 100;
    public static int conePlaceHighWristPosition = 100;

    //place cone on med
    public static int conePlaceMedButtonNum = 27;
    public static int conePlaceMedArmPosition = 100;
    public static int conePlaceMedClawPosition = 100;
    public static int conePlaceMedWristPosition = 100;
    
}
