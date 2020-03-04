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
import frc.robot.commands.Color.ColorWheelMover;
import frc.robot.commands.Color.giveColor;
import frc.robot.commands.Color.moveToTargetColorCommand;



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
    Stick = new Joystick(0);
    Stick2 = new Joystick(1); 

    giveColorButton = new JoystickButton(Stick, 4);
    moveColorWheelButton = new JoystickButton(Stick2, 9);
    moveToTargetColorButton = new JoystickButton(Stick2, 8);
    
    intakeButton = new JoystickButton(Stick, 6); 
    outputButton = new JoystickButton(Stick, 5);

    cageLow = new JoystickButton(Stick2, 4);
    cageMedium = new JoystickButton(Stick2, 3);
    cageHigh = new JoystickButton(Stick2, 5); 
    
    climberButton = new JoystickButton(Stick2, 1); 

    outputButton.whileHeld(new outputMotorPressed());
    outputButton.whenReleased(new outputMotorReleased());
    intakeButton.whileHeld(new intakeMotorPressed());
    intakeButton.whenReleased(new intakeMotorReleased());

    cageLow.whenPressed(new setCageLow());
    cageMedium.whenPressed(new setCageMedium());
    cageHigh.whenPressed(new setCageHigh());

    climberButton.whileHeld(new climber());

      //driveTrigger.whileHeld(new Drive()); 

   
    giveColorButton.whenPressed(new giveColor());
    moveColorWheelButton.whenPressed(new ColorWheelMover());
    moveToTargetColorButton.whileHeld(new moveToTargetColorCommand());
    
    
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}