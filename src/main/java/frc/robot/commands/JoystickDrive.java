// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class JoystickDrive extends CommandBase {

  Drivetrain drivetrain;
  Supplier<Double> horizontal;
  Supplier<Double> vertical;

  /** Creates a new JoystickDrive. */
  public JoystickDrive(Drivetrain drivetrain, Supplier<Double> horizontal, Supplier<Double> vertical) {
    this.drivetrain = drivetrain;
    this.horizontal = horizontal;
    this.vertical = vertical;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Get range on joystick axes
    //Get axis with: horizontal.get
   // horizontal.get(0);
    drivetrain.setSpeeds(vertical.get()+horizontal.get(), vertical.get()-horizontal.get());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
