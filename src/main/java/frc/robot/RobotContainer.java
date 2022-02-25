// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public Joystick joystick;
  public DrivetrainSubsystem drivetrain;

  public final int FOR_BACK_AXIS = 5;
  public final int LEFT_RIGHT_AXIS = 0;

  public RobotContainer(DrivetrainSubsystem drivetrain) {
    joystick = new Joystick(0);
    this.drivetrain = drivetrain;
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    drivetrain.setDefaultCommand(new DrivetrainCommand(drivetrain, this));
  }

  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}