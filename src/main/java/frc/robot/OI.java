/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.commands.setCageHigh;
// import frc.robot.commands.intakeMotorPressed;
// import frc.robot.commands.intakeMotorReleased;
// import frc.robot.commands.outputMotorPressed;
// import frc.robot.commands.outputMotorReleased;
import frc.robot.commands.setCageLow;
import frc.robot.commands.setCageMedium;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  public static Joystick Stick = new Joystick(0);
  public static Joystick Stick2 = new Joystick(1); 
  public static JoystickButton driveTrigger;
  public static JoystickButton driveThrottle;
  public static JoystickButton intakeButton;
  public static JoystickButton outputButton; 
  public static JoystickButton cageMove; 
  public static JoystickButton cageLow;
  public static JoystickButton cageMedium;
  public static JoystickButton cageHigh; 

public OI()
  {
    Stick = new Joystick(0);
    driveTrigger = new JoystickButton(Stick, 1);
    driveThrottle = new JoystickButton(Stick, 2);

    intakeButton = new JoystickButton(Stick, 6); 
    outputButton = new JoystickButton(Stick, 5);

    
    cageLow = new JoystickButton(Stick2, 6);
    cageMedium = new JoystickButton(Stick2, 7);
    cageHigh = new JoystickButton(Stick2, 8); 

    // outputButton.whileHeld(new outputMotorPressed());
    // outputButton.whenReleased(new outputMotorReleased());
    // intakeButton.whileHeld(new intakeMotorPressed());
    // intakeButton.whenReleased(new intakeMotorReleased());

    cageLow.whenPressed(new setCageLow());
    cageMedium.whenPressed(new setCageMedium());
    cageHigh.whenPressed(new setCageHigh());

    //driveTrigger.whileHeld(new Drive()); 
  }

  public Joystick getJoystick() {
    return Stick; 
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
