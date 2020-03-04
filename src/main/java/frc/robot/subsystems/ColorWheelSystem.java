/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.DriverStation;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;




public class ColorWheelSystem extends Subsystem {

  private boolean finished  = false;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public ColorWheelSystem(){
    super();
    colorMatcher.addColorMatch(blue);
    System.out.println("Constructor ||||||||||||||||||||||||||||||||||||||||");
    colorMatcher.addColorMatch(green);
    colorMatcher.addColorMatch(red);
    colorMatcher.addColorMatch(yellow);
    encoder = funny.getEncoder();

  }
  @Override
  public void initDefaultCommand() {
  }

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();
  private final CANEncoder encoder;
 // private final Color blue = ColorMatch.makeColor(0.143, 0.427, 0.429);
 //3400  ,11498 ,11119

 //blue is : 0.130615234375  ,0.44189453125 ,0.42724609375 
 // green is: GB 0.17724609375  ,0.61376953125 ,0.208984375 ﻿
//red is: 0.5546875  ,0.328369140625 ,0.116943359375 ﻿
//yellow is: RGB 0.323974609375  ,0.572265625 ,0.103759765625 
 private final Color blue = ColorMatch.makeColor(0.130, 0.442, 0.420);
  private final Color green = ColorMatch.makeColor(0.177, 0.613, 0.208);
  private final Color red = ColorMatch.makeColor(0.551, 0.328, 0.114);
  private final Color yellow = ColorMatch.makeColor(0.323, 0.572, 0.103);
  

  double counter = 0;
  boolean isFinished = false;
  int bogusCounter = 0;


  public String giveColor() {
    finished = false;
    bogusCounter++;
    Color colorInput = colorSensor.getColor();
    String colorResponse;
    ColorMatchResult match = colorMatcher.matchClosestColor(colorInput);

    
    if (match.color == blue) {

      colorResponse = "BLUE";
    } else if (match.color == green) {
      colorResponse = "GREEN";
    } else if (match.color == red) {
      colorResponse = "RED";
    } else if (match.color == yellow) {
      colorResponse = "YELLOW";
    } else {
      colorResponse = " ";
    }
  
    // System.out.println(bogusCounter);
   // System.out.println(colorResponse);
     //System.out.println("RGB " + colorInput.red + "  ," +colorInput.green + " ," + colorInput.blue);
    // System.out.println("Color Input " + colorInput.toString());
    SmartDashboard.putString("ViewedColor", colorResponse);
   // SmartDashboard.updateValues();
    finished = true;
    return colorResponse;
  }

  private final CANSparkMax funny = new CANSparkMax(4, MotorType.kBrushless);
  //private final WPI_TalonFX a = new WPI_TalonFX(7);

  public void colorWheelRotate3Times() {
    encoder.setPosition(0);
      while(encoder.getPosition() < 4*7.71741943359){
        System.out.println(encoder.getPosition());
        funny.set(0.06);
     }
     funny.set(0);
  }

  public void colorWheelMover() {
    colorWheelRotate3Times();
  }

  public void moveToTargetColor() {
    giveColor();
    funny.setIdleMode(IdleMode.kBrake);
    String targetColor;
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if (gameData.length() > 0) {
      switch (gameData.charAt(0)) {
      case 'B':
        targetColor = "BLUE";
        break;
      case 'G':
        targetColor = "GREEN";
        break;
      case 'R':
        targetColor = "RED";
        break;
      case 'Y':
        targetColor = "YELLOW";
        break;
      default:
        targetColor = "RED";
        break;
      }
      switch (targetColor) {
      case "YELLOW":
        while (giveColor() != targetColor) {
          funny.set(0.06);
        }
        for(int i = 0; i < 77; i++){
        //  System.out.println("current color is " + giveColor());
          funny.set(0.06);
        }
      break;
      case "GREEN":
        while (giveColor() != targetColor) {
          // System.out.println("target color is " + targetColor);
          // System.out.println("current color is " + giveColor());
          funny.set(0.06);
        }
        for(int i = 0; i <75; i++){
          funny.set(0.06);
         // System.out.println("current color is " + giveColor());        
        }
      break;
      case "RED":
      while (giveColor() != targetColor) {
        // System.out.println("target color is " + targetColor);
        // System.out.println("current color is " + giveColor());
        funny.set(0.06);
      }
      for(int i = 0; i <75; i++){
        funny.set(0.06);
        //System.out.println("current color is " + giveColor());      
      }
    break;
    case "BLUE":
      while (giveColor() != targetColor) {
        // System.out.println("target color is " + targetColor);
        // System.out.println("current color is " + giveColor());
        funny.set(0.06);
      }
      for(int i = 0; i <75; i++){
        funny.set(0.06);
       // System.out.println("============================================================");
      }
    break;
    }
      while (giveColor() != targetColor) {
        funny.set(0.06);
      }
      funny.set(0);
    } else {
      funny.set(0);
    }
  }

  public void moveToTargetColorCommand() {
    moveToTargetColor();
  }

  public void colorWheelStop() {
    funny.set(0);
  }

  public boolean isFinished() {
    return finished;
  }

  // public void setFinished(boolean finished) {
  //   this.finished = finished;
  // }
}