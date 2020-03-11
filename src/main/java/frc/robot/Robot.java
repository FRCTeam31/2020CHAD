package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.commands.AutonCommand;
import frc.robot.subsystems.CageSystem;
// import frc.robot.subsystems.CageSystem;
import frc.robot.subsystems.ClimbingSystem;
// import frc.robot.subsystems.ColorWheelSystem;
import frc.robot.subsystems.DriveSystem;
// import frc.robot.subsystems.IntakeSystem;
// import frc.robot.subsystems.OutputSystem; 
//import frc.robot.subsystems.climbSystem;
// import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.IntakeSystem;
import frc.robot.subsystems.OutputSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static OI oi;
  public static DriveSystem dt;
  // public static ColorWheelSystem cw;
  public static OutputSystem om;
  public static IntakeSystem im;
  public static CageSystem cs;
  public static ClimbingSystem cls;

  WPI_TalonFX driveSystemRightFront = RobotMap.driveSystemRightFront;
  WPI_TalonFX driveSystemRightMiddle = RobotMap.driveSystemRightMiddle;
  WPI_TalonFX driveSystemRightRear = RobotMap.driveSystemRightRear;
  WPI_TalonFX driveSystemLeftFront = RobotMap.driveSystemLeftFront;
  WPI_TalonFX driveSystemLeftMiddle = RobotMap.driveSystemLeftMiddle;
  WPI_TalonFX driveSystemLeftRear = RobotMap.driveSystemLeftRear;
 
  SpeedControllerGroup leftSide = new SpeedControllerGroup(driveSystemLeftFront, driveSystemLeftMiddle,
      driveSystemLeftRear);
  SpeedControllerGroup rightSide = new SpeedControllerGroup(driveSystemRightFront, driveSystemRightMiddle,
      driveSystemRightRear);
  //Command m_autonomousCommand;
  //public static Command m_autonomousCommand = new AutonCommand(); 
  public static SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.init();
     dt = new DriveSystem();
    // cw = new ColorWheelSystem();
    om = new OutputSystem();
    im = new IntakeSystem();
   cls = new ClimbingSystem();
   cs = new CageSystem(); 
    oi = new OI();

    SmartDashboard.putBoolean("Red Select", false);
    SmartDashboard.putBoolean("Green Select", false);
    SmartDashboard.putBoolean("Blue Select", false);
    SmartDashboard.putBoolean("Yellow Select", false);
    SmartDashboard.updateValues();
    System.out.println("initialized OI");

    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.start();
    //}
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp(); 
    if(time < 3) {
      leftSide.set(0.6);
      rightSide.set(0.6); 
    }
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
  //   if (m_autonomousCommand != null) {
  //     m_autonomousCommand.cancel();
  //   }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}