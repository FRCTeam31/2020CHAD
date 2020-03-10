/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LEDSubsystem {
    public void setLEDColor(String ledcolor){
        if("RED".equalsIgnoreCase(ledcolor)){
            for (int r = 0; r < RobotMap.ledbuffer.getLength(); r++) {
                RobotMap.ledbuffer.setRGB(r, 255, 0, 0);
            }
        }
        else if("GREEN".equalsIgnoreCase(ledcolor)){
            for (int g = 0; g < RobotMap.ledbuffer.getLength(); g++) {
                RobotMap.ledbuffer.setRGB(g, 0, 255, 0);
            }
        }
        else if("BLUE".equalsIgnoreCase(ledcolor)){
            for (int b = 0; b < RobotMap.ledbuffer.getLength(); b++) {
                RobotMap.ledbuffer.setRGB(b, 0, 0, 255);
            }
        }
        else{ 
            for (int w = 0; w < RobotMap.ledbuffer.getLength(); w++) {
                RobotMap.ledbuffer.setRGB(w, 100, 100, 100);
            }
        }
    }
}
