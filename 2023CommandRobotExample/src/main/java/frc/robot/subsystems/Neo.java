package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Neo extends SubsystemBase {

    CANSparkMax motor1,motor2,motor3,motor4,motor5;
    public Neo(){
        
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }

    public void spinNeo(double power){
      motor1.set(power);
    }

    public void spinNeos(double power){
      motor2.set(power);
      motor3.set(power);
      motor4.set(power);
      motor5.set(power);
    }
    
}
