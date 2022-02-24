// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainCommand extends CommandBase {

  static enum Type {
      FORWARD, 
      BACKWARD, 
      FORWARD_RIGHT,
      FORWARD_LEFT,
      BACKWARD_RIGHT,
      BACKWARD_LEFT
    };

  Type type;

  public DrivetrainCommand(Type type) {
    this.type = type;
  }

  @Override
  public void initialize() {

  }
 
  @Override
  public void execute() {

  }
 
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
