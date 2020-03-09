//*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.commands.Color.ColorWheelMover;
import frc.robot.commands.Color.giveColor;
// import frc.robot.commands.Color.moveToTargetColorCommand;
import frc.robot.commands.Drive.Drive;
import frc.robot.commands.Cage.setCageHigh;
import frc.robot.commands.Intake.intakeMotorPressed;
import frc.robot.commands.Intake.intakeMotorReleased;
import frc.robot.commands.Output.outputMotorPressed;
import frc.robot.commands.Output.outputMotorReleased;
import frc.robot.commands.Cage.setCageLow;
import frc.robot.commands.Cage.setCageMedium;
import frc.robot.commands.Climber.climber;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static Joystick Stick = new Joystick(0);
  public static Joystick Stick2 = new Joystick(1);
  // public static JoystickButton driveTrigger;
  // public static JoystickButton driveThrottle;
  public static JoystickButton giveColorButton;// press y
  public static JoystickButton moveColorWheelButton; // press x
  public static JoystickButton moveToTargetColorButton; // press hold b
    public static JoystickButton intakeButton;
    public static JoystickButton outputButton; 
    public static JoystickButton cageMove; 
    public static JoystickButton cageLow;
    public static JoystickButton cageMedium;
    public static JoystickButton cageHigh; 
    public static JoystickButton climberButton; 

  public OI() {
    // control /////////////////////////////////////////////
    Stick = new Joystick(0);
    Stick2 = new Joystick(1); 

    // color wheel related stuff ///////////////////////////////////////
    giveColorButton = new JoystickButton(Stick, 4);
    // moveColorWheelButton = new JoystickButton(Stick2, 9);
    // moveToTargetColorButton = new JoystickButton(Stick2, 8);
    

    // ball related stuff //////////////////////////////
    intakeButton = new JoystickButton(Stick, 6); 
    outputButton = new JoystickButton(Stick, 5);
    cageLow = new JoystickButton(Stick2, 4);
    cageMedium = new JoystickButton(Stick2, 3);
    cageHigh = new JoystickButton(Stick2, 5); 
    

    // climb related stuff /////////////////////////
    climberButton = new JoystickButton(Stick2, 1); 

    // ball related stuff //////////////////////////////////////
    outputButton.whileHeld(new outputMotorPressed());
    outputButton.whenReleased(new outputMotorReleased());
    intakeButton.whileHeld(new intakeMotorPressed());
    intakeButton.whenReleased(new intakeMotorReleased());
    cageLow.whenPressed(new setCageLow());
    cageMedium.whenPressed(new setCageMedium());
    cageHigh.whenPressed(new setCageHigh());

    //// climb related stuff /////////////////////////
    climberButton.whileHeld(new climber());


   // color wheel related stuff //////////////////////////////////////////////
    // giveColorButton.whenPressed(new giveColor());
    // moveColorWheelButton.whenPressed(new ColorWheelMover());
    // moveToTargetColorButton.whileHeld(new moveToTargetColorCommand());
    
    // UNUSED ////////////////////////////
    //driveTrigger.whileHeld(new Drive()); 
  }
}