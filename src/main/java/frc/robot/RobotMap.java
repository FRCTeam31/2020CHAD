package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.DriveSystem;

//import frc.robot.subsystems.DriveSystem;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static WPI_TalonFX driveSystemRightFront;
  public static WPI_TalonFX driveSystemRightMiddle;
  public static WPI_TalonFX driveSystemRightRear;
  public static WPI_TalonFX driveSystemLeftFront;
  public static WPI_TalonFX driveSystemLeftMiddle;
  public static WPI_TalonFX driveSystemLeftRear;

  public static WPI_TalonFX cageMotorMaster; 
  public static WPI_TalonSRX cageMotorFollow; 

  /*public static WPI_TalonSRX driveSystemRightFront;
  public static WPI_TalonSRX driveSystemRightMiddle;
  public static WPI_TalonSRX driveSystemRightRear;
  public static WPI_TalonSRX driveSystemLeftFront;
  public static WPI_TalonSRX driveSystemLeftMiddle;
  public static WPI_TalonSRX driveSystemLeftRear;*/

  public static WPI_TalonFX intakeMotor;
  public static CANSparkMax outputMotor; 

  public static CANSparkMax climbMotor; 

  public static DigitalInput input; 
  public static DigitalInput limitSwitchLow;
  public static DigitalInput limitSwitchMedium;
  public static DigitalInput limitSwitchHigh; 

  public static SpeedControllerGroup leftSide;
  public static SpeedControllerGroup rightSide;
  
  public static DifferentialDrive differentialDrive;
  
  public static DriveSystem driveSystem;

  
  public static void init() {
    driveSystemRightFront = new WPI_TalonFX(14);
    driveSystemRightFront.configOpenloopRamp(0.1, 0);
    driveSystemRightFront.setNeutralMode(NeutralMode.Brake);
    driveSystemRightMiddle = new WPI_TalonFX(12);
    driveSystemRightMiddle.setNeutralMode(NeutralMode.Brake);
    driveSystemRightMiddle.configOpenloopRamp(0.1, 0);
    driveSystemRightRear = new WPI_TalonFX(16);
    driveSystemRightRear.setNeutralMode(NeutralMode.Brake);
    driveSystemRightRear.configOpenloopRamp(0.1, 0);
    driveSystemLeftFront = new WPI_TalonFX(13);
    driveSystemLeftFront.setNeutralMode(NeutralMode.Brake);
    driveSystemLeftFront.configOpenloopRamp(0.1, 0);
    driveSystemLeftMiddle = new WPI_TalonFX(15);    
    driveSystemLeftMiddle.setNeutralMode(NeutralMode.Brake);
    driveSystemLeftMiddle.configOpenloopRamp(0.1, 0);
    driveSystemLeftRear = new WPI_TalonFX(11);
    driveSystemLeftRear.setNeutralMode(NeutralMode.Brake);
    driveSystemLeftRear.configOpenloopRamp(0.1,0);

    /*driveSystemRightFront = new WPI_TalonSRX(2);
    driveSystemRightFront.configOpenloopRamp(0.1, 0);
    driveSystemRightMiddle = new WPI_TalonSRX(3);
    driveSystemRightMiddle.configOpenloopRamp(0.1, 0);
    driveSystemRightRear = new WPI_TalonSRX(8);
    driveSystemRightRear.configOpenloopRamp(0.1, 0);
    driveSystemLeftFront = new WPI_TalonSRX(5);
    driveSystemLeftFront.configOpenloopRamp(0.1, 0);
    driveSystemLeftMiddle = new WPI_TalonSRX(6);
    driveSystemLeftMiddle.configOpenloopRamp(0.1, 0);
    driveSystemLeftRear = new WPI_TalonSRX(7);
    driveSystemLeftRear.configOpenloopRamp(0.1,0);*/

    input = new DigitalInput(0); 
    limitSwitchLow = new DigitalInput(4);
    limitSwitchMedium = new DigitalInput(5);
    limitSwitchHigh = new DigitalInput(6); 
    
    intakeMotor = new WPI_TalonFX(1); 
    outputMotor = new CANSparkMax(5, MotorType.kBrushless);

    cageMotorMaster = new WPI_TalonFX(1);
    cageMotorFollow = new WPI_TalonSRX(6); 

    climbMotor = new CANSparkMax(17, MotorType.kBrushless); 

    leftSide = new SpeedControllerGroup(driveSystemLeftFront, driveSystemLeftMiddle, driveSystemLeftRear);
    rightSide = new SpeedControllerGroup(driveSystemRightFront, driveSystemRightMiddle, driveSystemRightRear);

    differentialDrive = new DifferentialDrive(leftSide, rightSide);
    differentialDrive.setSafetyEnabled(true);
    /*differentialDrive.setExpiration(0.1);
    differentialDrive.setMaxOutput(0.1);*/

    }}