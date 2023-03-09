package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;

public class Setting {

    // drive motor settings
    public static int leftDriveMotor1CANID = 5;
    public static int leftDriveMotor1PDPPort = 2;

    public static int leftDriveMotor2CANID = 6;
    public static int leftDriveMotor2PDPPort = 3;

    public static int leftDriveMotor3CANID = 7;
    public static int leftDriveMotor3PDPPort = 4;

    public static int rightDriveMotor1CANID = 2;
    public static int rightDriveMotor1PDPPort = 5;

    public static int rightDriveMotor2CANID = 3;
    public static int rightDriveMotor2PDPPort = 6;

    public static int rightDriveMotor3CANID = 4;
    public static int rightDriveMotor3PDPPort = 7;

    // wrist settings
    public static int wristMotorCANID = 8;
    public static int wristMotorPDPPort = 8;
    public static MotorType wristMotorType = MotorType.kBrushless;
    public static IdleMode wristMotorIdleMode = IdleMode.kBrake;
    public static int wristMotorCurrentLimit = 15;
    public static Boolean wristMotorInverted = false;
    public static double wristTHold = 5;
    public static double wristForwardPower = 0.5;
    public static double wristReversePower = -0.5;

    public static double WristToArmRatio = 28 / 46; // this is made up and needs to be determined experimentally
    public static double armToWristRatio = -1; // this is made up and needs to be determined experimentally

    // arm settings
    public static int armMotorCANID = 1;
    public static int armMotorPDPPort = 9;
    public static MotorType armMotorType = MotorType.kBrushless;
    public static IdleMode armMotorIdleMode = IdleMode.kBrake;
    public static int armMotorCurrentLimit = 25;
    public static Boolean armMotorInverted = false;
    public static double armTHold = 5;
    public static double armForwardPower = 0.5;
    public static double armReversePower = -0.5;
    public static double armMaxSpeed = 1;

    // claw settings
    public static int clawMotorCANID = 9;
    public static int clawMotorPDPPort = 10;
    public static MotorType clawMotorType = MotorType.kBrushless;
    public static IdleMode clawMotorIdleMode = IdleMode.kBrake;
    public static int clawMotorCurrentLimit = 20;
    public static Boolean clawMotorInverted = false;
    public static double clawTHold = 5;
    public static double clawForwardPower = 0.5;
    public static double clawReversePower = -0.5;

    // drivebase settings
    public static MotorType drivebMotorType = MotorType.kBrushless;
    public static IdleMode drivebaseIdleMode = IdleMode.kBrake;
    public static int drivebaseCurrentLimit = 80;
    public static Boolean leftSideInverted = true;
    public static Boolean rightSideInverted = false;
    public static double drivebaseDistanceTHold = 10;
    public static double drivebaseAngTHold = 10;

    public static int PDPCANID = 0;
    public static ModuleType PDPType = ModuleType.kCTRE;

    public static int driverJoystickPort = 0;
    public static int opperatorJotstickPort = 1;
    public static int manualJoystickPort = 2;

    public static int driverJoystickLeftStickAxis = 1;
    public static int driverJoystickRightStickAxis = 5;
    public static int driverJoystickDriveAxis = 1;
    public static int driverJoystickTurnAxis = 4;

    // turn PID
    public static double turnPID_p = 1;
    public static double turnPID_i = .0001;
    public static double turnPID_d = .01;

    // drive PID
    public static double drivePID_p = 1;
    public static double drivePID_i = .0001;
    public static double drivePID_d = .01;

    // arm PID
    public static double armPID_p = 0.1;
    public static double armPID_i = 0.001;
    public static double armPID_d = 0.01;

    // claw PID
    public static double clawPID_p = 0.1;
    public static double clawPID_i = 0.001;
    public static double clawPID_d = 0.01;

    // wrist PID
    public static double wristPID_p = 0.1;
    public static double wristPID_i = 0.0;
    public static double wristPID_d = 0.01;

    // Automatic button settings
    public static final int toggleConeCubeModeButton = 5;
    public static final int toggleAutomaticArmControlButtonNum = 7;
    public static final int drivebaseAutomaticControlButtonNum = 9;
    public static final int toggleClawPositionButton = 6;
    public static final int resetSensorsButton = 8;

    public static final int scoreHighButtonNum = 4;
    public static final int scoreMidButtonNum = 3;
    public static final int pickUpHPButtonNum = 1;
    public static final int pickUpFloorButtonNum = 2;

    // Manual Button Settings
    public static final int armForwardButtonNum = 2;
    public static final int armBackwardButtonNum = 3;

    public static final int wristForwardButtonNum = 4;
    public static final int wristBackwardButtonNum = 1;

    public static final int clawForwardButtonNum = 6;
    public static final int clawBackwardButtonNum = 5;

    public static final int armJoystickControlAxis = 1;
    public static final int wristJoystickControlAxis = 5;


    //POSITIONS & BUTTONS (arm/claw/wrist)
    //pickup cube from floor
    public static double cubePickupFlrArmPosition = 189.3;
    public static double cubePickupFlrWristPosition = 88.1; //-101.2

    //pickup cone from floor
    public static double conePickupFlrArmPosition = 189.3;
    public static double conePickupFlrWristPosition = 88.1; //-101.2

    // pickup cube from human player station
    public static double cubePickupHPSArmPosition = 136.4;
    public static double cubePickupHPSWristPosition = 41.6; // -94.8

    // pickup cone from human player station
    public static double conePickupHPSArmPosition = 133.4;
    public static double conePickupHPSWristPosition = 39.4; // -94.1

    // place cube on high
    public static double cubePlaceHighArmPosition = 141.6;
    public static double cubePlaceHighWristPosition = 64.1; // -77.5

    // place cube on med
    public static double cubePlaceMedArmPosition = 146.8;
    public static double cubePlaceMedWristPosition = 50.9; // -95.9

    // place cone on high
    public static double conePlaceHighArmPosition = 133.9;
    public static double conePlaceHighWristPosition = 60.5; // -73.4

    // place cone on med
    public static double conePlaceMedArmPosition = 134.6;
    public static double conePlaceMedWristPosition = 39.5; // -95.1

    // claw positions for cone
    public static double clawClosedConePos = -4;
    public static double clawOpenConePos = -45;

    // claw positions for cube
    public static double clawClosedCubePos = -12;
    public static double clawOpenCubePos = -45;

    // claw folded range
    public static double armFoldedMin = -5;
    public static double armFoldedMax = 130;

    // CHARGING STATION THRESHOLDS & SPEEDS
    public static double pitchTHold = 7.0;
    public static double autoBalanceSpeed = 0.25;
    public static double autoBalanceTHold = 1;
    public static double balanceCountTHold = 50;

}
