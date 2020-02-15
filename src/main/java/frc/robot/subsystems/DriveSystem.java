/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.OI;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class DriveSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  // WPI_TalonSRX driveSystemRightFront = RobotMap.driveSystemRightFront;
  // WPI_TalonSRX driveSystemRightMiddle = RobotMap.driveSystemRightMiddle;
  // WPI_TalonSRX driveSystemRightRear = RobotMap.driveSystemRightRear;
  // WPI_TalonSRX driveSystemLeftFront = RobotMap.driveSystemLeftFront;
  // WPI_TalonSRX driveSystemLeftMiddle = RobotMap.driveSystemLeftMiddle;
  // WPI_TalonSRX driveSystemLeftRear = RobotMap.driveSystemLeftRear;
  // SpeedControllerGroup leftSide = new SpeedControllerGroup(driveSystemLeftFront, driveSystemLeftMiddle, driveSystemLeftRear);
  // SpeedControllerGroup rightSide = new SpeedControllerGroup(driveSystemRightFront, driveSystemRightMiddle, driveSystemRightRear);
  // DifferentialDrive differentialDrive = new DifferentialDrive(leftSide, rightSide);
  Joystick Stick = new Joystick(0);
  int Ticks;
  public static Drive RD;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public DriveSystem() {
    //setFollowers();

  }
  public void Driving() {
   // RobotMap.differentialDrive.arcadeDrive(-OI.Stick.getY() * 0.7, -OI.Stick.getX() * 0.8);
  }


  public void StopDrive() {
}


  /*public void setSpeed(double speed) {
    RD.arcadeDrive(speed, 0.0); 
  }*/


  // public void Reverse() {
  //   leftSide.setInverted(true);
  //   rightSide.setInverted(true);
  // }

  // public void setFollowers() {
  //   driveSystemLeftMiddle.follow(driveSystemLeftFront);
  //   driveSystemLeftRear.follow(driveSystemLeftFront);
  //   driveSystemRightMiddle.follow(driveSystemRightFront);
  //   driveSystemRightRear.follow(driveSystemRightFront);
  // }

  /*public void configTalonsForManual() {
    driveSystemLeftFront.changeControlMode(WPI_TalonSRX.SetControlMode(kFollower).PercentvBus);
  }*/

}