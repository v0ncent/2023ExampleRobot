package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Neo;

public class SpinNeos extends CommandBase {
    
    private Neo neo;
    public SpinNeos(Neo neo){
        this.neo = neo;
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        this.neo.spinNeos(1.0);
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
    
}
