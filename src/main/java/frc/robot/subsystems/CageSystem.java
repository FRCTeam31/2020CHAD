/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CageSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX cageMotorMaster = RobotMap.cageMotorMaster;
  WPI_TalonSRX cageMotorFollow = RobotMap.cageMotorFollow;
  DigitalInput limitSwitchLow = RobotMap.limitSwitchLow; 
  DigitalInput limitSwitchMedium = RobotMap.limitSwitchMedium;
  DigitalInput limitSwitchHigh = RobotMap.limitSwitchHigh;  

  public void setFollowers() { 
    cageMotorFollow.follow(cageMotorMaster);
  }

  public void driveCage() {
    setFollowers(); 
    if(OI.Stick2.getRawAxis(1) > 0 && limitSwitchHigh.get() == false) {
      cageMotorMaster.set(0.2);
      cageMotorFollow.set(0.2); 
    }
    else if(OI.Stick2.getRawAxis(1) < 0 && limitSwitchLow.get() == false) {
      cageMotorMaster.set(-0.2); 
      cageMotorFollow.set(-0.2); 
    }
    else {
      cageMotorFollow.set(0.0);
      cageMotorMaster.set(0.0);
    }
  }  

  public void setHigh() {
    setFollowers();
    while(limitSwitchHigh.get() == false) {
      cageMotorMaster.set(0.2); 
      cageMotorFollow.set(0.2); 
    }
  }

  public void setLow() {
    setFollowers();
    while(limitSwitchLow.get() == false){
    cageMotorMaster.set(-0.2);
    cageMotorFollow.set(-0.2); 
    }
  }

  public void setMedium() {
    setFollowers();
    if(limitSwitchHigh.get() == true) {
      while(limitSwitchMedium.get() == false)
      {
        cageMotorMaster.set(-0.2);
        cageMotorFollow.set(-0.2);
      }
    }
    else if(limitSwitchLow.get() == true) {
      while(limitSwitchMedium.get() == false) {
        cageMotorMaster.set(0.2);
        cageMotorFollow.set(0.2);
      }
    }
    else {
      driveCage(); 
    }
  }


  public void stopMotor() {
    cageMotorMaster.set(0.0);
    cageMotorFollow.set(0.0);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
