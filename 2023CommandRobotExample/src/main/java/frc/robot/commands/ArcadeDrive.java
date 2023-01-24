// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  // subsystem and joystick
  private DriveTrain driveTrain;
  private Joystick joyStick;
  
  // variables for calculating move and rotate speed
  private double lastMoveSpeed;
  private double currentMoveSpeed;
  private double lastRotateSpeed;
  private double currentRotateSpeed;

  public ArcadeDrive(DriveTrain driveTrain, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    this.driveTrain = driveTrain;
    this.joyStick = joystick;
  } 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.arcadeDrive(0, 0);
    lastMoveSpeed = 0;
    currentMoveSpeed = 0;
    lastRotateSpeed = 0;
    currentRotateSpeed = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

        lastMoveSpeed = currentMoveSpeed;
        //define our movespeed and rotatespeed variables with the get raw values of the joystick
        currentMoveSpeed = -joyStick.getRawAxis(Constants.OperatorConstants.JOYSTICK_MOVE_AXIS);//1 to -1 x
        currentRotateSpeed = joyStick.getRawAxis(Constants.OperatorConstants.JOYSTICK_ROTATE_AXIS); // 1 to -1 x2

        double acceleration = 0.05;

        // forward - backwards
        if (Math.abs(currentMoveSpeed - lastMoveSpeed) > acceleration){
          if (currentMoveSpeed > lastMoveSpeed){
            currentMoveSpeed = lastMoveSpeed + acceleration;
          } else {
            currentMoveSpeed = lastMoveSpeed - acceleration;
          }
        } else {
          lastMoveSpeed = currentMoveSpeed;
        }

        // rotate
        if(Math.abs(currentRotateSpeed - lastRotateSpeed) > acceleration){
          if (currentRotateSpeed > lastRotateSpeed){
            currentRotateSpeed = lastRotateSpeed + acceleration;
          } else {
            currentRotateSpeed = lastRotateSpeed - acceleration;
          }
        } else {
          lastRotateSpeed = currentRotateSpeed;
        }
        
        // pass to arcade drive once calculations are finished above
        driveTrain.arcadeDrive(currentMoveSpeed, currentRotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0); // when done moving, stop
    lastMoveSpeed = 0;
    lastRotateSpeed = 0;
    currentRotateSpeed = 0;
    currentMoveSpeed = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
