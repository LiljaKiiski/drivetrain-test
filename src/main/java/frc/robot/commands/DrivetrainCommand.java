// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainCommand extends CommandBase {

  public static enum Type { FORWARD, BACKWARD, RIGHT, LEFT, STOP };

  Type type;
  DrivetrainSubsystem drivetrain;
  boolean initialized = false;

  public DrivetrainCommand(DrivetrainSubsystem drivetrain, Type type) {
    this.type = type;
    this.drivetrain = drivetrain;
  }

  @Override
  public void initialize() {
    switch (type){
      case FORWARD:
        drivetrain.moveForward();
        break;

      case BACKWARD:
        drivetrain.moveBackward();
        break;

      case RIGHT:
        drivetrain.turnRight();
        break;

      case LEFT:
        drivetrain.turnLeft();
        break;

      case STOP:
        drivetrain.stopAllMotors();
        break;
    }
    initialized = true;
  }
 
  @Override
  public void execute() {

  }
 
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return initialized;
  }
}
