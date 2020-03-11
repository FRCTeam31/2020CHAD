/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * Add your docs here.
 */
public class IntakeSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
//   DigitalInput input1 = RobotMap.input1;
//   DigitalInput input2 = RobotMap.input2;
//   DigitalInput input3 = RobotMap.input3;
//   DigitalInput input4 = RobotMap.input4;
//   DigitalInput input5 = RobotMap.input5;

  //Counter Counter = new Counter(input); 
  
  WPI_TalonSRX lowMotor = RobotMap.lowMotor; 


  public void intakeMotorMoveIn(){
    lowMotor.set(-1.0); 
  }
  public void intakeMotorMoveOut() {
    lowMotor.set(1.0); 
  }

  public void intakeMoterStop(){
    lowMotor.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void limitMotor() {
      lowMotor.set(-1.0);     
  }

  public void stopDrive() {
    lowMotor.set(0); 
    }
}