package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Neo extends SubsystemBase {

    public Neo(){
        
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }

    public void spinNeo(double power){
      System.out.println("running");
    }
    
}
