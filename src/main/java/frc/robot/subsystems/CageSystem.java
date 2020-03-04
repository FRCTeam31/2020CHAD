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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CageSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonFX cageMotorMaster = RobotMap.cageMotorMaster;
  WPI_TalonSRX cageMotorFollow = RobotMap.cageMotorFollow;
  DigitalInput limitSwitchLow = RobotMap.limitSwitchLow; 
  DigitalInput limitSwitchMedium = RobotMap.limitSwitchMedium;
  DigitalInput limitSwitchHigh = RobotMap.limitSwitchHigh;  
  boolean limitSwitch = true;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new setCageHigh());
  }

  public void setFollowers() { 
    cageMotorFollow.follow(cageMotorMaster);
  }
  

  public void setHigh() {
    setFollowers();
    limitSwitch = true;
    while(limitSwitch == limitSwitchHigh.get()) {
      System.out.println(limitSwitchHigh.get()); 
      cageMotorMaster.set(0.2);
      if(limitSwitch == !limitSwitchHigh.get()) {
        System.out.println(limitSwitchHigh.get()); 
        cageMotorMaster.set(0); 
      }
    }
  }

  public void setLow() {
    setFollowers();
    limitSwitch = true;
    while(limitSwitch == limitSwitchLow.get()) {
      System.out.println(limitSwitchLow.get()); 
      cageMotorMaster.set(-0.2);
      if(limitSwitch == !limitSwitchLow.get()) {
        System.out.println(limitSwitchLow.get()); 
        cageMotorMaster.set(0); 
      }
    }
  }

  public void setMedium() {
    limitSwitch = true;
    if(limitSwitchHigh.get() == false){
      while(limitSwitch == limitSwitchMedium.get()){
      cageMotorMaster.set(0.2);
      if(limitSwitch == !limitSwitchMedium.get()) {
        System.out.println(limitSwitchMedium.get()); 
        cageMotorMaster.set(0); 
        } 
      }
    }
    else if (limitSwitchLow.get() == false) {
      while(limitSwitch == limitSwitchMedium.get()){
        cageMotorMaster.set(-0.2);
        if(limitSwitch == !limitSwitchMedium.get()) {
          System.out.println(limitSwitchMedium.get()); 
          cageMotorMaster.set(0); 
        } 
      }
    }
    else {
      cageMotorMaster.set(0); 
    }
}


  public void stopMotor() {
    cageMotorMaster.set(0.0);
    cageMotorFollow.set(0.0);
  }
  
 
}