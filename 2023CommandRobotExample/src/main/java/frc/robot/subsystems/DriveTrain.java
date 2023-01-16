// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  // create motor objects
  private final WPI_VictorSPX leftFrontMotor;
  private final WPI_VictorSPX leftBackMotor;
  private final WPI_VictorSPX rightFrontMotor;
  private final WPI_VictorSPX rightBackMotor;

  // create motor control group
  private final MotorControllerGroup leftDrive;
  private final MotorControllerGroup rightDrive;

  // create differential drive
  private final DifferentialDrive differentialDrive;

  public DriveTrain() {
    // declare motors
    leftFrontMotor = new WPI_VictorSPX(Constants.MotorConstants.LEFT_FRONT_VIKTOR);
    leftBackMotor = new WPI_VictorSPX(Constants.MotorConstants.LEFT_BACK_VIKTOR);
    rightFrontMotor = new WPI_VictorSPX(Constants.MotorConstants.RIGHT_FRONT_VIKTOR);
    rightBackMotor = new WPI_VictorSPX(Constants.MotorConstants.RIGHT_BACK_VIKTOR);
   
    // define differential drives with motors
    leftDrive = new MotorControllerGroup(leftFrontMotor,leftBackMotor);
    leftDrive.setInverted(true); // so that we drive right
    rightDrive = new MotorControllerGroup(rightFrontMotor,rightBackMotor);

    // define differential drive with motor control groups
    differentialDrive = new DifferentialDrive(rightDrive, leftDrive);
  }

  // create arcade drive method
  public void  arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
