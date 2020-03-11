/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class intakeMotorPressed extends Command {
  boolean done = false; 

  public intakeMotorPressed() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.im); 
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Robot.im.initializeCounter(); 
    Robot.im.limitMotor();
    Robot.im.intakeMotorMoveIn();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.im.limitMotor();
    Robot.im.intakeMotorMoveIn();
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.im.limitMotor();
    Robot.im.intakeMotorMoveIn();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}