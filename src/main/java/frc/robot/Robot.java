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
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    //Right
    if (robotContainer.joystick.getRawAxis(robotContainer.LEFT_RIGHT_AXIS) > 0){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.RIGHT);
    }

    //Left
    if (robotContainer.joystick.getRawAxis(robotContainer.LEFT_RIGHT_AXIS) < 0){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.LEFT);
    }

    //Forward
    if (robotContainer.joystick.getRawAxis(robotContainer.FOR_BACK_AXIS) < 0){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.FORWARD);
    }

    //Backward
    if (robotContainer.joystick.getRawAxis(robotContainer.FOR_BACK_AXIS) > 0){
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.BACKWARD);
    }

    //Stop
    if (robotContainer.joystick.getRawAxis(robotContainer.FOR_BACK_AXIS) == 0 &&  
        robotContainer.joystick.getRawAxis(robotContainer.LEFT_RIGHT_AXIS) == 0){
        
      new DrivetrainCommand(robotContainer.drivetrain, DrivetrainCommand.Type.STOP);
    }
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}