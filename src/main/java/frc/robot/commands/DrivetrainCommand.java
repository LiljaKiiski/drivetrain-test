// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainCommand extends CommandBase {

  RobotContainer robotContainer;
  DrivetrainSubsystem drivetrain;

  public DrivetrainCommand(DrivetrainSubsystem drivetrain, RobotContainer robotContainer) {
    this.robotContainer = robotContainer;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    
  }
 
  @Override
  public void execute() {
    double axis_lr = robotContainer.joystick.getRawAxis(robotContainer.LEFT_RIGHT_AXIS);
    double axis_fb = robotContainer.joystick.getRawAxis(robotContainer.FOR_BACK_AXIS);

    //Forward
    if (axis_fb < -0.1){
      drivetrain.moveBackward();
    }

    //Backward
    if (axis_fb > 0.1){
      drivetrain.moveForward();
    }

     //Right
     if (axis_lr > 0.1){
      drivetrain.turnRight();
    }

    //Left
    if (axis_lr < -0.1){
      drivetrain.turnLeft();
    }

    //Stop
    if (axis_fb < 0.1 && axis_fb > -0.1 && axis_lr < 0.1 && axis_lr > -0.1){
      drivetrain.stopAllMotors();
    }

  }
 
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
