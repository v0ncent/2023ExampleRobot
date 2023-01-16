// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  private DriveTrain driveTrain;
  private Joystick joyStick;
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
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        //define our movespeed and rotatespeed variables with the get raw method of the joystick
        double moveSpeed = -joyStick.getRawAxis(Constants.OperatorConstants.JOYSTICK_MOVE_AXIS);//1 to -1
        double rotateSpeed = joyStick.getRawAxis(Constants.OperatorConstants.JOYSTICK_ROTATE_AXIS); // 1 to -1
        //call arcade drive method
        driveTrain.arcadeDrive(moveSpeed, rotateSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0); // when done moving, stop
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
