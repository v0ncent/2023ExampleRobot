package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Neo;

public class SpinNeo extends CommandBase{

    private Neo neo;
    public SpinNeo(Neo neo){
        addRequirements(neo);
        this.neo = neo;
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        neo.spinNeo(1.0);
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
