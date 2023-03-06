package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;

public class Setting {

    //drive motor settings
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

    //wrist settings
    public static int wristMotorCANID = 8;
    public static int wristMotorPDPPort = 8;
    public static MotorType wristMotorType = MotorType.kBrushless;
    public static IdleMode wristMotorIdleMode = IdleMode.kBrake;
    public static int wristMotorCurrentLimit = 40;
    public static Boolean wristMotorInverted = false;
    public static double wristTHold = 5;
    public static double wristForwardPower = 0.5;
    public static double wristReversePower = -0.5;

    //arm settings
    public static int armMotorCANID = 1;
    public static int armMotorPDPPort = 9;
    public static MotorType armMotorType = MotorType.kBrushless;
    public static IdleMode armMotorIdleMode = IdleMode.kBrake;
    public static int armMotorCurrentLimit = 40;
    public static Boolean armMotorInverted = false;
    public static double armTHold = 5;
    public static double armForwardPower = 0.5;
    public static double armReversePower = -0.5;

    //claw settings
    public static int clawMotorCANID = 9;
    public static int clawMotorPDPPort = 10;
    public static MotorType clawMotorType = MotorType.kBrushless;
    public static IdleMode clawMotorIdleMode = IdleMode.kBrake;
    public static int clawMotorCurrentLimit = 40;
    public static Boolean clawMotorInverted = false;
    public static double clawTHold = 5;
    public static double clawForwardPower = 0.5;
    public static double clawReversePower = -0.5;

    //drivebase settings
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

    //Automatic button settings
    public static final int toggleConeCubeModeButton = 1;
    public static final int toggleAutomaticArmControlButtonNum = 2;
    public static final int drivebaseAutomaticControlButtonNum = 7;
    public static final int toggleClawPositionButton = 6;
    public static final int resetSensorsButton = 8;

    public static final int scoreHighButtonNum = 3;
    public static final int scoreMidButtonNum = 3;
    public static final int pickUpHPButtonNum = 4;
    public static final int pickUpFloorButtonNum = 5;
    
    //Manual Button Settings
    public static final int armForwardButtonNum = 2;
    public static final int armBackwardButtonNum = 3;

    public static final int wristForwardButtonNum = 4;
    public static final int wristBackwardButtonNum = 1;

    public static final int clawForwardButtonNum = 6;
    public static final int clawBackwardButtonNum = 5;


    //POSITIONS & BUTTONS (arm/claw/wrist)
    //pickup cube from floor
    public static int cubePickupFlrButtonNum = 20;
    public static int cubePickupFlrArmPosition = 100;
    public static int cubePickupFlrWristPosition = 100;

    //pickup cone from floor
    public static int conePickupFlrButtonNum = 21;
    public static int conePickupFlrArmPosition = 100;
    public static int conePickupFlrWristPosition = 100;

    //pickup cube from human player station
    public static int cubePickupHPSButtonNum = 22;
    public static int cubePickupHPSArmPosition = 100;
    public static int cubePickupHPSWristPosition = 100;

    //pickup cone from human player station
    public static int conePickupHPSButtonNum = 23;
    public static int conePickupHPSArmPosition = 100;
    public static int conePickupHPSWristPosition = 100;

    //place cube on high
    public static int cubePlaceHighButtonNum = 24;
    public static int cubePlaceHighArmPosition = 100;
    public static int cubePlaceHighWristPosition = 100;

    //place cube on med
    public static int cubePlaceMedButtonNum = 25;
    public static int cubePlaceMedArmPosition = 100;
    public static int cubePlaceMedWristPosition = 100;

    //place cone on high
    public static int conePlaceHighButtonNum = 26;
    public static int conePlaceHighArmPosition = 100;
    public static int conePlaceHighWristPosition = 100;

    //place cone on med
    public static int conePlaceMedButtonNum = 27;
    public static int conePlaceMedArmPosition = 100;
    public static int conePlaceMedWristPosition = 100;

    //claw positions for cone
    public static int clawClosedConePos = 400;
    public static int clawOpenConePos = 400;


    //claw positions for cube
    public static int clawClosedCubePos = 400;
    public static int clawOpenCubePos = 400;
    

    
}
