// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  Joystick joystick;

  final int FOR_BACK_AXIS = 5;
  final int LEFT_RIGHT_AXIS = 0;

  public RobotContainer() {
    joystick = new Joystick(0);
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  
  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
