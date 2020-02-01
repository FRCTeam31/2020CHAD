/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.subsystems.DriveSystem;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static WPI_TalonSRX driveSystemRightFront;
  public static WPI_TalonSRX driveSystemRightMiddle;
  public static WPI_TalonSRX driveSystemRightRear;
  public static WPI_TalonSRX driveSystemLeftFront;
  public static WPI_TalonSRX driveSystemLeftMiddle;
  public static WPI_TalonSRX driveSystemLeftRear;
  public static SpeedControllerGroup leftSide;
  public static SpeedControllerGroup rightSide;
  public static DifferentialDrive differentialDrive;
  public static DriveSystem driveSystem;


  
  public static void init() {
    driveSystemRightFront = new WPI_TalonSRX(2);
    driveSystemRightFront.configOpenloopRamp(0.1, 0);
    driveSystemRightMiddle = new WPI_TalonSRX(3);
    driveSystemRightMiddle.configOpenloopRamp(0.1, 0);
    driveSystemRightRear = new WPI_TalonSRX(8);
    driveSystemRightRear.configOpenloopRamp(0.1, 0);
    driveSystemLeftFront = new WPI_TalonSRX(5);
    driveSystemLeftFront.configOpenloopRamp(0.1, 0);
    driveSystemLeftMiddle = new WPI_TalonSRX(6);
    driveSystemLeftMiddle.configOpenloopRamp(0.1, 0);
    driveSystemLeftRear = new WPI_TalonSRX(7);
    driveSystemLeftRear.configOpenloopRamp(0.1,0);

    leftSide = new SpeedControllerGroup(driveSystemLeftFront, driveSystemLeftMiddle, driveSystemLeftRear);
    rightSide = new SpeedControllerGroup(driveSystemRightFront, driveSystemRightMiddle, driveSystemRightRear);

    differentialDrive = new DifferentialDrive(leftSide, rightSide);
    differentialDrive.setSafetyEnabled(true);
    /*differentialDrive.setExpiration(0.1);
    differentialDrive.setMaxOutput(0.1);*/

    }

 
  // For example to map the left and right motors, you could define the
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
