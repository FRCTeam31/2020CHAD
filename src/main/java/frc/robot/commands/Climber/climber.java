/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climber;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class climber extends Command {  
  DigitalInput input6 = RobotMap.input6;
  CANSparkMax climbMotor = RobotMap.climbMotor;
  boolean done = false;


  public climber() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
      requires(Robot.cls);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Robot.cls.upClimber(0.2);
    // Robot.cls.downClimber(0.2);
    // System.out.println("ClimbUp");
    if(OI.Stick2.getY() > 0 && input6.get() == false) {
      Robot.cls.stopClimber();
    }
    else {
      Robot.cls.upClimber(OI.Stick2.getY() * 0.7);
    } 

    ////////////////////////////////////////////////////////////////////////
    // if(OI.Stick2.getY() < 0.1 && OI.Stick2.getY() > -0.1 || input6.get() == false) {
    //   Robot.cls.stopClimber();
    // }
    // else if(OI.Stick2.getY() > 0.1 && input6.get() == false) {
    //   Robot.cls.upClimber(OI.Stick2.getY() * 0.5); 
    // }
    // else {
    //   Robot.cls.upClimber(OI.Stick2.getY() * 0.5);
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false; 
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.cls.stopClimber();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }


}