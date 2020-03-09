package frc.robot.commands.Drive;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

  boolean done = false;
public Object differentialDrive;
  


  public Drive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
      requires(Robot.dt);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //System.out.println("Command");
    Robot.dt.Driving();
    done = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.dt.StopDrive();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }


}