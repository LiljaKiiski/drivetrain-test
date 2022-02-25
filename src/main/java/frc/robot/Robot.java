// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer robotContainer;
  private DrivetrainSubsystem drivetrain;

  @Override
  public void robotInit() {
    drivetrain = new DrivetrainSubsystem();
    robotContainer = new RobotContainer(drivetrain);

  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    double axis_lr =robotContainer.joystick.getRawAxis(robotContainer.LEFT_RIGHT_AXIS);
    double axis_fb =robotContainer.joystick.getRawAxis(robotContainer.FOR_BACK_AXIS);

    //Forward
    if (axis_fb < -0.1){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.BACKWARD);
    }

    //Backward
    if (axis_fb > 0.1){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.FORWARD);
    }

     //Right
     if (axis_lr > 0.1){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.RIGHT);
    }

    //Left
    if (axis_lr < -0.1){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.LEFT);
    }

    //Stop
    if (axis_fb < 0.1 && axis_fb > -0.1 && axis_lr < 0.1 && axis_lr > -0.1){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.STOP);
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}