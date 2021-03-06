/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
import frc.robot.RobotMap;
//import frc.robot.commands.Drive;
import frc.robot.commands.Drive.Drive;

/**
 * Add your docs here.
 */
public class DriveSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonFX driveSystemRightFront = RobotMap.driveSystemRightFront;
  WPI_TalonFX driveSystemRightMiddle = RobotMap.driveSystemRightMiddle;
  WPI_TalonFX driveSystemRightRear = RobotMap.driveSystemRightRear;
  WPI_TalonFX driveSystemLeftFront = RobotMap.driveSystemLeftFront;
  WPI_TalonFX driveSystemLeftMiddle = RobotMap.driveSystemLeftMiddle;
  WPI_TalonFX driveSystemLeftRear = RobotMap.driveSystemLeftRear;
  //WPI_TalonSRX driveSystemRightFront = RobotMap.driveSystemRightFront;
  // WPI_TalonSRX driveSystemRightMiddle = RobotMap.driveSystemRightMiddle;
  // WPI_TalonSRX driveSystemRightRear = RobotMap.driveSystemRightRear;
  // WPI_TalonSRX driveSystemLeftFront = RobotMap.driveSystemLeftFront;
  // WPI_TalonSRX driveSystemLeftMiddle = RobotMap.driveSystemLeftMiddle;
  // WPI_TalonSRX driveSystemLeftRear = RobotMap.driveSystemLeftRear;
  SpeedControllerGroup leftSide = new SpeedControllerGroup(driveSystemLeftFront, driveSystemLeftMiddle,
      driveSystemLeftRear);
  SpeedControllerGroup rightSide = new SpeedControllerGroup(driveSystemRightFront, driveSystemRightMiddle,
      driveSystemRightRear);
  public DifferentialDrive differentialDrive = new DifferentialDrive(leftSide, rightSide);
  // Joystick Stick = new Joystick(0);
  // int Ticks;
  // public static Drive RD;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
    //Set the default command for a subsystem here.
    //setDefaultCommand(new MySpecialCommand());
  }

  public DriveSystem() {
    setFollowers();
  }

  public void Driving() {
    if (OI.Stick.getRawAxis(3) > 0) {
      RobotMap.differentialDrive.arcadeDrive(-OI.Stick.getRawAxis(3), -OI.Stick.getRawAxis(0) * 0.4);
    } else if (OI.Stick.getRawAxis(2) > 0) {
      RobotMap.differentialDrive.arcadeDrive(OI.Stick.getRawAxis(2), -OI.Stick.getRawAxis(0) * 0.4);
    } else {
      RobotMap.differentialDrive.arcadeDrive(0, -OI.Stick.getRawAxis(0) * 0.6);

    }
  
  }

  public void enable() {
  }
  
  public void StopDrive() {
}


  


  public void Reverse() {
    leftSide.setInverted(true);
    rightSide.setInverted(true);
  }

  public void setFollowers() {
    driveSystemLeftMiddle.follow(driveSystemLeftFront);
    driveSystemLeftRear.follow(driveSystemLeftFront);
    driveSystemRightMiddle.follow(driveSystemRightFront);
    driveSystemRightRear.follow(driveSystemRightFront);
  }

//   public void configTalonsForManual() {
//     driveSystemLeftFront.changeControlMode(WPI_TalonSRX.SetControlMode(kFollower).PercentvBus);
//   }

    public void auton() {
        for(int q = 0; q < 100; q++) {
            leftSide.set(0.2); 
            rightSide.set(0.2); 
        }
        leftSide.set(0);
        rightSide.set(0);
    }

}