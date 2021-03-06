/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ClimbingSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  CANSparkMax climbMotor = RobotMap.climbMotor; 
  DigitalInput input6 = RobotMap.input6;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new climbing());
  }
  public ClimbingSystem() {
  }

  public void upClimber(double upClimberSpeed) {
      //if((input6.get() == false && OI.Stick2.getRawAxis(1) < 0) || (OI.Stick2.getRawAxis(1) < 0))
      
      climbMotor.set(upClimberSpeed); 
      
    }

    public void downClimber(double downClimberSpeed){
      climbMotor.set(downClimberSpeed);
    }

  public void stopClimber() {
    climbMotor.set(0); 
  }

}