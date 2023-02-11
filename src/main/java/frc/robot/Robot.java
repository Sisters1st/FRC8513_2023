// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.net.http.HttpClient.Redirect;
import java.util.Set;

import com.revrobotics.CANSparkMax;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  CANSparkMax leftDriveMotor1 = new CANSparkMax(Setting.leftDriveMotor1CANID, Setting.drivebMotorType);
  CANSparkMax leftDriveMotor2 = new CANSparkMax(Setting.leftDriveMotor2CANID, Setting.drivebMotorType);
  CANSparkMax leftDriveMotor3 = new CANSparkMax(Setting.leftDriveMotor3CANID, Setting.drivebMotorType);

  CANSparkMax rightDriveMotor1 = new CANSparkMax(Setting.rightDriveMotor1CANID, Setting.drivebMotorType);
  CANSparkMax rightDriveMotor2 = new CANSparkMax(Setting.rightDriveMotor2CANID, Setting.drivebMotorType);
  CANSparkMax rightDriveMotor3 = new CANSparkMax(Setting.rightDriveMotor3CANID, Setting.drivebMotorType);

  Joystick driverJoystick = new Joystick(Setting.driverJoystickPort);
  Joystick opperatorJoystick = new Joystick(Setting.opperatorJotstickPort);

  PowerDistribution PDP = new PowerDistribution(Setting.PDPCANID, Setting.PDPType);
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    leftDriveMotor1.setIdleMode(Setting.drivebaseIdleMode);
    leftDriveMotor1.setInverted(Setting.leftSideInverted);
    leftDriveMotor1.setSmartCurrentLimit(Setting.drivebaseCurrentLimit);

    leftDriveMotor2.setIdleMode(Setting.drivebaseIdleMode);
    leftDriveMotor2.setInverted(Setting.leftSideInverted);
    leftDriveMotor2.setSmartCurrentLimit(Setting.drivebaseCurrentLimit);

    leftDriveMotor3.setIdleMode(Setting.drivebaseIdleMode);
    leftDriveMotor3.setInverted(Setting.leftSideInverted);
    leftDriveMotor3.setSmartCurrentLimit(Setting.drivebaseCurrentLimit);

    rightDriveMotor1.setIdleMode(Setting.drivebaseIdleMode);
    rightDriveMotor1.setInverted(Setting.rightSideInverted);
    rightDriveMotor1.setSmartCurrentLimit(Setting.drivebaseCurrentLimit);

    rightDriveMotor2.setIdleMode(Setting.drivebaseIdleMode);
    rightDriveMotor2.setInverted(Setting.rightSideInverted);
    rightDriveMotor2.setSmartCurrentLimit(Setting.drivebaseCurrentLimit);

    rightDriveMotor3.setIdleMode(Setting.drivebaseIdleMode);
    rightDriveMotor3.setInverted(Setting.rightSideInverted);
    rightDriveMotor3.setSmartCurrentLimit(Setting.drivebaseCurrentLimit);

  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    SmartDashboard.putNumber("LeftDriveMotor1Ouput", leftDriveMotor1.getAppliedOutput());
    SmartDashboard.putNumber("LeftDriveMotor1Current", PDP.getCurrent(Setting.leftDriveMotor1PDPPort));

    SmartDashboard.putNumber("LeftDriveMotor1Ouput", leftDriveMotor1.getAppliedOutput());
    SmartDashboard.putNumber("LeftDriveMotor1Current", PDP.getCurrent(Setting.leftDriveMotor1PDPPort));

    SmartDashboard.putNumber("LeftDriveMotor2Ouput", leftDriveMotor2.getAppliedOutput());
    SmartDashboard.putNumber("LeftDriveMotor2Current", PDP.getCurrent(Setting.leftDriveMotor2PDPPort));

    SmartDashboard.putNumber("LeftDriveMotor3Ouput", leftDriveMotor3.getAppliedOutput());
    SmartDashboard.putNumber("LeftDriveMotor3Current", PDP.getCurrent(Setting.leftDriveMotor3PDPPort));

    SmartDashboard.putNumber("RightDriveMotor1Ouput", rightDriveMotor1.getAppliedOutput());
    SmartDashboard.putNumber("RightDriveMotor1Current", PDP.getCurrent(Setting.rightDriveMotor1PDPPort));

    SmartDashboard.putNumber("RightDriveMotor2Ouput", rightDriveMotor2.getAppliedOutput());
    SmartDashboard.putNumber("RightDriveMotor2Current", PDP.getCurrent(Setting.rightDriveMotor2PDPPort));

    SmartDashboard.putNumber("RightDriveMotor3Ouput", rightDriveMotor3.getAppliedOutput());
    SmartDashboard.putNumber("RightDriveMotor3Current", PDP.getCurrent(Setting.rightDriveMotor3PDPPort));

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
