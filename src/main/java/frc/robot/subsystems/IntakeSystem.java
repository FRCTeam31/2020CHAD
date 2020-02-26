// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.command.Subsystem;
// import frc.robot.RobotMap;
// import edu.wpi.first.wpilibj.Counter; 

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// /**
//  * Add your docs here.
//  */
// public class IntakeSystem extends Subsystem {
//   // Put methods for controlling this subsystem
//   // here. Call these from Commands.
//   DigitalInput input = RobotMap.input;

//   //Counter Counter = new Counter(input); 
  
//   WPI_TalonFX intakeMotor = RobotMap.intakeMotor; 
  
//   // public boolean isSwitchSet() {
//   //   return Counter.get() < 1; 
//   // }

//   // public void initializeCounter() {
//   //   Counter.reset();
//   // }

//   public void intakeMotorMove(){
//     intakeMotor.set(.4);
    
//   }
//   public void intakeMoterStop(){
//     intakeMotor.set(0.0);
//   }

//   @Override
//   public void initDefaultCommand() {
//     // Set the default command for a subsystem here.
//     // setDefaultCommand(new MySpecialCommand());
//   }

//   public void limitMotor() {
//     if(input.get() == false) {
//       System.out.println("Sensor"); 
//       intakeMotor.set(0);
//     }
//     else {
//       intakeMotor.set(0.4); 
//     }
//   }

//   public void stopDrive() {
//   }
// }